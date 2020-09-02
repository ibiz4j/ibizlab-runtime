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

import cn.ibizlab.core.uaa.domain.SysAuthLog;
import cn.ibizlab.core.uaa.filter.SysAuthLogSearchContext;


/**
 * 实体[SysAuthLog] 服务对象接口
 */
public interface ISysAuthLogService{

    boolean create(SysAuthLog et) ;
    void createBatch(List<SysAuthLog> list) ;
    boolean update(SysAuthLog et) ;
    void updateBatch(List<SysAuthLog> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysAuthLog get(String key) ;
    SysAuthLog getDraft(SysAuthLog et) ;
    boolean checkKey(SysAuthLog et) ;
    boolean save(SysAuthLog et) ;
    void saveBatch(List<SysAuthLog> list) ;
    Page<SysAuthLog> searchDefault(SysAuthLogSearchContext context) ;

}



