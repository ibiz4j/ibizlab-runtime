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

import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;


/**
 * 实体[SysPSSystem] 服务对象接口
 */
public interface ISysPSSystemService{

    SysPSSystem get(String key) ;
    boolean update(SysPSSystem et) ;
    void updateBatch(List<SysPSSystem> list) ;
    boolean checkKey(SysPSSystem et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SysPSSystem et) ;
    void createBatch(List<SysPSSystem> list) ;
    SysPSSystem getDraft(SysPSSystem et) ;
    boolean save(SysPSSystem et) ;
    void saveBatch(List<SysPSSystem> list) ;
    Page<SysPSSystem> searchDefault(SysPSSystemSearchContext context) ;

}



