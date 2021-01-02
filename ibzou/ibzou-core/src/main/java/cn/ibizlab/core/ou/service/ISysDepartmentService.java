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

import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysDepartment] 服务对象接口
 */
@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface ISysDepartmentService extends IService<SysDepartment> {

    boolean create(SysDepartment et);
    @CacheEvict(value = "sysdepartment", allEntries = true)
    void createBatch(List<SysDepartment> list);
    boolean update(SysDepartment et);
    @CacheEvict(value = "sysdepartment", allEntries = true)
    void updateBatch(List<SysDepartment> list);
    boolean remove(String key);
    @CacheEvict(value = "sysdepartment", allEntries = true)
    void removeBatch(Collection<String> idList);
    SysDepartment get(String key);
    SysDepartment getDraft(SysDepartment et);
    boolean checkKey(SysDepartment et);
    boolean save(SysDepartment et);
    @CacheEvict(value = "sysdepartment",allEntries = true)
    void saveBatch(List<SysDepartment> list);
    Page<SysDepartment> searchDefault(SysDepartmentSearchContext context);
    List<SysDepartment> selectByParentdeptid(String deptid);
    List<SysDepartment> selectByParentdeptid(Collection<String> ids);
    @CacheEvict(value = "sysdepartment", allEntries = true)
    void removeByParentdeptid(String deptid);
    List<SysDepartment> selectByOrgid(String orgid);
    List<SysDepartment> selectByOrgid(Collection<String> ids);
    @CacheEvict(value = "sysdepartment", allEntries = true)
    void removeByOrgid(String orgid);
    @CacheEvict(value = "sysdepartment", allEntries = true)
    void saveByOrgid(String orgid, List<SysDepartment> list) ;
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

    List<SysDepartment> getSysdepartmentByIds(List<String> ids);
    List<SysDepartment> getSysdepartmentByEntities(List<SysDepartment> entities);
}


