package cn.ibizlab.core.dict.service;

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

import cn.ibizlab.core.dict.domain.IBZDict;
import cn.ibizlab.core.dict.filter.IBZDictSearchContext;


/**
 * 实体[IBZDict] 服务对象接口
 */
public interface IIBZDictService{

    boolean create(IBZDict et) ;
    void createBatch(List<IBZDict> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean update(IBZDict et) ;
    void updateBatch(List<IBZDict> list) ;
    IBZDict getDraft(IBZDict et) ;
    boolean save(IBZDict et) ;
    void saveBatch(List<IBZDict> list) ;
    IBZDict get(String key) ;
    boolean checkKey(IBZDict et) ;
    Page<IBZDict> searchDefault(IBZDictSearchContext context) ;

}



