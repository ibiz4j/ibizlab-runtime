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

import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;


/**
 * 实体[DictOption] 服务对象接口
 */
public interface IDictOptionService{

    boolean checkKey(DictOption et) ;
    DictOption getDraft(DictOption et) ;
    DictOption get(String key) ;
    boolean update(DictOption et) ;
    void updateBatch(List<DictOption> list) ;
    boolean create(DictOption et) ;
    void createBatch(List<DictOption> list) ;
    boolean save(DictOption et) ;
    void saveBatch(List<DictOption> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    Page<DictOption> searchDefault(DictOptionSearchContext context) ;
    List<DictOption> selectByCatalogId(String id) ;
    void removeByCatalogId(String id) ;

}



