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


/**
 * 实体[SysUserRole] 服务对象接口
 */
public interface ISysUserRoleService{

    boolean checkKey(SysUserRole et) ;
    SysUserRole getDraft(SysUserRole et) ;
    boolean update(SysUserRole et) ;
    void updateBatch(List<SysUserRole> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SysUserRole et) ;
    void createBatch(List<SysUserRole> list) ;
    SysUserRole get(String key) ;
    boolean save(SysUserRole et) ;
    void saveBatch(List<SysUserRole> list) ;
    Page<SysUserRole> searchDefault(SysUserRoleSearchContext context) ;
    List<SysUserRole> selectByRoleid(String roleid) ;
    void removeByRoleid(String roleid) ;
    List<SysUserRole> selectByUserid(String userid) ;
    void removeByUserid(String userid) ;

}



