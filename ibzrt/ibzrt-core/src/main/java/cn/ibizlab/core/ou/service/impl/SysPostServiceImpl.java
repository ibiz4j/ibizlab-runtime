package cn.ibizlab.core.ou.service.impl;

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
import cn.ibizlab.core.ou.domain.SysPost;
import cn.ibizlab.core.ou.filter.SysPostSearchContext;
import cn.ibizlab.core.ou.service.ISysPostService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.SysPostFeignClient;

/**
 * 实体[岗位] 服务对象接口实现
 */
@Slf4j
@Service
public class SysPostServiceImpl implements ISysPostService {

    @Autowired
    SysPostFeignClient sysPostFeignClient;


    @Override
    public boolean create(SysPost et) {
        SysPost rt = sysPostFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysPost> list){
        sysPostFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysPost et) {
        SysPost rt = sysPostFeignClient.update(et.getPostid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysPost> list){
        sysPostFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String postid) {
        boolean result=sysPostFeignClient.remove(postid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysPostFeignClient.removeBatch(idList);
    }

    @Override
    public SysPost get(String postid) {
		SysPost et=sysPostFeignClient.get(postid);
        if(et==null){
            et=new SysPost();
            et.setPostid(postid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysPost getDraft(SysPost et) {
        et=sysPostFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysPost et) {
        return sysPostFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysPost et) {
        if(et.getPostid()==null) et.setPostid((String)et.getDefaultKey(true));
        if(!sysPostFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysPost> list) {
        sysPostFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysPost> searchDefault(SysPostSearchContext context) {
        Page<SysPost> sysPosts=sysPostFeignClient.searchDefault(context);
        return sysPosts;
    }




}



