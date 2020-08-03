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
import cn.ibizlab.core.workflow.domain.WFSystem;
import cn.ibizlab.core.workflow.filter.WFSystemSearchContext;
import cn.ibizlab.core.workflow.service.IWFSystemService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.workflow.client.WFSystemFeignClient;

/**
 * 实体[系统] 服务对象接口实现
 */
@Slf4j
@Service
public class WFSystemServiceImpl implements IWFSystemService {

    @Autowired
    WFSystemFeignClient wFSystemFeignClient;


    @Override
    public boolean create(WFSystem et) {
        WFSystem rt = wFSystemFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<WFSystem> list){
        wFSystemFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFSystem et) {
        WFSystem rt = wFSystemFeignClient.update(et.getPssystemid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<WFSystem> list){
        wFSystemFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String pssystemid) {
        boolean result=wFSystemFeignClient.remove(pssystemid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFSystemFeignClient.removeBatch(idList);
    }

    @Override
    public WFSystem get(String pssystemid) {
		WFSystem et=wFSystemFeignClient.get(pssystemid);
        if(et==null){
            et=new WFSystem();
            et.setPssystemid(pssystemid);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFSystem getDraft(WFSystem et) {
        et=wFSystemFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(WFSystem et) {
        return wFSystemFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFSystem et) {
        if(et.getPssystemid()==null) et.setPssystemid((String)et.getDefaultKey(true));
        if(!wFSystemFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<WFSystem> list) {
        wFSystemFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFSystem> searchDefault(WFSystemSearchContext context) {
        Page<WFSystem> wFSystems=wFSystemFeignClient.searchDefault(context);
        return wFSystems;
    }



}



