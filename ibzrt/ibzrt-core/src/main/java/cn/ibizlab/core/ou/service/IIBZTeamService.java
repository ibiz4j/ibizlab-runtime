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
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.ou.domain.IBZTeam;
import cn.ibizlab.core.ou.filter.IBZTeamSearchContext;


/**
 * 实体[IBZTeam] 服务对象接口
 */
public interface IIBZTeamService{

    boolean create(IBZTeam et) ;
    void createBatch(List<IBZTeam> list) ;
    boolean update(IBZTeam et) ;
    void updateBatch(List<IBZTeam> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    IBZTeam get(String key) ;
    IBZTeam getDraft(IBZTeam et) ;
    boolean checkKey(IBZTeam et) ;
    boolean save(IBZTeam et) ;
    void saveBatch(List<IBZTeam> list) ;
    Page<IBZTeam> searchDefault(IBZTeamSearchContext context) ;

}



