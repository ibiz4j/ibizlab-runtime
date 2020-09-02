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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;
import cn.ibizlab.core.ou.service.IIBZDeptMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.IBZDeptMemberFeignClient;

/**
 * 实体[部门成员] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZDeptMemberServiceImpl implements IIBZDeptMemberService {

    @Autowired
    IBZDeptMemberFeignClient iBZDeptMemberFeignClient;


    @Override
    public boolean create(IBZDeptMember et) {
        IBZDeptMember rt = iBZDeptMemberFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZDeptMember> list){
        iBZDeptMemberFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(IBZDeptMember et) {
        IBZDeptMember rt = iBZDeptMemberFeignClient.update(et.getMemberid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZDeptMember> list){
        iBZDeptMemberFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String memberid) {
        boolean result=iBZDeptMemberFeignClient.remove(memberid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZDeptMemberFeignClient.removeBatch(idList);
    }

    @Override
    public IBZDeptMember get(String memberid) {
		IBZDeptMember et=iBZDeptMemberFeignClient.get(memberid);
        if(et==null){
            et=new IBZDeptMember();
            et.setMemberid(memberid);
        }
        else{
        }
        return  et;
    }

    @Override
    public IBZDeptMember getDraft(IBZDeptMember et) {
        et=iBZDeptMemberFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(IBZDeptMember et) {
        return iBZDeptMemberFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(IBZDeptMember et) {
        if(et.getMemberid()==null) et.setMemberid((String)et.getDefaultKey(true));
        if(!iBZDeptMemberFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZDeptMember> list) {
        iBZDeptMemberFeignClient.saveBatch(list) ;
    }



	@Override
    public List<IBZDeptMember> selectByDeptid(String deptid) {
        IBZDeptMemberSearchContext context=new IBZDeptMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_deptid_eq(deptid);
        return iBZDeptMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByDeptid(String deptid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZDeptMember before:selectByDeptid(deptid)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<IBZDeptMember> selectByUserid(String userid) {
        IBZDeptMemberSearchContext context=new IBZDeptMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_userid_eq(userid);
        return iBZDeptMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByUserid(String userid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZDeptMember before:selectByUserid(userid)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<IBZDeptMember> selectByPostid(String postid) {
        IBZDeptMemberSearchContext context=new IBZDeptMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_postid_eq(postid);
        return iBZDeptMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByPostid(String postid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZDeptMember before:selectByPostid(postid)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZDeptMember> searchDefault(IBZDeptMemberSearchContext context) {
        Page<IBZDeptMember> iBZDeptMembers=iBZDeptMemberFeignClient.searchDefault(context);
        return iBZDeptMembers;
    }



}



