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

import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.core.task.filter.JobsLockSearchContext;


/**
 * 实体[JobsLock] 服务对象接口
 */
public interface IJobsLockService{

    boolean create(JobsLock et) ;
    void createBatch(List<JobsLock> list) ;
    boolean update(JobsLock et) ;
    void updateBatch(List<JobsLock> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    JobsLock get(String key) ;
    JobsLock getDraft(JobsLock et) ;
    boolean checkKey(JobsLock et) ;
    boolean save(JobsLock et) ;
    void saveBatch(List<JobsLock> list) ;
    Page<JobsLock> searchDefault(JobsLockSearchContext context) ;

}



