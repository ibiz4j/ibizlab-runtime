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
import org.springframework.beans.factory.annotation.Value;
import cn.ibizlab.util.errors.BadRequestAlertException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFMember;
import cn.ibizlab.core.workflow.filter.WFMemberSearchContext;
import cn.ibizlab.core.workflow.service.IWFMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.workflow.client.WFMemberFeignClient;

/**
 * 实体[成员] 服务对象接口实现
 */
@Slf4j
@Service
public class WFMemberServiceImpl implements IWFMemberService {

    @Autowired
    WFMemberFeignClient wFMemberFeignClient;


    @Override
    public boolean create(WFMember et) {
        WFMember rt = wFMemberFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<WFMember> list){
        wFMemberFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFMember et) {
        WFMember rt = wFMemberFeignClient.update(et.getMemberid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<WFMember> list){
        wFMemberFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String memberid) {
        boolean result=wFMemberFeignClient.remove(memberid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFMemberFeignClient.removeBatch(idList);
    }

    @Override
    public WFMember get(String memberid) {
		WFMember et=wFMemberFeignClient.get(memberid);
        if(et==null){
            et=new WFMember();
            et.setMemberid(memberid);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFMember getDraft(WFMember et) {
        et=wFMemberFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(WFMember et) {
        return wFMemberFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFMember et) {
        if(et.getMemberid()==null) et.setMemberid((String)et.getDefaultKey(true));
        if(!wFMemberFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<WFMember> list) {
        wFMemberFeignClient.saveBatch(list) ;
    }



	@Override
    public List<WFMember> selectByGroupid(String id) {
        WFMemberSearchContext context=new WFMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_groupid_eq(id);
        return wFMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByGroupid(String id) {
        Set<String> delIds=new HashSet<String>();
        for(WFMember before:selectByGroupid(id)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

    @Autowired
    @Lazy
    IWFMemberService proxyService;
	@Override
    public void saveByGroupid(String id,List<WFMember> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<WFMember> _update=new ArrayList<WFMember>();
        List<WFMember> _create=new ArrayList<WFMember>();
        for(WFMember before:selectByGroupid(id)){
            delIds.add(before.getMemberid());
        }
        for(WFMember sub:list) {
            sub.setGroupid(id);
            if(ObjectUtils.isEmpty(sub.getMemberid()))
                sub.setMemberid((String)sub.getDefaultKey(true));
            if(delIds.contains(sub.getMemberid())) {
                delIds.remove(sub.getMemberid());
                _update.add(sub);
            }
            else
                _create.add(sub);
        }
        if(_update.size()>0)
            proxyService.updateBatch(_update);
        if(_create.size()>0)
            proxyService.createBatch(_create);
        if(delIds.size()>0)
            proxyService.removeBatch(delIds);
	}

	@Override
    public List<WFMember> selectByUserid(String id) {
        WFMemberSearchContext context=new WFMemberSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_userid_eq(id);
        return wFMemberFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByUserid(String id) {
        Set<String> delIds=new HashSet<String>();
        for(WFMember before:selectByUserid(id)){
            delIds.add(before.getMemberid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFMember> searchDefault(WFMemberSearchContext context) {
        Page<WFMember> wFMembers=wFMemberFeignClient.searchDefault(context);
        return wFMembers;
    }




}



