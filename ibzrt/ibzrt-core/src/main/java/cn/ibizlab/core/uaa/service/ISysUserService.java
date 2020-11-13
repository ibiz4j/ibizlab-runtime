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


/**
 * 实体[SysUser] 服务对象接口
 */
public interface ISysUserService {

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
    boolean save(SysUser et);
    @CacheEvict(value = "sysuser",allEntries = true)
    void saveBatch(List<SysUser> list);
    Page<SysUser> searchDefault(SysUserSearchContext context);

}



