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

import cn.ibizlab.core.ou.domain.SysTeamMember;
import cn.ibizlab.core.ou.filter.SysTeamMemberSearchContext;


/**
 * 实体[SysTeamMember] 服务对象接口
 */
public interface ISysTeamMemberService {

    boolean create(SysTeamMember et);
    void createBatch(List<SysTeamMember> list);
    boolean update(SysTeamMember et);
    void updateBatch(List<SysTeamMember> list);
    boolean remove(String key);
    void removeBatch(Collection<String> idList);
    SysTeamMember get(String key);
    SysTeamMember getDraft(SysTeamMember et);
    boolean checkKey(SysTeamMember et);
    boolean save(SysTeamMember et);
    void saveBatch(List<SysTeamMember> list);
    Page<SysTeamMember> searchDefault(SysTeamMemberSearchContext context);
    List<SysTeamMember> selectByUserid(String userid);
    void removeByUserid(String userid);
    List<SysTeamMember> selectByPostid(String postid);
    void removeByPostid(String postid);
    List<SysTeamMember> selectByTeamid(String teamid);
    void removeByTeamid(String teamid);

}



