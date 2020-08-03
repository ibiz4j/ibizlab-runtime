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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.core.task.filter.JobsLockSearchContext;
import cn.ibizlab.core.task.service.IJobsLockService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.task.client.JobsLockFeignClient;

/**
 * 实体[任务锁] 服务对象接口实现
 */
@Slf4j
@Service
public class JobsLockServiceImpl implements IJobsLockService {

    @Autowired
    JobsLockFeignClient jobsLockFeignClient;


    @Override
    public boolean create(JobsLock et) {
        JobsLock rt = jobsLockFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<JobsLock> list){
        jobsLockFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(JobsLock et) {
        JobsLock rt = jobsLockFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<JobsLock> list){
        jobsLockFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=jobsLockFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        jobsLockFeignClient.removeBatch(idList);
    }

    @Override
    public JobsLock get(String id) {
		JobsLock et=jobsLockFeignClient.get(id);
        if(et==null){
            et=new JobsLock();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public JobsLock getDraft(JobsLock et) {
        et=jobsLockFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(JobsLock et) {
        return jobsLockFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(JobsLock et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!jobsLockFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<JobsLock> list) {
        jobsLockFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<JobsLock> searchDefault(JobsLockSearchContext context) {
        Page<JobsLock> jobsLocks=jobsLockFeignClient.searchDefault(context);
        return jobsLocks;
    }



}



