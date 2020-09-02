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
import cn.ibizlab.core.uaa.domain.SysUserRole;
import cn.ibizlab.core.uaa.filter.SysUserRoleSearchContext;
import cn.ibizlab.core.uaa.service.ISysUserRoleService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysUserRoleFeignClient;

/**
 * 实体[用户角色关系] 服务对象接口实现
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Autowired
    SysUserRoleFeignClient sysUserRoleFeignClient;


    @Override
    public boolean create(SysUserRole et) {
        SysUserRole rt = sysUserRoleFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysUserRole> list){
        sysUserRoleFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysUserRole et) {
        SysUserRole rt = sysUserRoleFeignClient.update(et.getUserroleid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysUserRole> list){
        sysUserRoleFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String userroleid) {
        boolean result=sysUserRoleFeignClient.remove(userroleid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysUserRoleFeignClient.removeBatch(idList);
    }

    @Override
    public SysUserRole get(String userroleid) {
		SysUserRole et=sysUserRoleFeignClient.get(userroleid);
        if(et==null){
            et=new SysUserRole();
            et.setUserroleid(userroleid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysUserRole getDraft(SysUserRole et) {
        et=sysUserRoleFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysUserRole et) {
        return sysUserRoleFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysUserRole et) {
        if(et.getUserroleid()==null) et.setUserroleid((String)et.getDefaultKey(true));
        if(!sysUserRoleFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysUserRole> list) {
        sysUserRoleFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysUserRole> selectByRoleid(String roleid) {
        SysUserRoleSearchContext context=new SysUserRoleSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_sys_roleid_eq(roleid);
        return sysUserRoleFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByRoleid(String roleid) {
        Set<String> delIds=new HashSet<String>();
        for(SysUserRole before:selectByRoleid(roleid)){
            delIds.add(before.getUserroleid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<SysUserRole> selectByUserid(String userid) {
        SysUserRoleSearchContext context=new SysUserRoleSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_sys_userid_eq(userid);
        return sysUserRoleFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByUserid(String userid) {
        Set<String> delIds=new HashSet<String>();
        for(SysUserRole before:selectByUserid(userid)){
            delIds.add(before.getUserroleid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysUserRole> searchDefault(SysUserRoleSearchContext context) {
        Page<SysUserRole> sysUserRoles=sysUserRoleFeignClient.searchDefault(context);
        return sysUserRoles;
    }



}



