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

import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;


/**
 * 实体[SysRole] 服务对象接口
 */
public interface ISysRoleService{

    boolean create(SysRole et) ;
    @CacheEvict(value="sysrole",allEntries=true)
    void createBatch(List<SysRole> list) ;
    boolean update(SysRole et) ;
    @CacheEvict(value="sysrole",allEntries=true)
    void updateBatch(List<SysRole> list) ;
    boolean remove(String key) ;
    @CacheEvict(value="sysrole",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    SysRole get(String key) ;
    SysRole getDraft(SysRole et) ;
    boolean checkKey(SysRole et) ;
    boolean save(SysRole et) ;
    @CacheEvict(value="sysrole",allEntries=true)
    void saveBatch(List<SysRole> list) ;
    Page<SysRole> searchDefault(SysRoleSearchContext context) ;

}



