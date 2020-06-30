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

import cn.ibizlab.core.workflow.domain.WFHistory;
import cn.ibizlab.core.workflow.filter.WFHistorySearchContext;


/**
 * 实体[WFHistory] 服务对象接口
 */
public interface IWFHistoryService{

    boolean create(WFHistory et) ;
    void createBatch(List<WFHistory> list) ;
    boolean update(WFHistory et) ;
    void updateBatch(List<WFHistory> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFHistory get(String key) ;
    WFHistory getDraft(WFHistory et) ;
    boolean checkKey(WFHistory et) ;
    boolean save(WFHistory et) ;
    void saveBatch(List<WFHistory> list) ;
    Page<WFHistory> searchDefault(WFHistorySearchContext context) ;

}



