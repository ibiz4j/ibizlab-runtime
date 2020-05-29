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

import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[IBZDeptMember] 服务对象接口
 */
public interface IIBZDeptMemberService extends IService<IBZDeptMember>{

    boolean update(IBZDeptMember et) ;
    void updateBatch(List<IBZDeptMember> list) ;
    boolean create(IBZDeptMember et) ;
    void createBatch(List<IBZDeptMember> list) ;
    boolean save(IBZDeptMember et) ;
    void saveBatch(List<IBZDeptMember> list) ;
    IBZDeptMember getDraft(IBZDeptMember et) ;
    IBZDeptMember get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(IBZDeptMember et) ;
    Page<IBZDeptMember> searchDefault(IBZDeptMemberSearchContext context) ;
    List<IBZDeptMember> selectByDeptid(String deptid) ;
    void removeByDeptid(String deptid) ;
    List<IBZDeptMember> selectByUserid(String userid) ;
    void removeByUserid(String userid) ;
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


