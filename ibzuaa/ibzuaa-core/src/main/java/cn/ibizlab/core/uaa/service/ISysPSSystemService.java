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
import org.springframework.scheduling.annotation.Async;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysPSSystem] 服务对象接口
 */
public interface ISysPSSystemService extends IService<SysPSSystem>{

    boolean create(SysPSSystem et) ;
    void createBatch(List<SysPSSystem> list) ;
    boolean update(SysPSSystem et) ;
    void updateBatch(List<SysPSSystem> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysPSSystem get(String key) ;
    SysPSSystem getDraft(SysPSSystem et) ;
    boolean checkKey(SysPSSystem et) ;
    SysPSSystem prepareApps(SysPSSystem et) ;
    boolean save(SysPSSystem et) ;
    void saveBatch(List<SysPSSystem> list) ;
    SysPSSystem syncPermission(SysPSSystem et) ;
    Page<SysPSSystem> searchDefault(SysPSSystemSearchContext context) ;
    Page<SysPSSystem> searchPick(SysPSSystemSearchContext context) ;
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


