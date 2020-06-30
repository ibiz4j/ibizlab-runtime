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

import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;


/**
 * 实体[SysApp] 服务对象接口
 */
public interface ISysAppService{

    boolean create(SysApp et) ;
    void createBatch(List<SysApp> list) ;
    boolean update(SysApp et) ;
    void updateBatch(List<SysApp> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysApp get(String key) ;
    SysApp getDraft(SysApp et) ;
    boolean checkKey(SysApp et) ;
    boolean save(SysApp et) ;
    void saveBatch(List<SysApp> list) ;
    Page<SysApp> searchDefault(SysAppSearchContext context) ;
    List<SysApp> selectBySystemid(String pssystemid) ;
    void removeBySystemid(String pssystemid) ;

}



