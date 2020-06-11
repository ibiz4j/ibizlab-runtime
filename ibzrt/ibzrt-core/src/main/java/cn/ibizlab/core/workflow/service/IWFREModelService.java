package cn.ibizlab.core.workflow.service;

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

import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.core.workflow.filter.WFREModelSearchContext;


/**
 * 实体[WFREModel] 服务对象接口
 */
public interface IWFREModelService{

    boolean create(WFREModel et) ;
    void createBatch(List<WFREModel> list) ;
    WFREModel get(String key) ;
    boolean save(WFREModel et) ;
    void saveBatch(List<WFREModel> list) ;
    boolean update(WFREModel et) ;
    void updateBatch(List<WFREModel> list) ;
    WFREModel getDraft(WFREModel et) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean checkKey(WFREModel et) ;
    Page<WFREModel> searchDefault(WFREModelSearchContext context) ;

}



