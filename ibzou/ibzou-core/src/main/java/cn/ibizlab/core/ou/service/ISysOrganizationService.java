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

import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SysOrganization] 服务对象接口
 */
public interface ISysOrganizationService extends IService<SysOrganization>{

    boolean create(SysOrganization et) ;
    @CacheEvict(value="sysorganization",allEntries=true)
    void createBatch(List<SysOrganization> list) ;
    boolean update(SysOrganization et) ;
    @CacheEvict(value="sysorganization",allEntries=true)
    void updateBatch(List<SysOrganization> list) ;
    boolean remove(String key) ;
    @CacheEvict(value="sysorganization",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    SysOrganization get(String key) ;
    SysOrganization getDraft(SysOrganization et) ;
    boolean checkKey(SysOrganization et) ;
    boolean save(SysOrganization et) ;
    @CacheEvict(value="sysorganization",allEntries=true)
    void saveBatch(List<SysOrganization> list) ;
    Page<SysOrganization> searchDefault(SysOrganizationSearchContext context) ;
    List<SysOrganization> selectByParentorgid(String orgid) ;
    @CacheEvict(value="sysorganization",allEntries=true)
    void removeByParentorgid(String orgid) ;
    /**
     *自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return select * from table where id = '1'
     */
    List<JSONObject> select(String sql, Map param);
    /**
     *自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return     update table  set name ='test' where id = '1'
     */
    boolean execute(String sql, Map param);

    List<SysOrganization> getSysorganizationByIds(List<String> ids) ;
    List<SysOrganization> getSysorganizationByEntities(List<SysOrganization> entities) ;
}


