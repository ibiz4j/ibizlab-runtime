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
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.task.domain.JobsRegistry;
import cn.ibizlab.core.task.filter.JobsRegistrySearchContext;


/**
 * 实体[JobsRegistry] 服务对象接口
 */
public interface IJobsRegistryService{

    JobsRegistry get(String key) ;
    boolean update(JobsRegistry et) ;
    void updateBatch(List<JobsRegistry> list) ;
    JobsRegistry getDraft(JobsRegistry et) ;
    boolean save(JobsRegistry et) ;
    void saveBatch(List<JobsRegistry> list) ;
    boolean checkKey(JobsRegistry et) ;
    boolean create(JobsRegistry et) ;
    void createBatch(List<JobsRegistry> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<JobsRegistry> searchDefault(JobsRegistrySearchContext context) ;

}



