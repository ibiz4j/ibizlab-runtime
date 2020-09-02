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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysPSSystemFeignClient;

/**
 * 实体[系统] 服务对象接口实现
 */
@Slf4j
@Service
public class SysPSSystemServiceImpl implements ISysPSSystemService {

    @Autowired
    SysPSSystemFeignClient sysPSSystemFeignClient;


    @Override
    public boolean create(SysPSSystem et) {
        SysPSSystem rt = sysPSSystemFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysPSSystem> list){
        sysPSSystemFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysPSSystem et) {
        SysPSSystem rt = sysPSSystemFeignClient.update(et.getPssystemid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysPSSystem> list){
        sysPSSystemFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String pssystemid) {
        boolean result=sysPSSystemFeignClient.remove(pssystemid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysPSSystemFeignClient.removeBatch(idList);
    }

    @Override
    public SysPSSystem get(String pssystemid) {
		SysPSSystem et=sysPSSystemFeignClient.get(pssystemid);
        if(et==null){
            et=new SysPSSystem();
            et.setPssystemid(pssystemid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysPSSystem getDraft(SysPSSystem et) {
        et=sysPSSystemFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysPSSystem et) {
        return sysPSSystemFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysPSSystem et) {
        if(et.getPssystemid()==null) et.setPssystemid((String)et.getDefaultKey(true));
        if(!sysPSSystemFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysPSSystem> list) {
        sysPSSystemFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysPSSystem> searchDefault(SysPSSystemSearchContext context) {
        Page<SysPSSystem> sysPSSystems=sysPSSystemFeignClient.searchDefault(context);
        return sysPSSystems;
    }

    /**
     * 查询集合 Pick
     */
    @Override
    public Page<SysPSSystem> searchPick(SysPSSystemSearchContext context) {
        Page<SysPSSystem> sysPSSystems=sysPSSystemFeignClient.searchPick(context);
        return sysPSSystems;
    }



}



