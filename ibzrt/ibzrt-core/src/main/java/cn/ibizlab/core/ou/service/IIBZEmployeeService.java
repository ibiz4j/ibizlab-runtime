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

import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.filter.IBZEmployeeSearchContext;


/**
 * 实体[IBZEmployee] 服务对象接口
 */
public interface IIBZEmployeeService{

    boolean remove(String key) ;
    @CacheEvict(value="ibzemployee",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    boolean update(IBZEmployee et) ;
    @CacheEvict(value="ibzemployee",allEntries=true)
    void updateBatch(List<IBZEmployee> list) ;
    boolean checkKey(IBZEmployee et) ;
    IBZEmployee get(String key) ;
    boolean save(IBZEmployee et) ;
    @CacheEvict(value="ibzemployee",allEntries=true)
    void saveBatch(List<IBZEmployee> list) ;
    IBZEmployee initPwd(IBZEmployee et) ;
    IBZEmployee getDraft(IBZEmployee et) ;
    boolean create(IBZEmployee et) ;
    @CacheEvict(value="ibzemployee",allEntries=true)
    void createBatch(List<IBZEmployee> list) ;
    Page<IBZEmployee> searchDefault(IBZEmployeeSearchContext context) ;
    List<IBZEmployee> selectByMdeptid(String deptid) ;
    @CacheEvict(value="ibzemployee",allEntries=true)
    void removeByMdeptid(String deptid) ;
    List<IBZEmployee> selectByOrgid(String orgid) ;
    @CacheEvict(value="ibzemployee",allEntries=true)
    void removeByOrgid(String orgid) ;

}



