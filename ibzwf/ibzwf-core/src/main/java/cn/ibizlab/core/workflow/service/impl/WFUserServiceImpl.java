package cn.ibizlab.core.workflow.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import cn.ibizlab.util.errors.BadRequestAlertException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.core.workflow.filter.WFUserSearchContext;
import cn.ibizlab.core.workflow.service.IWFUserService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.workflow.mapper.WFUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户] 服务对象接口实现
 */
@Slf4j
@Service("WFUserServiceImpl")
public class WFUserServiceImpl extends ServiceImpl<WFUserMapper, WFUser> implements IWFUserService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.workflow.service.IWFMemberService wfmemberService;
    @Autowired
    @Lazy
    IWFUserService proxyService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFUser et) {
        if(!this.retBool(this.baseMapper.insert(et))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getId()), et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<WFUser> list) {
        this.saveBatch(list, batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFUser et) {
        if(!update(et, (Wrapper) et.getUpdateWrapper(true).eq("userid", et.getId()))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getId()), et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<WFUser> list) {
        updateBatchById(list, batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result = removeById(key);
        return result ;
    }

    @Override
    @Transactional
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public WFUser get(String key) {
        WFUser et = getById(key);
        if(et == null){
            et = new WFUser();
            et.setId(key);
        }
        else {
        }
        return et;
    }

    @Override
    public WFUser getDraft(WFUser et) {
        return et;
    }

    @Override
    public boolean checkKey(WFUser et) {
        return (!ObjectUtils.isEmpty(et.getId())) && (!Objects.isNull(this.getById(et.getId())));
    }
    @Override
    @Transactional
    public boolean save(WFUser et) {
        if(!saveOrUpdate(et)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(WFUser et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? proxyService.update(et) : proxyService.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<WFUser> list) {
        List<WFUser> create = new ArrayList<>();
        List<WFUser> update = new ArrayList<>();
        for (WFUser et : list) {
            if (ObjectUtils.isEmpty(et.getId()) || ObjectUtils.isEmpty(getById(et.getId()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            proxyService.createBatch(create);
        }
        if (update.size() > 0) {
            proxyService.updateBatch(update);
        }
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<WFUser> list) {
        List<WFUser> create = new ArrayList<>();
        List<WFUser> update = new ArrayList<>();
        for (WFUser et : list) {
            if (ObjectUtils.isEmpty(et.getId()) || ObjectUtils.isEmpty(getById(et.getId()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            proxyService.createBatch(create);
        }
        if (update.size() > 0) {
            proxyService.updateBatch(update);
        }
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUser> searchDefault(WFUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUser> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }







    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

    @Override
    public List<WFUser> getWfuserByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<WFUser> getWfuserByEntities(List<WFUser> entities) {
        List ids =new ArrayList();
        for(WFUser entity : entities){
            Serializable id=entity.getId();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0) {
            return this.listByIds(ids);
        }
        else {
            return entities;
        }
    }




}



