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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.uaa.client.SysRolePermissionFeignClient;

/**
 * 实体[角色权限关系] 服务对象接口实现
 */
@Slf4j
@Service
public class SysRolePermissionServiceImpl implements ISysRolePermissionService {

    @Autowired
    SysRolePermissionFeignClient sysRolePermissionFeignClient;


    @Override
    public boolean create(SysRolePermission et) {
        SysRolePermission rt = sysRolePermissionFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysRolePermission> list){
        sysRolePermissionFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysRolePermission et) {
        SysRolePermission rt = sysRolePermissionFeignClient.update(et.getRolepermissionid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysRolePermission> list){
        sysRolePermissionFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String rolepermissionid) {
        boolean result=sysRolePermissionFeignClient.remove(rolepermissionid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysRolePermissionFeignClient.removeBatch(idList);
    }

    @Override
    public SysRolePermission get(String rolepermissionid) {
		SysRolePermission et=sysRolePermissionFeignClient.get(rolepermissionid);
        if(et==null){
            et=new SysRolePermission();
            et.setRolepermissionid(rolepermissionid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysRolePermission getDraft(SysRolePermission et) {
        et=sysRolePermissionFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysRolePermission et) {
        return sysRolePermissionFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysRolePermission et) {
        if(et.getRolepermissionid()==null) et.setRolepermissionid((String)et.getDefaultKey(true));
        if(!sysRolePermissionFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysRolePermission> list) {
        sysRolePermissionFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysRolePermission> selectByPermissionid(String permissionid) {
        SysRolePermissionSearchContext context=new SysRolePermissionSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_sys_permissionid_eq(permissionid);
        return sysRolePermissionFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByPermissionid(String permissionid) {
        Set<String> delIds=new HashSet<String>();
        for(SysRolePermission before:selectByPermissionid(permissionid)){
            delIds.add(before.getRolepermissionid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<SysRolePermission> selectByRoleid(String roleid) {
        SysRolePermissionSearchContext context=new SysRolePermissionSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_sys_roleid_eq(roleid);
        return sysRolePermissionFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByRoleid(String roleid) {
        Set<String> delIds=new HashSet<String>();
        for(SysRolePermission before:selectByRoleid(roleid)){
            delIds.add(before.getRolepermissionid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysRolePermission> searchDefault(SysRolePermissionSearchContext context) {
        Page<SysRolePermission> sysRolePermissions=sysRolePermissionFeignClient.searchDefault(context);
        return sysRolePermissions;
    }


}


