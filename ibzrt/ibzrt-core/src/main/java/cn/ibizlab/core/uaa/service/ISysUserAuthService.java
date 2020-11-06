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

import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.filter.SysUserAuthSearchContext;


/**
 * 实体[SysUserAuth] 服务对象接口
 */
public interface ISysUserAuthService{

    boolean create(SysUserAuth et) ;
    void createBatch(List<SysUserAuth> list) ;
    boolean update(SysUserAuth et) ;
    void updateBatch(List<SysUserAuth> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysUserAuth get(String key) ;
    SysUserAuth getDraft(SysUserAuth et) ;
    boolean checkKey(SysUserAuth et) ;
    boolean save(SysUserAuth et) ;
    void saveBatch(List<SysUserAuth> list) ;
    Page<SysUserAuth> searchDefault(SysUserAuthSearchContext context) ;
    List<SysUserAuth> selectByUserid(String userid);
    void removeByUserid(String userid);

}



