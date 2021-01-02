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

import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgBody] 服务对象接口
 */
@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface IMsgBodyService extends IService<MsgBody> {

    boolean create(MsgBody et);
    void createBatch(List<MsgBody> list);
    boolean update(MsgBody et);
    void updateBatch(List<MsgBody> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    MsgBody get(String key);
    MsgBody getDraft(MsgBody et);
    boolean checkKey(MsgBody et);
    boolean save(MsgBody et);
    void saveBatch(List<MsgBody> list);
    Page<MsgBody> searchDefault(MsgBodySearchContext context);
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


