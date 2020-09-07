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
import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.filter.SysDeptMemberSearchContext;
import cn.ibizlab.core.ou.service.ISysDeptMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.SysDeptMemberFeignClient;

/**
 * 实体[部门成员] 服务对象接口实现
 */
@Slf4j
@Service
public class SysDeptMemberServiceImpl implements ISysDeptMemberService {

    @Autowired
    SysDeptMemberFeignClient sysDeptMemberFeignClient;


    @Override
    public boolean create(SysDeptMember et) {
        SysDeptMember rt = sysDeptMemberFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysDeptMember> list){
        sysDeptMemberFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysDeptMember et) {
        SysDeptMember rt = sysDeptMemberFeignClient.update(et.getMemberid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysDeptMember> list){
        sysDeptMemberFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String memberid) {
        boolean result=sysDeptMemberFeignClient.remove(memberid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysDeptMemberFeignClient.removeBatch(idList);
    }

    @Override
    public SysDeptMember get(String memberid) {
		SysDeptMember et=sysDeptMemberFeignClient.get(memberid);
        if(et==null){
            et=new SysDeptMember();
            et.setMemberid(memberid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysDeptMember getDraft(SysDeptMember et) {
        et=sysDeptMemberFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysDeptMember et) {
        return sysDeptMemberFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysDeptMember et) {
        if(et.getMemberid()==null) et.setMemberid((String)et.getDefaultKey(true));
        if(!sysDeptMemberFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysDeptMember> list) {
        sysDeptMemberFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysDeptMember> selectByDeptid(String deptid) {
        SysDeptMemberSearchContext context=new SysDeptMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_deptid_eq(deptid);
        return sysDeptMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByDeptid(String deptid) {
        Set<String> delIds=new HashSet<String>();
        for(SysDeptMember before:selectByDeptid(deptid)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<SysDeptMember> selectByUserid(String userid) {
        SysDeptMemberSearchContext context=new SysDeptMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_userid_eq(userid);
        return sysDeptMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByUserid(String userid) {
        Set<String> delIds=new HashSet<String>();
        for(SysDeptMember before:selectByUserid(userid)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<SysDeptMember> selectByPostid(String postid) {
        SysDeptMemberSearchContext context=new SysDeptMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_postid_eq(postid);
        return sysDeptMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByPostid(String postid) {
        Set<String> delIds=new HashSet<String>();
        for(SysDeptMember before:selectByPostid(postid)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysDeptMember> searchDefault(SysDeptMemberSearchContext context) {
        Page<SysDeptMember> sysDeptMembers=sysDeptMemberFeignClient.searchDefault(context);
        return sysDeptMembers;
    }



}



