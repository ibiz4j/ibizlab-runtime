package cn.ibizlab.core.disk.service;

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

import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import cn.ibizlab.core.disk.filter.META_DYNAMICMODELSearchContext;


/**
 * 实体[META_DYNAMICMODEL] 服务对象接口
 */
public interface IMETA_DYNAMICMODELService {

    boolean create(META_DYNAMICMODEL et);
    void createBatch(List<META_DYNAMICMODEL> list);
    boolean update(META_DYNAMICMODEL et);
    void updateBatch(List<META_DYNAMICMODEL> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    META_DYNAMICMODEL get(String key);
    META_DYNAMICMODEL getDraft(META_DYNAMICMODEL et);
    boolean checkKey(META_DYNAMICMODEL et);
    META_DYNAMICMODEL init(META_DYNAMICMODEL et);
    boolean initBatch(List<META_DYNAMICMODEL> etList);
    META_DYNAMICMODEL publish(META_DYNAMICMODEL et);
    boolean publishBatch(List<META_DYNAMICMODEL> etList);
    boolean save(META_DYNAMICMODEL et);
    void saveBatch(List<META_DYNAMICMODEL> list);
    Page<META_DYNAMICMODEL> searchDefault(META_DYNAMICMODELSearchContext context);
    Page<META_DYNAMICMODEL> searchDynaInst(META_DYNAMICMODELSearchContext context);
    List<META_DYNAMICMODEL> selectByPdynainstid(String configid);
    void removeByPdynainstid(String configid);

}



