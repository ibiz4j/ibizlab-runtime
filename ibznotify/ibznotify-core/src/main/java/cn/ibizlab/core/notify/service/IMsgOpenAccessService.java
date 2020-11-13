package cn.ibizlab.core.notify.service;

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

import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.filter.MsgOpenAccessSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgOpenAccess] 服务对象接口
 */
public interface IMsgOpenAccessService extends IService<MsgOpenAccess> {

    boolean create(MsgOpenAccess et);
    @CacheEvict(value = "msgopenaccess", allEntries = true)
    void createBatch(List<MsgOpenAccess> list);
    boolean update(MsgOpenAccess et);
    @CacheEvict(value = "msgopenaccess", allEntries = true)
    void updateBatch(List<MsgOpenAccess> list);
    boolean remove(String key);
    @CacheEvict(value = "msgopenaccess", allEntries = true)
    void removeBatch(Collection<String> idList);
    MsgOpenAccess get(String key);
    MsgOpenAccess getDraft(MsgOpenAccess et);
    boolean checkKey(MsgOpenAccess et);
    boolean save(MsgOpenAccess et);
    @CacheEvict(value = "msgopenaccess",allEntries = true)
    void saveBatch(List<MsgOpenAccess> list);
    Page<MsgOpenAccess> searchDefault(MsgOpenAccessSearchContext context);
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


