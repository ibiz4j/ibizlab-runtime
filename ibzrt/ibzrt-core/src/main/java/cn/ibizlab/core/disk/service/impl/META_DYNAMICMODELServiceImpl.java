package cn.ibizlab.core.disk.service.impl;

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
import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import cn.ibizlab.core.disk.filter.META_DYNAMICMODELSearchContext;
import cn.ibizlab.core.disk.service.IMETA_DYNAMICMODELService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.disk.client.META_DYNAMICMODELFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[动态模型] 服务对象接口实现
 */
@Slf4j
@Service
public class META_DYNAMICMODELServiceImpl implements IMETA_DYNAMICMODELService {

    @Autowired
    META_DYNAMICMODELFeignClient mETA_DYNAMICMODELFeignClient;


    @Override
    public boolean create(META_DYNAMICMODEL et) {
        META_DYNAMICMODEL rt = mETA_DYNAMICMODELFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<META_DYNAMICMODEL> list){
        mETA_DYNAMICMODELFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(META_DYNAMICMODEL et) {
        META_DYNAMICMODEL rt = mETA_DYNAMICMODELFeignClient.update(et.getConfigid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<META_DYNAMICMODEL> list){
        mETA_DYNAMICMODELFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String configid) {
        boolean result=mETA_DYNAMICMODELFeignClient.remove(configid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        mETA_DYNAMICMODELFeignClient.removeBatch(idList);
    }

    @Override
    public META_DYNAMICMODEL get(String configid) {
		META_DYNAMICMODEL et=mETA_DYNAMICMODELFeignClient.get(configid);
        if(et==null){
            et=new META_DYNAMICMODEL();
            et.setConfigid(configid);
        }
        else{
        }
        return  et;
    }

    @Override
    public META_DYNAMICMODEL getDraft(META_DYNAMICMODEL et) {
        et=mETA_DYNAMICMODELFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(META_DYNAMICMODEL et) {
        return mETA_DYNAMICMODELFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public META_DYNAMICMODEL init(META_DYNAMICMODEL et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean initBatch(List<META_DYNAMICMODEL> etList) {
        for(META_DYNAMICMODEL et : etList) {
            init(et);
        }
        return true;
    }

    @Override
    @Transactional
    public META_DYNAMICMODEL publish(META_DYNAMICMODEL et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean publishBatch(List<META_DYNAMICMODEL> etList) {
        for(META_DYNAMICMODEL et : etList) {
            publish(et);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(META_DYNAMICMODEL et) {
        boolean result = true;
        Object rt = mETA_DYNAMICMODELFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), META_DYNAMICMODEL.class);
                if (rt != null) {
                    CachedBeanCopier.copy(rt, et);
                }
            } else if (rt instanceof Boolean) {
                result = (boolean) rt;
            }
        } catch (Exception e) {
        }
            return result;
    }

    @Override
    public void saveBatch(List<META_DYNAMICMODEL> list) {
        mETA_DYNAMICMODELFeignClient.saveBatch(list) ;
    }



	@Override
    public List<META_DYNAMICMODEL> selectByPdynainstid(String configid) {
        META_DYNAMICMODELSearchContext context=new META_DYNAMICMODELSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_pdynainstid_eq(configid);
        return mETA_DYNAMICMODELFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByPdynainstid(String configid) {
        Set<String> delIds=new HashSet<String>();
        for(META_DYNAMICMODEL before:selectByPdynainstid(configid)){
            delIds.add(before.getConfigid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 数据集
     */
    @Override
    public Page<META_DYNAMICMODEL> searchDefault(META_DYNAMICMODELSearchContext context) {
        Page<META_DYNAMICMODEL> mETA_DYNAMICMODELs=mETA_DYNAMICMODELFeignClient.searchDefault(context);
        return mETA_DYNAMICMODELs;
    }

    /**
     * 查询集合 主实例数据查询
     */
    @Override
    public Page<META_DYNAMICMODEL> searchDynaInst(META_DYNAMICMODELSearchContext context) {
        Page<META_DYNAMICMODEL> mETA_DYNAMICMODELs=mETA_DYNAMICMODELFeignClient.searchDynaInst(context);
        return mETA_DYNAMICMODELs;
    }

}



