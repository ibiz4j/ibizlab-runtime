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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.filter.WFGroupSearchContext;
import cn.ibizlab.core.workflow.service.IWFGroupService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.workflow.mapper.WFGroupMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[角色/用户组] 服务对象接口实现
 */
@Slf4j
@Service("WFGroupServiceImpl")
public class WFGroupServiceImpl extends ServiceImpl<WFGroupMapper, WFGroup> implements IWFGroupService {

    @Autowired
    @Lazy
    private cn.ibizlab.core.workflow.service.IWFMemberService wfmemberService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(WFGroup et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFGroup et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<WFGroup> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<WFGroup> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFGroup et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("groupid",et.getId())))
            return false;
        wfmemberService.saveByGroupid(et.getId(),et.getWfmember());
        CachedBeanCopier.copy(get(et.getId()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFGroup> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public WFGroup getDraft(WFGroup et) {
        return et;
    }

    @Override
    public boolean checkKey(WFGroup et) {
        return (!ObjectUtils.isEmpty(et.getId()))&&(!Objects.isNull(this.getById(et.getId())));
    }

    @Override
    @Transactional
    public boolean create(WFGroup et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        wfmemberService.saveByGroupid(et.getId(),et.getWfmember());
        CachedBeanCopier.copy(get(et.getId()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFGroup> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        wfmemberService.removeByGroupid(key) ;
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public WFGroup get(String key) {
        WFGroup et = getById(key);
        if(et==null){
            et=new WFGroup();
            et.setId(key);
        }
        else{
            et.setWfmember(wfmemberService.selectByGroupid(key));
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFGroup> searchDefault(WFGroupSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFGroup> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFGroup>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


}


