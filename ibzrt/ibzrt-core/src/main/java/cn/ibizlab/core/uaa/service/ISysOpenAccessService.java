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

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.filter.SysOpenAccessSearchContext;


/**
 * 实体[SysOpenAccess] 服务对象接口
 */
public interface ISysOpenAccessService {

    boolean create(SysOpenAccess et);
    @CacheEvict(value = "sysopenaccess", allEntries = true)
    void createBatch(List<SysOpenAccess> list);
    boolean update(SysOpenAccess et);
    @CacheEvict(value = "sysopenaccess", allEntries = true)
    void updateBatch(List<SysOpenAccess> list);
    boolean remove(String key);
    @CacheEvict(value = "sysopenaccess", allEntries = true)
    void removeBatch(Collection<String> idList);
    SysOpenAccess get(String key);
    SysOpenAccess getDraft(SysOpenAccess et);
    boolean checkKey(SysOpenAccess et);
    boolean save(SysOpenAccess et);
    @CacheEvict(value = "sysopenaccess",allEntries = true)
    void saveBatch(List<SysOpenAccess> list);
    Page<SysOpenAccess> searchDefault(SysOpenAccessSearchContext context);

}



