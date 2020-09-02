package cn.ibizlab.core.workflow.service;

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

import cn.ibizlab.core.workflow.domain.WFMember;
import cn.ibizlab.core.workflow.filter.WFMemberSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[WFMember] 服务对象接口
 */
public interface IWFMemberService extends IService<WFMember>{

    boolean create(WFMember et) ;
    void createBatch(List<WFMember> list) ;
    boolean update(WFMember et) ;
    void updateBatch(List<WFMember> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFMember get(String key) ;
    WFMember getDraft(WFMember et) ;
    boolean checkKey(WFMember et) ;
    boolean save(WFMember et) ;
    void saveBatch(List<WFMember> list) ;
    Page<WFMember> searchDefault(WFMemberSearchContext context) ;
    List<WFMember> selectByGroupid(String id) ;
    void removeByGroupid(String id) ;
    void saveByGroupid(String id,List<WFMember> list) ;
    List<WFMember> selectByUserid(String id) ;
    void removeByUserid(String id) ;
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

    List<WFMember> getWfmemberByIds(List<String> ids) ;
    List<WFMember> getWfmemberByEntities(List<WFMember> entities) ;
}


