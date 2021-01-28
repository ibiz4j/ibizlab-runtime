package cn.ibizlab.core.pay.service;

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

import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.core.pay.filter.PayOpenAccessSearchContext;


/**
 * 实体[PayOpenAccess] 服务对象接口
 */
public interface IPayOpenAccessService {

    boolean create(PayOpenAccess et);
    void createBatch(List<PayOpenAccess> list);
    boolean update(PayOpenAccess et);
    void updateBatch(List<PayOpenAccess> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    PayOpenAccess get(String key);
    PayOpenAccess getDraft(PayOpenAccess et);
    boolean checkKey(PayOpenAccess et);
    boolean save(PayOpenAccess et);
    void saveBatch(List<PayOpenAccess> list);
    Page<PayOpenAccess> searchDefault(PayOpenAccessSearchContext context);

}



