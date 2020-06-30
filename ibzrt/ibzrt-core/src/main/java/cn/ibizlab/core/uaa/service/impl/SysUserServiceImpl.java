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
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.filter.SysUserSearchContext;
import cn.ibizlab.core.uaa.service.ISysUserService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.uaa.client.SysUserFeignClient;

/**
 * 实体[系统用户] 服务对象接口实现
 */
@Slf4j
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserFeignClient sysUserFeignClient;


    @Override
    public boolean remove(String userid) {
        boolean result=sysUserFeignClient.remove(userid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysUserFeignClient.removeBatch(idList);
    }

    @Override
    public boolean update(SysUser et) {
        SysUser rt = sysUserFeignClient.update(et.getUserid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysUser> list){
        sysUserFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean checkKey(SysUser et) {
        return sysUserFeignClient.checkKey(et);
    }
    @Override
    public SysUser get(String userid) {
		SysUser et=sysUserFeignClient.get(userid);
        if(et==null){
            et=new SysUser();
            et.setUserid(userid);
        }
        else{
        }
        return  et;
    }

    @Override
    @Transactional
    public boolean save(SysUser et) {
        if(et.getUserid()==null) et.setUserid((String)et.getDefaultKey(true));
        if(!sysUserFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysUser> list) {
        sysUserFeignClient.saveBatch(list) ;
    }

    @Override
    public SysUser getDraft(SysUser et) {
        et=sysUserFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean create(SysUser et) {
        SysUser rt = sysUserFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysUser> list){
        sysUserFeignClient.createBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysUser> searchDefault(SysUserSearchContext context) {
        Page<SysUser> sysUsers=sysUserFeignClient.searchDefault(context);
        return sysUsers;
    }


}


