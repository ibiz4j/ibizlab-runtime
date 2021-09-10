package cn.ibizlab.core.ou.service;

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

import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.filter.SysEmployeeSearchContext;


/**
 * 实体[SysEmployee] 服务对象接口
 */
public interface ISysEmployeeService {

    boolean create(SysEmployee et);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void createBatch(List<SysEmployee> list);
    boolean update(SysEmployee et);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void updateBatch(List<SysEmployee> list);
    boolean remove(String key);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void removeBatch(Collection<String> idList);
    SysEmployee get(String key);
    SysEmployee getDraft(SysEmployee et);
    boolean checkKey(SysEmployee et);
    SysEmployee initPwd(SysEmployee et);
    boolean initPwdBatch(List<SysEmployee> etList);
    boolean save(SysEmployee et);
    @CacheEvict(value = "sysemployee",allEntries = true)
    void saveBatch(List<SysEmployee> list);
    Page<SysEmployee> searchDefault(SysEmployeeSearchContext context);
    List<SysEmployee> selectByMdeptid(String deptid);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void resetByMdeptid(String deptid);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void resetByMdeptid(Collection<String> ids);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void removeByMdeptid(String deptid);
    List<SysEmployee> selectByOrgid(String orgid);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void resetByOrgid(String orgid);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void resetByOrgid(Collection<String> ids);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void removeByOrgid(String orgid);
    List<SysEmployee> selectByPostid(String postid);
    @CacheEvict(value = "sysemployee", allEntries = true)
    void removeByPostid(String postid);

}



