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

import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.core.notify.filter.MsgUserAccountSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgUserAccount] 服务对象接口
 */
public interface IMsgUserAccountService extends IService<MsgUserAccount> {

    boolean create(MsgUserAccount et);
    void createBatch(List<MsgUserAccount> list);
    boolean update(MsgUserAccount et);
    void updateBatch(List<MsgUserAccount> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    MsgUserAccount get(String key);
    MsgUserAccount getDraft(MsgUserAccount et);
    boolean checkKey(MsgUserAccount et);
    boolean save(MsgUserAccount et);
    void saveBatch(List<MsgUserAccount> list);
    Page<MsgUserAccount> searchDefault(MsgUserAccountSearchContext context);
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


