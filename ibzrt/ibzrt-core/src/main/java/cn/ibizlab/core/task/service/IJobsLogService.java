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

import cn.ibizlab.core.task.domain.JobsLog;
import cn.ibizlab.core.task.filter.JobsLogSearchContext;


/**
 * 实体[JobsLog] 服务对象接口
 */
public interface IJobsLogService{

    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(JobsLog et) ;
    void updateBatch(List<JobsLog> list) ;
    JobsLog get(String key) ;
    boolean save(JobsLog et) ;
    void saveBatch(List<JobsLog> list) ;
    JobsLog getDraft(JobsLog et) ;
    boolean checkKey(JobsLog et) ;
    boolean create(JobsLog et) ;
    void createBatch(List<JobsLog> list) ;
    Page<JobsLog> searchDefault(JobsLogSearchContext context) ;

}



