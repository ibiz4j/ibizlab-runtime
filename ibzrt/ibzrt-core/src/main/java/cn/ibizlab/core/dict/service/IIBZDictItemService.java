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

import cn.ibizlab.core.dict.domain.IBZDictItem;
import cn.ibizlab.core.dict.filter.IBZDictItemSearchContext;


/**
 * 实体[IBZDictItem] 服务对象接口
 */
public interface IIBZDictItemService{

    boolean update(IBZDictItem et) ;
    void updateBatch(List<IBZDictItem> list) ;
    boolean checkKey(IBZDictItem et) ;
    boolean save(IBZDictItem et) ;
    void saveBatch(List<IBZDictItem> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    IBZDictItem get(String key) ;
    boolean create(IBZDictItem et) ;
    void createBatch(List<IBZDictItem> list) ;
    IBZDictItem getDraft(IBZDictItem et) ;
    Page<IBZDictItem> searchDefault(IBZDictItemSearchContext context) ;
    List<IBZDictItem> selectByDictid(String dictid) ;
    void removeByDictid(String dictid) ;
    void saveByDictid(String dictid,List<IBZDictItem> list) ;

}



