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
import cn.ibizlab.core.task.domain.JobsInfo;
import cn.ibizlab.core.task.filter.JobsInfoSearchContext;
import cn.ibizlab.core.task.service.IJobsInfoService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.task.client.JobsInfoFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[任务信息] 服务对象接口实现
 */
@Slf4j
@Service
public class JobsInfoServiceImpl implements IJobsInfoService {

    @Autowired
    JobsInfoFeignClient jobsInfoFeignClient;


    @Override
    public boolean create(JobsInfo et) {
        JobsInfo rt = jobsInfoFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<JobsInfo> list){
        jobsInfoFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(JobsInfo et) {
        JobsInfo rt = jobsInfoFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<JobsInfo> list){
        jobsInfoFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=jobsInfoFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        jobsInfoFeignClient.removeBatch(idList);
    }

    @Override
    public JobsInfo get(String id) {
		JobsInfo et=jobsInfoFeignClient.get(id);
        if(et==null){
            et=new JobsInfo();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public JobsInfo getDraft(JobsInfo et) {
        et=jobsInfoFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(JobsInfo et) {
        return jobsInfoFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public JobsInfo execute(JobsInfo et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean executeBatch(List<JobsInfo> etList) {
        for(JobsInfo et : etList) {
            execute(et);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(JobsInfo et) {
        boolean result = true;
        Object rt = jobsInfoFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), JobsInfo.class);
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
    public void saveBatch(List<JobsInfo> list) {
        jobsInfoFeignClient.saveBatch(list) ;
    }

    @Override
    public JobsInfo start(JobsInfo et) {
         et=jobsInfoFeignClient.start(et.getId(),et);
         return et;
    }
    @Override
    public JobsInfo stop(JobsInfo et) {
         et=jobsInfoFeignClient.stop(et.getId(),et);
         return et;
    }




    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<JobsInfo> searchDefault(JobsInfoSearchContext context) {
        Page<JobsInfo> jobsInfos=jobsInfoFeignClient.searchDefault(context);
        return jobsInfos;
    }

}



