package cn.ibizlab.core.uaa.service;

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

import cn.ibizlab.core.uaa.domain.SysAuthLog;
import cn.ibizlab.core.uaa.filter.SysAuthLogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysAuthLog] 服务对象接口
 */
public interface ISysAuthLogService extends IService<SysAuthLog>{

    SysAuthLog getDraft(SysAuthLog et) ;
    boolean update(SysAuthLog et) ;
    void updateBatch(List<SysAuthLog> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean create(SysAuthLog et) ;
    void createBatch(List<SysAuthLog> list) ;
    boolean checkKey(SysAuthLog et) ;
    SysAuthLog get(String key) ;
    boolean save(SysAuthLog et) ;
    void saveBatch(List<SysAuthLog> list) ;
    Page<SysAuthLog> searchDefault(SysAuthLogSearchContext context) ;
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


