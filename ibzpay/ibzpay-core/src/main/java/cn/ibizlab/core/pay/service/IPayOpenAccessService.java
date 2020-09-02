package cn.ibizlab.core.pay.service;

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

import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.core.pay.filter.PayOpenAccessSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[PayOpenAccess] 服务对象接口
 */
public interface IPayOpenAccessService extends IService<PayOpenAccess>{

    boolean create(PayOpenAccess et) ;
    void createBatch(List<PayOpenAccess> list) ;
    boolean update(PayOpenAccess et) ;
    void updateBatch(List<PayOpenAccess> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    PayOpenAccess get(String key) ;
    PayOpenAccess getDraft(PayOpenAccess et) ;
    boolean checkKey(PayOpenAccess et) ;
    boolean save(PayOpenAccess et) ;
    void saveBatch(List<PayOpenAccess> list) ;
    Page<PayOpenAccess> searchDefault(PayOpenAccessSearchContext context) ;
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


