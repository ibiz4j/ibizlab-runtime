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


/**
 * 实体[SysPermission] 服务对象接口
 */
public interface ISysPermissionService{

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

}



