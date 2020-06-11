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

import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;


/**
 * 实体[IBZOrganization] 服务对象接口
 */
public interface IIBZOrganizationService{

    boolean save(IBZOrganization et) ;
    @CacheEvict(value="ibzorganization",allEntries=true)
    void saveBatch(List<IBZOrganization> list) ;
    boolean checkKey(IBZOrganization et) ;
    IBZOrganization get(String key) ;
    boolean create(IBZOrganization et) ;
    @CacheEvict(value="ibzorganization",allEntries=true)
    void createBatch(List<IBZOrganization> list) ;
    boolean remove(String key) ;
    @CacheEvict(value="ibzorganization",allEntries=true)
    void removeBatch(Collection<String> idList) ;
    IBZOrganization getDraft(IBZOrganization et) ;
    boolean update(IBZOrganization et) ;
    @CacheEvict(value="ibzorganization",allEntries=true)
    void updateBatch(List<IBZOrganization> list) ;
    Page<IBZOrganization> searchDefault(IBZOrganizationSearchContext context) ;
    Page<IBZOrganization> searchSelectPOrg(IBZOrganizationSearchContext context) ;
    Page<IBZOrganization> searchSelectSOrg(IBZOrganizationSearchContext context) ;
    List<IBZOrganization> selectByParentorgid(String orgid) ;
    @CacheEvict(value="ibzorganization",allEntries=true)
    void removeByParentorgid(String orgid) ;

}



