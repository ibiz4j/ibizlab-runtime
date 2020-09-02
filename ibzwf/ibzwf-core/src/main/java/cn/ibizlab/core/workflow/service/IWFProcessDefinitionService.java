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


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFProcessDefinition] 服务对象接口
 */
public interface IWFProcessDefinitionService extends IService<WFProcessDefinition>{

    boolean create(WFProcessDefinition et) ;
    @CacheEvict(value="wfprocessdefinition",allEntries=true)
    void createBatch(List<WFProcessDefinition> list) ;
    boolean update(WFProcessDefinition et) ;
    @CacheEvict(value="wfprocessdefinition",allEntries=true)
    void updateBatch(List<WFProcessDefinition> list) ;
    boolean remove(String key) ;
    @CacheEvict(value="wfprocessdefinition",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    WFProcessDefinition get(String key) ;
    WFProcessDefinition getDraft(WFProcessDefinition et) ;
    boolean checkKey(WFProcessDefinition et) ;
    boolean save(WFProcessDefinition et) ;
    @CacheEvict(value="wfprocessdefinition",allEntries=true)
    void saveBatch(List<WFProcessDefinition> list) ;
    Page<WFProcessDefinition> searchDefault(WFProcessDefinitionSearchContext context) ;
    /**
     *自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return select * from table where id = '1'
     */
    List<JSONObject> select(String sql, Map param);
    /**
     *自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return     update table  set name ='test' where id = '1'
     */
    boolean execute(String sql, Map param);

}


