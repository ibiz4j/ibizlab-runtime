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

import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.core.task.filter.JobsLockSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[JobsLock] 服务对象接口
 */
public interface IJobsLockService extends IService<JobsLock> {

    boolean create(JobsLock et);
    void createBatch(List<JobsLock> list);
    boolean update(JobsLock et);
    void updateBatch(List<JobsLock> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    JobsLock get(String key);
    JobsLock getDraft(JobsLock et);
    boolean checkKey(JobsLock et);
    boolean save(JobsLock et);
    void saveBatch(List<JobsLock> list);
    Page<JobsLock> searchDefault(JobsLockSearchContext context);
    /**
     *自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return select * from table where id = '1'
     */
    List<JSONObject> select(String sql, Map param);
    /**
     *自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return     update table  set name ='test' where id = '1'
     */
    boolean execute(String sql, Map param);

}


