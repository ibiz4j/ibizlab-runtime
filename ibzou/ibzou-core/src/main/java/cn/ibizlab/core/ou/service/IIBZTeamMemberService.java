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

import cn.ibizlab.core.ou.domain.IBZTeamMember;
import cn.ibizlab.core.ou.filter.IBZTeamMemberSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[IBZTeamMember] 服务对象接口
 */
public interface IIBZTeamMemberService extends IService<IBZTeamMember>{

    boolean create(IBZTeamMember et) ;
    void createBatch(List<IBZTeamMember> list) ;
    boolean update(IBZTeamMember et) ;
    void updateBatch(List<IBZTeamMember> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    IBZTeamMember get(String key) ;
    IBZTeamMember getDraft(IBZTeamMember et) ;
    boolean checkKey(IBZTeamMember et) ;
    boolean save(IBZTeamMember et) ;
    void saveBatch(List<IBZTeamMember> list) ;
    Page<IBZTeamMember> searchDefault(IBZTeamMemberSearchContext context) ;
    List<IBZTeamMember> selectByUserid(String userid) ;
    void removeByUserid(String userid) ;
    List<IBZTeamMember> selectByPostid(String postid) ;
    void removeByPostid(String postid) ;
    List<IBZTeamMember> selectByTeamid(String teamid) ;
    void removeByTeamid(String teamid) ;
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


