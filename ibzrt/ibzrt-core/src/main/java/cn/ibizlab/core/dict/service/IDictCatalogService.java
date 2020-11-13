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
import org.springframework.scheduling.annotation.Async;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;


/**
 * 实体[DictCatalog] 服务对象接口
 */
public interface IDictCatalogService {

    boolean create(DictCatalog et);
    void createBatch(List<DictCatalog> list);
    boolean update(DictCatalog et);
    void updateBatch(List<DictCatalog> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    DictCatalog get(String key);
    DictCatalog getDraft(DictCatalog et);
    boolean checkKey(DictCatalog et);
    boolean save(DictCatalog et);
    void saveBatch(List<DictCatalog> list);
    Page<DictCatalog> searchDefault(DictCatalogSearchContext context);

}



