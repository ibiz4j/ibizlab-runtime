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
import cn.ibizlab.core.task.domain.JobsLog;
import cn.ibizlab.core.task.filter.JobsLogSearchContext;
import cn.ibizlab.core.task.service.IJobsLogService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.task.client.JobsLogFeignClient;

/**
 * 实体[任务调度日志] 服务对象接口实现
 */
@Slf4j
@Service
public class JobsLogServiceImpl implements IJobsLogService {

    @Autowired
    JobsLogFeignClient jobsLogFeignClient;


    @Override
    public boolean create(JobsLog et) {
        JobsLog rt = jobsLogFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<JobsLog> list){
        jobsLogFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(JobsLog et) {
        JobsLog rt = jobsLogFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<JobsLog> list){
        jobsLogFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=jobsLogFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        jobsLogFeignClient.removeBatch(idList);
    }

    @Override
    public JobsLog get(String id) {
		JobsLog et=jobsLogFeignClient.get(id);
        if(et==null){
            et=new JobsLog();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public JobsLog getDraft(JobsLog et) {
        et=jobsLogFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(JobsLog et) {
        return jobsLogFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(JobsLog et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!jobsLogFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<JobsLog> list) {
        jobsLogFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<JobsLog> searchDefault(JobsLogSearchContext context) {
        Page<JobsLog> jobsLogs=jobsLogFeignClient.searchDefault(context);
        return jobsLogs;
    }




}



