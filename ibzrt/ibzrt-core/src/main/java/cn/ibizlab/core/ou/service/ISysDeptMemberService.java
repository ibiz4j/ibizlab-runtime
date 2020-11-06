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


/**
 * 实体[SysDeptMember] 服务对象接口
 */
public interface ISysDeptMemberService{

    boolean create(SysDeptMember et) ;
    void createBatch(List<SysDeptMember> list) ;
    boolean update(SysDeptMember et) ;
    void updateBatch(List<SysDeptMember> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SysDeptMember get(String key) ;
    SysDeptMember getDraft(SysDeptMember et) ;
    boolean checkKey(SysDeptMember et) ;
    boolean save(SysDeptMember et) ;
    void saveBatch(List<SysDeptMember> list) ;
    Page<SysDeptMember> searchDefault(SysDeptMemberSearchContext context) ;
    List<SysDeptMember> selectByDeptid(String deptid);
    void removeByDeptid(String deptid);
    List<SysDeptMember> selectByUserid(String userid);
    void removeByUserid(String userid);
    List<SysDeptMember> selectByPostid(String postid);
    void removeByPostid(String postid);

}



