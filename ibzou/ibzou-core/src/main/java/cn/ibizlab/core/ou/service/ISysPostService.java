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
import org.springframework.scheduling.annotation.Async;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.ou.domain.SysPost;
import cn.ibizlab.core.ou.filter.SysPostSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysPost] 服务对象接口
 */
public interface ISysPostService extends IService<SysPost> {

    boolean create(SysPost et);
    void createBatch(List<SysPost> list);
    boolean update(SysPost et);
    void updateBatch(List<SysPost> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    SysPost get(String key);
    SysPost getDraft(SysPost et);
    boolean checkKey(SysPost et);
    boolean save(SysPost et);
    void saveBatch(List<SysPost> list);
    Page<SysPost> searchDefault(SysPostSearchContext context);
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


