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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.IBZPost;
import cn.ibizlab.core.ou.filter.IBZPostSearchContext;
import cn.ibizlab.core.ou.service.IIBZPostService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.ou.client.IBZPostFeignClient;

/**
 * 实体[岗位] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZPostServiceImpl implements IIBZPostService {

    @Autowired
    IBZPostFeignClient iBZPostFeignClient;

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;

    @Override
    public IBZPost get(String postid) {
		IBZPost et=iBZPostFeignClient.get(postid);
        if(et==null){
            et=new IBZPost();
            et.setPostid(postid);
        }
        else{
        }
        return  et;
    }

    @Override
    @Transactional
    public boolean save(IBZPost et) {
        if(et.getPostid()==null) et.setPostid((String)et.getDefaultKey(true));
        if(!iBZPostFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZPost> list) {
        iBZPostFeignClient.saveBatch(list) ;
    }

    @Override
    public boolean update(IBZPost et) {
        IBZPost rt = iBZPostFeignClient.update(et.getPostid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZPost> list){
        iBZPostFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean checkKey(IBZPost et) {
        return iBZPostFeignClient.checkKey(et);
    }
    @Override
    public boolean remove(String postid) {
        boolean result=iBZPostFeignClient.remove(postid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZPostFeignClient.removeBatch(idList);
    }

    @Override
    public IBZPost getDraft(IBZPost et) {
        et=iBZPostFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean create(IBZPost et) {
        IBZPost rt = iBZPostFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZPost> list){
        iBZPostFeignClient.createBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZPost> searchDefault(IBZPostSearchContext context) {
        Page<IBZPost> iBZPosts=iBZPostFeignClient.searchDefault(context);
        return iBZPosts;
    }


}


