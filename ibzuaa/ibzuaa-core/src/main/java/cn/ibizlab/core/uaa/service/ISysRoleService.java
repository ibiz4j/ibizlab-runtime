package cn.ibizlab.core.uaa.service;

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

import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysRole] 服务对象接口
 */
@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface ISysRoleService extends IService<SysRole> {

    boolean create(SysRole et);
    @CacheEvict(value = "sysrole", allEntries = true)
    void createBatch(List<SysRole> list);
    boolean update(SysRole et);
    @CacheEvict(value = "sysrole", allEntries = true)
    void updateBatch(List<SysRole> list);
    boolean remove(String key);
    @CacheEvict(value = "sysrole", allEntries = true)
    void removeBatch(Collection<String> idList);
    SysRole get(String key);
    SysRole getDraft(SysRole et);
    boolean checkKey(SysRole et);
    SysRole noRepeat(SysRole et);
    boolean noRepeatBatch(List<SysRole> etList);
    boolean save(SysRole et);
    @CacheEvict(value = "sysrole",allEntries = true)
    void saveBatch(List<SysRole> list);
    Page<SysRole> searchDefault(SysRoleSearchContext context);
    Page<SysRole> searchNoRepeat(SysRoleSearchContext context);
    List<SysRole> selectByProleid(String roleid);
    @CacheEvict(value = "sysrole", allEntries = true)
    void removeByProleid(String roleid);
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

    List<SysRole> getSysroleByIds(List<String> ids);
    List<SysRole> getSysroleByEntities(List<SysRole> entities);
}


