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

import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.filter.WFProcessDefinitionSearchContext;


/**
 * 实体[WFProcessDefinition] 服务对象接口
 */
public interface IWFProcessDefinitionService {

    boolean create(WFProcessDefinition et);
    void createBatch(List<WFProcessDefinition> list);
    boolean update(WFProcessDefinition et);
    void updateBatch(List<WFProcessDefinition> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    WFProcessDefinition get(String key);
    WFProcessDefinition getDraft(WFProcessDefinition et);
    boolean checkKey(WFProcessDefinition et);
    boolean save(WFProcessDefinition et);
    void saveBatch(List<WFProcessDefinition> list);
    Page<WFProcessDefinition> searchDefault(WFProcessDefinitionSearchContext context);

}



