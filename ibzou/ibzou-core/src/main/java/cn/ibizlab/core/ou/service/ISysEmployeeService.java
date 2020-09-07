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


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysEmployee] 服务对象接口
 */
public interface ISysEmployeeService extends IService<SysEmployee>{

    boolean create(SysEmployee et) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void createBatch(List<SysEmployee> list) ;
    boolean update(SysEmployee et) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void updateBatch(List<SysEmployee> list) ;
    boolean remove(String key) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    SysEmployee get(String key) ;
    SysEmployee getDraft(SysEmployee et) ;
    boolean checkKey(SysEmployee et) ;
    SysEmployee initPwd(SysEmployee et) ;
    boolean save(SysEmployee et) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void saveBatch(List<SysEmployee> list) ;
    Page<SysEmployee> searchDefault(SysEmployeeSearchContext context) ;
    List<SysEmployee> selectByMdeptid(String deptid) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void removeByMdeptid(String deptid) ;
    List<SysEmployee> selectByOrgid(String orgid) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void removeByOrgid(String orgid) ;
    List<SysEmployee> selectByPostid(String postid) ;
    @CacheEvict(value="sysemployee",allEntries=true)
    void removeByPostid(String postid) ;
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

    List<SysEmployee> getSysemployeeByIds(List<String> ids) ;
    List<SysEmployee> getSysemployeeByEntities(List<SysEmployee> entities) ;
}


