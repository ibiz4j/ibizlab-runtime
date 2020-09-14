package cn.ibizlab.core.uaa.service.impl;

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
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;
import cn.ibizlab.core.uaa.service.ISysAppService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysAppFeignClient;

/**
 * 实体[应用] 服务对象接口实现
 */
@Slf4j
@Service
public class SysAppServiceImpl implements ISysAppService {

    @Autowired
    SysAppFeignClient sysAppFeignClient;


    @Override
    public boolean create(SysApp et) {
        SysApp rt = sysAppFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysApp> list){
        sysAppFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysApp et) {
        SysApp rt = sysAppFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysApp> list){
        sysAppFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=sysAppFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysAppFeignClient.removeBatch(idList);
    }

    @Override
    public SysApp get(String id) {
		SysApp et=sysAppFeignClient.get(id);
        if(et==null){
            et=new SysApp();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysApp getDraft(SysApp et) {
        et=sysAppFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysApp et) {
        return sysAppFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysApp et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!sysAppFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysApp> list) {
        sysAppFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysApp> selectBySystemid(String pssystemid) {
        SysAppSearchContext context=new SysAppSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_pssystemid_eq(pssystemid);
        return sysAppFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeBySystemid(String pssystemid) {
        Set<String> delIds=new HashSet<String>();
        for(SysApp before:selectBySystemid(pssystemid)){
            delIds.add(before.getId());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysApp> searchDefault(SysAppSearchContext context) {
        Page<SysApp> sysApps=sysAppFeignClient.searchDefault(context);
        return sysApps;
    }



}



