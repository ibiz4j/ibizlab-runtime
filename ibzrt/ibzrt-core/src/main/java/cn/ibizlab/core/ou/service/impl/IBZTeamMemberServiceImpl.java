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
import cn.ibizlab.core.ou.domain.IBZTeamMember;
import cn.ibizlab.core.ou.filter.IBZTeamMemberSearchContext;
import cn.ibizlab.core.ou.service.IIBZTeamMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.IBZTeamMemberFeignClient;

/**
 * 实体[组成员] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZTeamMemberServiceImpl implements IIBZTeamMemberService {

    @Autowired
    IBZTeamMemberFeignClient iBZTeamMemberFeignClient;


    @Override
    public boolean create(IBZTeamMember et) {
        IBZTeamMember rt = iBZTeamMemberFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZTeamMember> list){
        iBZTeamMemberFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(IBZTeamMember et) {
        IBZTeamMember rt = iBZTeamMemberFeignClient.update(et.getTeammemberid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZTeamMember> list){
        iBZTeamMemberFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String teammemberid) {
        boolean result=iBZTeamMemberFeignClient.remove(teammemberid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZTeamMemberFeignClient.removeBatch(idList);
    }

    @Override
    public IBZTeamMember get(String teammemberid) {
		IBZTeamMember et=iBZTeamMemberFeignClient.get(teammemberid);
        if(et==null){
            et=new IBZTeamMember();
            et.setTeammemberid(teammemberid);
        }
        else{
        }
        return  et;
    }

    @Override
    public IBZTeamMember getDraft(IBZTeamMember et) {
        et=iBZTeamMemberFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(IBZTeamMember et) {
        return iBZTeamMemberFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(IBZTeamMember et) {
        if(et.getTeammemberid()==null) et.setTeammemberid((String)et.getDefaultKey(true));
        if(!iBZTeamMemberFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZTeamMember> list) {
        iBZTeamMemberFeignClient.saveBatch(list) ;
    }



	@Override
    public List<IBZTeamMember> selectByUserid(String userid) {
        IBZTeamMemberSearchContext context=new IBZTeamMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_userid_eq(userid);
        return iBZTeamMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByUserid(String userid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZTeamMember before:selectByUserid(userid)){
            delIds.add(before.getTeammemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<IBZTeamMember> selectByPostid(String postid) {
        IBZTeamMemberSearchContext context=new IBZTeamMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_postid_eq(postid);
        return iBZTeamMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByPostid(String postid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZTeamMember before:selectByPostid(postid)){
            delIds.add(before.getTeammemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<IBZTeamMember> selectByTeamid(String teamid) {
        IBZTeamMemberSearchContext context=new IBZTeamMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_teamid_eq(teamid);
        return iBZTeamMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByTeamid(String teamid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZTeamMember before:selectByTeamid(teamid)){
            delIds.add(before.getTeammemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZTeamMember> searchDefault(IBZTeamMemberSearchContext context) {
        Page<IBZTeamMember> iBZTeamMembers=iBZTeamMemberFeignClient.searchDefault(context);
        return iBZTeamMembers;
    }



}



