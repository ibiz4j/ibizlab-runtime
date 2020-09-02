package cn.ibizlab.core.task.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.task.domain.JobsRegistry;
import cn.ibizlab.core.task.filter.JobsRegistrySearchContext;


/**
 * 实体[JobsRegistry] 服务对象接口
 */
public interface IJobsRegistryService{

    boolean create(JobsRegistry et) ;
    void createBatch(List<JobsRegistry> list) ;
    boolean update(JobsRegistry et) ;
    void updateBatch(List<JobsRegistry> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    JobsRegistry get(String key) ;
    JobsRegistry getDraft(JobsRegistry et) ;
    boolean checkKey(JobsRegistry et) ;
    boolean save(JobsRegistry et) ;
    void saveBatch(List<JobsRegistry> list) ;
    Page<JobsRegistry> searchDefault(JobsRegistrySearchContext context) ;

}



