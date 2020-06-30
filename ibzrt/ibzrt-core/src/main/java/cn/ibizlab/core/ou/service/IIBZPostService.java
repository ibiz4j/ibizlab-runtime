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

import cn.ibizlab.core.ou.domain.IBZPost;
import cn.ibizlab.core.ou.filter.IBZPostSearchContext;


/**
 * 实体[IBZPost] 服务对象接口
 */
public interface IIBZPostService{

    boolean create(IBZPost et) ;
    void createBatch(List<IBZPost> list) ;
    boolean update(IBZPost et) ;
    void updateBatch(List<IBZPost> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    IBZPost get(String key) ;
    IBZPost getDraft(IBZPost et) ;
    boolean checkKey(IBZPost et) ;
    boolean save(IBZPost et) ;
    void saveBatch(List<IBZPost> list) ;
    Page<IBZPost> searchDefault(IBZPostSearchContext context) ;

}



