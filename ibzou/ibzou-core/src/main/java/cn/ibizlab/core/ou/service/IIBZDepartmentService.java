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
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.filter.IBZDepartmentSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[IBZDepartment] 服务对象接口
 */
public interface IIBZDepartmentService extends IService<IBZDepartment>{

    boolean create(IBZDepartment et) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void createBatch(List<IBZDepartment> list) ;
    boolean update(IBZDepartment et) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void updateBatch(List<IBZDepartment> list) ;
    boolean remove(String key) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    IBZDepartment get(String key) ;
    IBZDepartment getDraft(IBZDepartment et) ;
    boolean checkKey(IBZDepartment et) ;
    boolean save(IBZDepartment et) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void saveBatch(List<IBZDepartment> list) ;
    Page<IBZDepartment> searchDefault(IBZDepartmentSearchContext context) ;
    List<IBZDepartment> selectByParentdeptid(String deptid) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void removeByParentdeptid(String deptid) ;
    List<IBZDepartment> selectByOrgid(String orgid) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void removeByOrgid(String orgid) ;
    @CacheEvict(value="ibzdepartment",allEntries=true)
    void saveByOrgid(String orgid,List<IBZDepartment> list) ;
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

    List<IBZDepartment> getIbzdepartmentByIds(List<String> ids) ;
    List<IBZDepartment> getIbzdepartmentByEntities(List<IBZDepartment> entities) ;
}


