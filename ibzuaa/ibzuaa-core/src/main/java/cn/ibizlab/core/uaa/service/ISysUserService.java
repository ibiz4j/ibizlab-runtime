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

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.filter.SysUserSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysUser] 服务对象接口
 */
public interface ISysUserService extends IService<SysUser> {

    boolean create(SysUser et);
    @CacheEvict(value = "sysuser", allEntries = true)
    void createBatch(List<SysUser> list);
    boolean update(SysUser et);
    @CacheEvict(value = "sysuser", allEntries = true)
    void updateBatch(List<SysUser> list);
    boolean remove(String key);
    @CacheEvict(value = "sysuser", allEntries = true)
    void removeBatch(Collection<String> idList);
    SysUser get(String key);
    SysUser getDraft(SysUser et);
    boolean checkKey(SysUser et);
    SysUser deleteSysUser(SysUser et);
    boolean save(SysUser et);
    @CacheEvict(value = "sysuser",allEntries = true)
    void saveBatch(List<SysUser> list);
    SysUser saveSysUser(SysUser et);
    Page<SysUser> searchDefault(SysUserSearchContext context);
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

    List<SysUser> getSysuserByIds(List<String> ids);
    List<SysUser> getSysuserByEntities(List<SysUser> entities);
}


