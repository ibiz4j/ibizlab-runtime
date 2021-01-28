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

import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.filter.PayTradeSearchContext;


/**
 * 实体[PayTrade] 服务对象接口
 */
public interface IPayTradeService {

    boolean create(PayTrade et);
    void createBatch(List<PayTrade> list);
    boolean update(PayTrade et);
    void updateBatch(List<PayTrade> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    PayTrade get(String key);
    PayTrade getDraft(PayTrade et);
    boolean checkKey(PayTrade et);
    boolean save(PayTrade et);
    void saveBatch(List<PayTrade> list);
    Page<PayTrade> searchDefault(PayTradeSearchContext context);
    List<PayTrade> selectByAccessId(String id);
    void removeByAccessId(String id);

}



