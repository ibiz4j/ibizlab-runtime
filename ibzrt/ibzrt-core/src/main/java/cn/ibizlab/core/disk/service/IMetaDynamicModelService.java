package cn.ibizlab.core.disk.service;

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

import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.filter.MetaDynamicModelSearchContext;


/**
 * 实体[MetaDynamicModel] 服务对象接口
 */
public interface IMetaDynamicModelService {

    boolean create(MetaDynamicModel et);
    void createBatch(List<MetaDynamicModel> list);
    boolean update(MetaDynamicModel et);
    void updateBatch(List<MetaDynamicModel> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    MetaDynamicModel get(String key);
    MetaDynamicModel getDraft(MetaDynamicModel et);
    boolean checkKey(MetaDynamicModel et);
    MetaDynamicModel init(MetaDynamicModel et);
    boolean initBatch(List<MetaDynamicModel> etList);
    MetaDynamicModel publish(MetaDynamicModel et);
    boolean publishBatch(List<MetaDynamicModel> etList);
    boolean save(MetaDynamicModel et);
    void saveBatch(List<MetaDynamicModel> list);
    Page<MetaDynamicModel> searchDefault(MetaDynamicModelSearchContext context);
    Page<MetaDynamicModel> searchDynaInst(MetaDynamicModelSearchContext context);
    List<MetaDynamicModel> selectByPdynainstid(String configid);
    void removeByPdynainstid(String configid);

}



