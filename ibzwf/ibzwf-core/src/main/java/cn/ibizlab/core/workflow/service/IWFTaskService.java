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

import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;


/**
 * 实体[WFTask] 服务对象接口
 */
public interface IWFTaskService{

    boolean create(WFTask et) ;
    void createBatch(List<WFTask> list) ;
    boolean update(WFTask et) ;
    void updateBatch(List<WFTask> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFTask get(String key) ;
    WFTask getDraft(WFTask et) ;
    boolean checkKey(WFTask et) ;
    boolean save(WFTask et) ;
    void saveBatch(List<WFTask> list) ;
    Page<WFTask> searchDefault(WFTaskSearchContext context) ;

}



