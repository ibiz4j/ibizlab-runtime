package cn.ibizlab.core.workflow.service;

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

import cn.ibizlab.core.workflow.domain.WFSystem;
import cn.ibizlab.core.workflow.filter.WFSystemSearchContext;


/**
 * 实体[WFSystem] 服务对象接口
 */
public interface IWFSystemService{

    boolean create(WFSystem et) ;
    void createBatch(List<WFSystem> list) ;
    boolean update(WFSystem et) ;
    void updateBatch(List<WFSystem> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFSystem get(String key) ;
    WFSystem getDraft(WFSystem et) ;
    boolean checkKey(WFSystem et) ;
    boolean save(WFSystem et) ;
    void saveBatch(List<WFSystem> list) ;
    Page<WFSystem> searchDefault(WFSystemSearchContext context) ;

}



