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
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.filter.SysUserAuthSearchContext;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysUserAuthFeignClient;

/**
 * 实体[账号绑定] 服务对象接口实现
 */
@Slf4j
@Service
public class SysUserAuthServiceImpl implements ISysUserAuthService {

    @Autowired
    SysUserAuthFeignClient sysUserAuthFeignClient;


    @Override
    public boolean create(SysUserAuth et) {
        SysUserAuth rt = sysUserAuthFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysUserAuth> list){
        sysUserAuthFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysUserAuth et) {
        SysUserAuth rt = sysUserAuthFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysUserAuth> list){
        sysUserAuthFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=sysUserAuthFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysUserAuthFeignClient.removeBatch(idList);
    }

    @Override
    public SysUserAuth get(String id) {
		SysUserAuth et=sysUserAuthFeignClient.get(id);
        if(et==null){
            et=new SysUserAuth();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysUserAuth getDraft(SysUserAuth et) {
        et=sysUserAuthFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SysUserAuth et) {
        return sysUserAuthFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysUserAuth et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!sysUserAuthFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysUserAuth> list) {
        sysUserAuthFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysUserAuth> selectByUserid(String userid) {
        SysUserAuthSearchContext context=new SysUserAuthSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_userid_eq(userid);
        return sysUserAuthFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByUserid(String userid) {
        Set<String> delIds=new HashSet<String>();
        for(SysUserAuth before:selectByUserid(userid)){
            delIds.add(before.getId());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysUserAuth> searchDefault(SysUserAuthSearchContext context) {
        Page<SysUserAuth> sysUserAuths=sysUserAuthFeignClient.searchDefault(context);
        return sysUserAuths;
    }

}



