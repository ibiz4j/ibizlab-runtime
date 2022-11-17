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
import org.springframework.scheduling.annotation.Async;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;


/**
 * 实体[WFProcessInstance] 服务对象接口
 */
public interface IWFProcessInstanceService {

    boolean create(WFProcessInstance et);
    void createBatch(List<WFProcessInstance> list);
    boolean update(WFProcessInstance et);
    void updateBatch(List<WFProcessInstance> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    WFProcessInstance get(String key);
    WFProcessInstance getDraft(WFProcessInstance et);
    boolean checkKey(WFProcessInstance et);
    WFProcessInstance jump(WFProcessInstance et);
    boolean jumpBatch(List<WFProcessInstance> etList);
    WFProcessInstance restart(WFProcessInstance et);
    boolean restartBatch(List<WFProcessInstance> etList);
    boolean save(WFProcessInstance et);
    void saveBatch(List<WFProcessInstance> list);
    Page<WFProcessInstance> searchActiveProcessInstance(WFProcessInstanceSearchContext context);
    Page<WFProcessInstance> searchDefault(WFProcessInstanceSearchContext context);

}



