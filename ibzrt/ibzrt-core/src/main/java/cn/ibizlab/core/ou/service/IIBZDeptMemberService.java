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

import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;


/**
 * 实体[IBZDeptMember] 服务对象接口
 */
public interface IIBZDeptMemberService{

    boolean create(IBZDeptMember et) ;
    void createBatch(List<IBZDeptMember> list) ;
    boolean update(IBZDeptMember et) ;
    void updateBatch(List<IBZDeptMember> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    IBZDeptMember get(String key) ;
    IBZDeptMember getDraft(IBZDeptMember et) ;
    boolean checkKey(IBZDeptMember et) ;
    boolean save(IBZDeptMember et) ;
    void saveBatch(List<IBZDeptMember> list) ;
    Page<IBZDeptMember> searchDefault(IBZDeptMemberSearchContext context) ;
    List<IBZDeptMember> selectByDeptid(String deptid) ;
    void removeByDeptid(String deptid) ;
    List<IBZDeptMember> selectByUserid(String userid) ;
    void removeByUserid(String userid) ;
    List<IBZDeptMember> selectByPostid(String postid) ;
    void removeByPostid(String postid) ;

}



