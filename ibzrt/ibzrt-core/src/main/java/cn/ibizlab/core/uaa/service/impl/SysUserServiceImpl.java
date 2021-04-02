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
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.filter.SysUserSearchContext;
import cn.ibizlab.core.uaa.service.ISysUserService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysUserFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[系统用户] 服务对象接口实现
 */
@Slf4j
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserFeignClient sysUserFeignClient;


    @Override
    public boolean create(SysUser et) {
        SysUser rt = sysUserFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysUser> list){
        sysUserFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysUser et) {
        SysUser rt = sysUserFeignClient.update(et.getUserid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysUser> list){
        sysUserFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String userid) {
        boolean result=sysUserFeignClient.remove(userid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysUserFeignClient.removeBatch(idList);
    }

    @Override
    public SysUser get(String userid) {
		SysUser et=sysUserFeignClient.get(userid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), userid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysUser getDraft(SysUser et) {
        et=sysUserFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SysUser et) {
        return sysUserFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysUser et) {
        boolean result = true;
        Object rt = sysUserFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), SysUser.class);
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
    public void saveBatch(List<SysUser> list) {
        sysUserFeignClient.saveBatch(list) ;
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



