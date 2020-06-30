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

import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.filter.WFGroupSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFGroup] 服务对象接口
 */
public interface IWFGroupService extends IService<WFGroup>{

    boolean create(WFGroup et) ;
    void createBatch(List<WFGroup> list) ;
    boolean update(WFGroup et) ;
    void updateBatch(List<WFGroup> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFGroup get(String key) ;
    WFGroup getDraft(WFGroup et) ;
    boolean checkKey(WFGroup et) ;
    boolean save(WFGroup et) ;
    void saveBatch(List<WFGroup> list) ;
    Page<WFGroup> searchDefault(WFGroupSearchContext context) ;
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


