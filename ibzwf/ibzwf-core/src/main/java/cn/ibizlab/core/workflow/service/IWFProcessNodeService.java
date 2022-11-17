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

import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;


/**
 * 实体[WFProcessNode] 服务对象接口
 */
public interface IWFProcessNodeService {

    boolean create(WFProcessNode et);
    void createBatch(List<WFProcessNode> list);
    boolean update(WFProcessNode et);
    void updateBatch(List<WFProcessNode> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    WFProcessNode get(String key);
    WFProcessNode getDraft(WFProcessNode et);
    boolean checkKey(WFProcessNode et);
    boolean save(WFProcessNode et);
    void saveBatch(List<WFProcessNode> list);
    Page<WFProcessNode> searchDefault(WFProcessNodeSearchContext context);
    Page<WFProcessNode> searchProcessNode(WFProcessNodeSearchContext context);

}



