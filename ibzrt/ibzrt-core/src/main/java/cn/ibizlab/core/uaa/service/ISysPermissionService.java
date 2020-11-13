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

import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;


/**
 * 实体[SysPermission] 服务对象接口
 */
public interface ISysPermissionService {

    boolean create(SysPermission et);
    void createBatch(List<SysPermission> list);
    boolean update(SysPermission et);
    void updateBatch(List<SysPermission> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    SysPermission get(String key);
    SysPermission getDraft(SysPermission et);
    boolean checkKey(SysPermission et);
    boolean save(SysPermission et);
    void saveBatch(List<SysPermission> list);
    Page<SysPermission> searchDefault(SysPermissionSearchContext context);

}



