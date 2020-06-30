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

import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysPermission] 服务对象接口
 */
public interface ISysPermissionService extends IService<SysPermission>{

    boolean save(SysPermission et) ;
    void saveBatch(List<SysPermission> list) ;
    SysPermission getDraft(SysPermission et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(SysPermission et) ;
    void updateBatch(List<SysPermission> list) ;
    boolean create(SysPermission et) ;
    void createBatch(List<SysPermission> list) ;
    boolean checkKey(SysPermission et) ;
    SysPermission get(String key) ;
    Page<SysPermission> searchDefault(SysPermissionSearchContext context) ;
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


