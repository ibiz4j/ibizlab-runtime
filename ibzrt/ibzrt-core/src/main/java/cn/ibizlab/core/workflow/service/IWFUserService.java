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

import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.core.workflow.filter.WFUserSearchContext;


/**
 * 实体[WFUser] 服务对象接口
 */
public interface IWFUserService{

    boolean create(WFUser et) ;
    void createBatch(List<WFUser> list) ;
    boolean update(WFUser et) ;
    void updateBatch(List<WFUser> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    WFUser get(String key) ;
    WFUser getDraft(WFUser et) ;
    boolean checkKey(WFUser et) ;
    boolean save(WFUser et) ;
    void saveBatch(List<WFUser> list) ;
    Page<WFUser> searchDefault(WFUserSearchContext context) ;

}



