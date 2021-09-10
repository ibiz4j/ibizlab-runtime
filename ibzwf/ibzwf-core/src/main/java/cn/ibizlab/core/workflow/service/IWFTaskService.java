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

import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;


/**
 * 实体[WFTask] 服务对象接口
 */
public interface IWFTaskService {

    boolean create(WFTask et);
    void createBatch(List<WFTask> list);
    boolean update(WFTask et);
    void updateBatch(List<WFTask> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    WFTask get(String key);
    WFTask getDraft(WFTask et);
    boolean checkKey(WFTask et);
    boolean save(WFTask et);
    void saveBatch(List<WFTask> list);
    WFTask userCustom(WFTask et);
    boolean userCustomBatch(List<WFTask> etList);
    Page<WFTask> searchDefault(WFTaskSearchContext context);
    Page<WFTask> searchDoneTask(WFTaskSearchContext context);
    Page<WFTask> searchFinishTask(WFTaskSearchContext context);
    Page<WFTask> searchTodoTask(WFTaskSearchContext context);
    Page<WFTask> searchToreadTask(WFTaskSearchContext context);

}



