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

import cn.ibizlab.core.task.domain.JobsInfo;
import cn.ibizlab.core.task.filter.JobsInfoSearchContext;


/**
 * 实体[JobsInfo] 服务对象接口
 */
public interface IJobsInfoService {

    boolean create(JobsInfo et);
    void createBatch(List<JobsInfo> list);
    boolean update(JobsInfo et);
    void updateBatch(List<JobsInfo> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    JobsInfo get(String key);
    JobsInfo getDraft(JobsInfo et);
    boolean checkKey(JobsInfo et);
    JobsInfo execute(JobsInfo et);
    boolean executeBatch(List<JobsInfo> etList);
    boolean save(JobsInfo et);
    void saveBatch(List<JobsInfo> list);
    JobsInfo start(JobsInfo et);
    JobsInfo stop(JobsInfo et);
    Page<JobsInfo> searchDefault(JobsInfoSearchContext context);

}



