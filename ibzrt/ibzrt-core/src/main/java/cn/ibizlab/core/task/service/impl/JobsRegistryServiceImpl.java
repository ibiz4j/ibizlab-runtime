package cn.ibizlab.core.task.service.impl;

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
import cn.ibizlab.core.task.domain.JobsRegistry;
import cn.ibizlab.core.task.filter.JobsRegistrySearchContext;
import cn.ibizlab.core.task.service.IJobsRegistryService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.task.client.JobsRegistryFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[任务注册信息] 服务对象接口实现
 */
@Slf4j
@Service
public class JobsRegistryServiceImpl implements IJobsRegistryService {

    @Autowired
    JobsRegistryFeignClient jobsRegistryFeignClient;


    @Override
    public boolean create(JobsRegistry et) {
        JobsRegistry rt = jobsRegistryFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<JobsRegistry> list){
        jobsRegistryFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(JobsRegistry et) {
        JobsRegistry rt = jobsRegistryFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<JobsRegistry> list){
        jobsRegistryFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=jobsRegistryFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        jobsRegistryFeignClient.removeBatch(idList);
    }

    @Override
    public JobsRegistry get(String id) {
		JobsRegistry et=jobsRegistryFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public JobsRegistry getDraft(JobsRegistry et) {
        et=jobsRegistryFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(JobsRegistry et) {
        return jobsRegistryFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(JobsRegistry et) {
        boolean result = true;
        Object rt = jobsRegistryFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), JobsRegistry.class);
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
    public void saveBatch(List<JobsRegistry> list) {
        jobsRegistryFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<JobsRegistry> searchDefault(JobsRegistrySearchContext context) {
        Page<JobsRegistry> jobsRegistrys=jobsRegistryFeignClient.searchDefault(context);
        return jobsRegistrys;
    }



}



