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

import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[MsgTemplate] 服务对象接口
 */
@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface IMsgTemplateService extends IService<MsgTemplate> {

    boolean create(MsgTemplate et);
    @CacheEvict(value = "msgtemplate", allEntries = true)
    void createBatch(List<MsgTemplate> list);
    boolean update(MsgTemplate et);
    @CacheEvict(value = "msgtemplate", allEntries = true)
    void updateBatch(List<MsgTemplate> list);
    boolean remove(String key);
    @CacheEvict(value = "msgtemplate", allEntries = true)
    void removeBatch(Collection<String> idList);
    MsgTemplate get(String key);
    MsgTemplate getDraft(MsgTemplate et);
    boolean checkKey(MsgTemplate et);
    boolean save(MsgTemplate et);
    @CacheEvict(value = "msgtemplate",allEntries = true)
    void saveBatch(List<MsgTemplate> list);
    Page<MsgTemplate> searchDefault(MsgTemplateSearchContext context);
    List<MsgTemplate> selectByAccessId(String id);
    @CacheEvict(value = "msgtemplate", allEntries = true)
    void removeByAccessId(String id);
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


