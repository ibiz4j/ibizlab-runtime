package cn.ibizlab.core.notify.service.impl;

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
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;
import cn.ibizlab.core.notify.service.IMsgTemplateService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.notify.mapper.MsgTemplateMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[消息模板] 服务对象接口实现
 */
@Slf4j
@Service("MsgTemplateServiceImpl")
public class MsgTemplateServiceImpl extends ServiceImpl<MsgTemplateMapper, MsgTemplate> implements IMsgTemplateService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.notify.service.IMsgOpenAccessService msgopenaccessService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(MsgTemplate et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTid()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<MsgTemplate> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(MsgTemplate et) {
        fillParentData(et);
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("tid",et.getTid())))
            return false;
        CachedBeanCopier.copy(get(et.getTid()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<MsgTemplate> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    @Transactional
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public MsgTemplate get(String key) {
        MsgTemplate et = getById(key);
        if(et==null){
            et=new MsgTemplate();
            et.setTid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public MsgTemplate getDraft(MsgTemplate et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(MsgTemplate et) {
        return (!ObjectUtils.isEmpty(et.getTid()))&&(!Objects.isNull(this.getById(et.getTid())));
    }
    @Override
    @Transactional
    public boolean save(MsgTemplate et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(MsgTemplate et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<MsgTemplate> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<MsgTemplate> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<MsgTemplate> selectByAccessId(String id) {
        return baseMapper.selectByAccessId(id);
    }
    @Override
    public void removeByAccessId(String id) {
        this.remove(new QueryWrapper<MsgTemplate>().eq("accessid",id));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<MsgTemplate> searchDefault(MsgTemplateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<MsgTemplate> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<MsgTemplate>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(MsgTemplate et){
        //实体关系[DER1N_MSG_TEMPLATE_MSG_OPEN_ACCESS_ACCESSID]
        if(!ObjectUtils.isEmpty(et.getAccessId())){
            cn.ibizlab.core.notify.domain.MsgOpenAccess openaccess=et.getOpenaccess();
            if(ObjectUtils.isEmpty(openaccess)){
                cn.ibizlab.core.notify.domain.MsgOpenAccess majorEntity=msgopenaccessService.get(et.getAccessId());
                et.setOpenaccess(majorEntity);
                openaccess=majorEntity;
            }
            et.setAccessName(openaccess.getName());
            et.setOpenType(openaccess.getOpenType());
        }
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



