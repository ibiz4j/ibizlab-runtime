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
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;
import cn.ibizlab.core.uaa.service.ISysPermissionService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysPermissionFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[权限/资源] 服务对象接口实现
 */
@Slf4j
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    SysPermissionFeignClient sysPermissionFeignClient;


    @Override
    public boolean create(SysPermission et) {
        SysPermission rt = sysPermissionFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysPermission> list){
        sysPermissionFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysPermission et) {
        SysPermission rt = sysPermissionFeignClient.update(et.getPermissionid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysPermission> list){
        sysPermissionFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String permissionid) {
        boolean result=sysPermissionFeignClient.remove(permissionid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysPermissionFeignClient.removeBatch(idList);
    }

    @Override
    public SysPermission get(String permissionid) {
		SysPermission et=sysPermissionFeignClient.get(permissionid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), permissionid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysPermission getDraft(SysPermission et) {
        et=sysPermissionFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SysPermission et) {
        return sysPermissionFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysPermission et) {
        boolean result = true;
        Object rt = sysPermissionFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), SysPermission.class);
                if (rt != null) {
                    CachedBeanCopier.copy(rt, et);
                }
            } else if (rt instanceof Boolean) {
                result = (boolean) rt;
            }
        } catch (Exception e) {
        }
            return result;
    }

    @Override
    public void saveBatch(List<SysPermission> list) {
        sysPermissionFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysPermission> searchDefault(SysPermissionSearchContext context) {
        Page<SysPermission> sysPermissions=sysPermissionFeignClient.searchDefault(context);
        return sysPermissions;
    }

}



