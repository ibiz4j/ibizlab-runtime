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

import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;


/**
 * 实体[WFProcessInstance] 服务对象接口
 */
public interface IWFProcessInstanceService{

    boolean update(WFProcessInstance et) ;
    void updateBatch(List<WFProcessInstance> list) ;
    boolean save(WFProcessInstance et) ;
    void saveBatch(List<WFProcessInstance> list) ;
    WFProcessInstance getDraft(WFProcessInstance et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFProcessInstance get(String key) ;
    boolean checkKey(WFProcessInstance et) ;
    boolean create(WFProcessInstance et) ;
    void createBatch(List<WFProcessInstance> list) ;
    Page<WFProcessInstance> searchDefault(WFProcessInstanceSearchContext context) ;

}



