package cn.ibizlab.core.ou.service;

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

import cn.ibizlab.core.ou.domain.IBZPost;
import cn.ibizlab.core.ou.filter.IBZPostSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[IBZPost] 服务对象接口
 */
public interface IIBZPostService extends IService<IBZPost>{

    boolean update(IBZPost et) ;
    void updateBatch(List<IBZPost> list) ;
    IBZPost getDraft(IBZPost et) ;
    boolean save(IBZPost et) ;
    void saveBatch(List<IBZPost> list) ;
    boolean checkKey(IBZPost et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    IBZPost get(String key) ;
    boolean create(IBZPost et) ;
    void createBatch(List<IBZPost> list) ;
    Page<IBZPost> searchDefault(IBZPostSearchContext context) ;
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


