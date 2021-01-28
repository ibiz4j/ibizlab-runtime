package cn.ibizlab.core.notify.service;

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

import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;


/**
 * 实体[MsgBody] 服务对象接口
 */
public interface IMsgBodyService {

    boolean create(MsgBody et);
    void createBatch(List<MsgBody> list);
    boolean update(MsgBody et);
    void updateBatch(List<MsgBody> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    MsgBody get(String key);
    MsgBody getDraft(MsgBody et);
    boolean checkKey(MsgBody et);
    boolean save(MsgBody et);
    void saveBatch(List<MsgBody> list);
    Page<MsgBody> searchDefault(MsgBodySearchContext context);

}



