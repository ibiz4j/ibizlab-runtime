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

import cn.ibizlab.core.workflow.domain.WFTaskWay;
import cn.ibizlab.core.workflow.filter.WFTaskWaySearchContext;


/**
 * 实体[WFTaskWay] 服务对象接口
 */
public interface IWFTaskWayService{

    boolean create(WFTaskWay et) ;
    void createBatch(List<WFTaskWay> list) ;
    boolean update(WFTaskWay et) ;
    void updateBatch(List<WFTaskWay> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFTaskWay get(String key) ;
    WFTaskWay getDraft(WFTaskWay et) ;
    boolean checkKey(WFTaskWay et) ;
    boolean save(WFTaskWay et) ;
    void saveBatch(List<WFTaskWay> list) ;
    Page<WFTaskWay> searchDefault(WFTaskWaySearchContext context) ;

}



