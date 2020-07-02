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
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.uaa.domain.SysUserRole;
import cn.ibizlab.core.uaa.filter.SysUserRoleSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysUserRole] 服务对象接口
 */
public interface ISysUserRoleService extends IService<SysUserRole>{

    boolean create(SysUserRole et) ;
    void createBatch(List<SysUserRole> list) ;
    boolean update(SysUserRole et) ;
    void updateBatch(List<SysUserRole> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysUserRole get(String key) ;
    SysUserRole getDraft(SysUserRole et) ;
    boolean checkKey(SysUserRole et) ;
    boolean save(SysUserRole et) ;
    void saveBatch(List<SysUserRole> list) ;
    Page<SysUserRole> searchDefault(SysUserRoleSearchContext context) ;
    List<SysUserRole> selectByRoleid(String roleid) ;
    void removeByRoleid(String roleid) ;
    List<SysUserRole> selectByUserid(String userid) ;
    void removeByUserid(String userid) ;
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


