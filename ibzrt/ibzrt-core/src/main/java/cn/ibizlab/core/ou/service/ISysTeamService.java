package cn.ibizlab.core.ou.service;

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

import cn.ibizlab.core.ou.domain.SysTeam;
import cn.ibizlab.core.ou.filter.SysTeamSearchContext;


/**
 * 实体[SysTeam] 服务对象接口
 */
public interface ISysTeamService {

    boolean create(SysTeam et);
    void createBatch(List<SysTeam> list);
    boolean update(SysTeam et);
    void updateBatch(List<SysTeam> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    SysTeam get(String key);
    SysTeam getDraft(SysTeam et);
    boolean checkKey(SysTeam et);
    boolean save(SysTeam et);
    void saveBatch(List<SysTeam> list);
    Page<SysTeam> searchDefault(SysTeamSearchContext context);

}



