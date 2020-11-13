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

import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;


/**
 * 实体[SysRolePermission] 服务对象接口
 */
public interface ISysRolePermissionService {

    boolean create(SysRolePermission et);
    void createBatch(List<SysRolePermission> list);
    boolean update(SysRolePermission et);
    void updateBatch(List<SysRolePermission> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    SysRolePermission get(String key);
    SysRolePermission getDraft(SysRolePermission et);
    boolean checkKey(SysRolePermission et);
    boolean save(SysRolePermission et);
    void saveBatch(List<SysRolePermission> list);
    Page<SysRolePermission> searchDefault(SysRolePermissionSearchContext context);
    List<SysRolePermission> selectByPermissionid(String permissionid);
    void removeByPermissionid(Collection<String> ids);
    void removeByPermissionid(String permissionid);
    List<SysRolePermission> selectByRoleid(String roleid);
    void removeByRoleid(Collection<String> ids);
    void removeByRoleid(String roleid);

}



