package cn.ibizlab.core.dict.service;

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

import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[DictCatalog] 服务对象接口
 */
public interface IDictCatalogService extends IService<DictCatalog>{

    boolean create(DictCatalog et) ;
    void createBatch(List<DictCatalog> list) ;
    boolean update(DictCatalog et) ;
    void updateBatch(List<DictCatalog> list) ;
    boolean save(DictCatalog et) ;
    void saveBatch(List<DictCatalog> list) ;
    DictCatalog get(String key) ;
    DictCatalog getDraft(DictCatalog et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(DictCatalog et) ;
    Page<DictCatalog> searchDefault(DictCatalogSearchContext context) ;
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


