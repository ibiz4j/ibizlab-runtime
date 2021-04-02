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

import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.filter.SysDeptMemberSearchContext;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysDeptMember] 服务对象接口
 */
@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface ISysDeptMemberService extends IService<SysDeptMember> {

    boolean create(SysDeptMember et);
    void createBatch(List<SysDeptMember> list);
    boolean update(SysDeptMember et);
    void updateBatch(List<SysDeptMember> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    SysDeptMember get(String key);
    SysDeptMember getDraft(SysDeptMember et);
    boolean checkKey(SysDeptMember et);
    boolean save(SysDeptMember et);
    void saveBatch(List<SysDeptMember> list);
    SysDeptMember saveDeptMember(SysDeptMember et);
    boolean saveDeptMemberBatch(List<SysDeptMember> etList);
    Page<SysDeptMember> searchDefault(SysDeptMemberSearchContext context);
    List<SysDeptMember> selectByDeptid(String deptid);
    void removeByDeptid(String deptid);
    List<SysDeptMember> selectByUserid(String userid);
    void removeByUserid(String userid);
    List<SysDeptMember> selectByPostid(String postid);
    void removeByPostid(String postid);
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


