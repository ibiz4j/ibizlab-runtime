package cn.ibizlab.core.ou.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import cn.ibizlab.util.errors.BadRequestAlertException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;
import cn.ibizlab.core.ou.service.ISysOrganizationService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.SysOrganizationFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[单位机构] 服务对象接口实现
 */
@Slf4j
@Service
public class SysOrganizationServiceImpl implements ISysOrganizationService {

    @Autowired
    SysOrganizationFeignClient sysOrganizationFeignClient;


    @Override
    public boolean create(SysOrganization et) {
        SysOrganization rt = sysOrganizationFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysOrganization> list){
        sysOrganizationFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysOrganization et) {
        SysOrganization rt = sysOrganizationFeignClient.update(et.getOrgid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysOrganization> list){
        sysOrganizationFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String orgid) {
        boolean result=sysOrganizationFeignClient.remove(orgid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysOrganizationFeignClient.removeBatch(idList);
    }

    @Override
    public SysOrganization get(String orgid) {
		SysOrganization et=sysOrganizationFeignClient.get(orgid);
        if(et==null){
            et=new SysOrganization();
            et.setOrgid(orgid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysOrganization getDraft(SysOrganization et) {
        et=sysOrganizationFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SysOrganization et) {
        return sysOrganizationFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysOrganization et) {
        boolean result = true;
        Object rt = sysOrganizationFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), SysOrganization.class);
                if (rt != null) {
                    CachedBeanCopier.copy(rt, et);
                }
            } else if (rt instanceof Boolean) {
                result = (boolean) rt;
            }
        } catch (Exception e) {
        }
            return result;
    }

    @Override
    public void saveBatch(List<SysOrganization> list) {
        sysOrganizationFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysOrganization> selectByParentorgid(String orgid) {
        SysOrganizationSearchContext context=new SysOrganizationSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_porgid_eq(orgid);
        return sysOrganizationFeignClient.searchDefault(context).getContent();
    }
    @Override
    public List<SysOrganization> selectByParentorgid(Collection<String> ids) {
        //暂未支持
        return null;
    }


    @Override
    public void removeByParentorgid(String orgid) {
        Set<String> delIds=new HashSet<String>();
        for(SysOrganization before:selectByParentorgid(orgid)){
            delIds.add(before.getOrgid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysOrganization> searchDefault(SysOrganizationSearchContext context) {
        Page<SysOrganization> sysOrganizations=sysOrganizationFeignClient.searchDefault(context);
        return sysOrganizations;
    }

}



