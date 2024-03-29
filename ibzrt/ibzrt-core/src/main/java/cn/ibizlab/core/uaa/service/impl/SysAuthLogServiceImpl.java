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
import cn.ibizlab.core.uaa.domain.SysAuthLog;
import cn.ibizlab.core.uaa.filter.SysAuthLogSearchContext;
import cn.ibizlab.core.uaa.service.ISysAuthLogService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.uaa.client.SysAuthLogFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[认证日志] 服务对象接口实现
 */
@Slf4j
@Service
public class SysAuthLogServiceImpl implements ISysAuthLogService {

    @Autowired
    SysAuthLogFeignClient sysAuthLogFeignClient;


    @Override
    public boolean create(SysAuthLog et) {
        SysAuthLog rt = sysAuthLogFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysAuthLog> list){
        sysAuthLogFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysAuthLog et) {
        SysAuthLog rt = sysAuthLogFeignClient.update(et.getLogid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysAuthLog> list){
        sysAuthLogFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String logid) {
        boolean result=sysAuthLogFeignClient.remove(logid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysAuthLogFeignClient.removeBatch(idList);
    }

    @Override
    public SysAuthLog get(String logid) {
		SysAuthLog et=sysAuthLogFeignClient.get(logid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), logid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysAuthLog getDraft(SysAuthLog et) {
        et=sysAuthLogFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SysAuthLog et) {
        return sysAuthLogFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysAuthLog et) {
        boolean result = true;
        Object rt = sysAuthLogFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), SysAuthLog.class);
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
    public void saveBatch(List<SysAuthLog> list) {
        sysAuthLogFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysAuthLog> searchDefault(SysAuthLogSearchContext context) {
        Page<SysAuthLog> sysAuthLogs=sysAuthLogFeignClient.searchDefault(context);
        return sysAuthLogs;
    }



}



