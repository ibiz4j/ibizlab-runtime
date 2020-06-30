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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;
import cn.ibizlab.core.ou.service.IIBZOrganizationService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.ou.client.IBZOrganizationFeignClient;

/**
 * 实体[单位机构] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZOrganizationServiceImpl implements IIBZOrganizationService {

    @Autowired
    IBZOrganizationFeignClient iBZOrganizationFeignClient;

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;

    @Override
    public boolean create(IBZOrganization et) {
        IBZOrganization rt = iBZOrganizationFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZOrganization> list){
        iBZOrganizationFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(IBZOrganization et) {
        IBZOrganization rt = iBZOrganizationFeignClient.update(et.getOrgid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZOrganization> list){
        iBZOrganizationFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String orgid) {
        boolean result=iBZOrganizationFeignClient.remove(orgid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZOrganizationFeignClient.removeBatch(idList);
    }

    @Override
    public IBZOrganization get(String orgid) {
		IBZOrganization et=iBZOrganizationFeignClient.get(orgid);
        if(et==null){
            et=new IBZOrganization();
            et.setOrgid(orgid);
        }
        else{
        }
        return  et;
    }

    @Override
    public IBZOrganization getDraft(IBZOrganization et) {
        et=iBZOrganizationFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(IBZOrganization et) {
        return iBZOrganizationFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(IBZOrganization et) {
        if(et.getOrgid()==null) et.setOrgid((String)et.getDefaultKey(true));
        if(!iBZOrganizationFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZOrganization> list) {
        iBZOrganizationFeignClient.saveBatch(list) ;
    }



	@Override
    public List<IBZOrganization> selectByParentorgid(String orgid) {
        IBZOrganizationSearchContext context=new IBZOrganizationSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_porgid_eq(orgid);
        return iBZOrganizationFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByParentorgid(String orgid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZOrganization before:selectByParentorgid(orgid)){
            delIds.add(before.getOrgid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZOrganization> searchDefault(IBZOrganizationSearchContext context) {
        Page<IBZOrganization> iBZOrganizations=iBZOrganizationFeignClient.searchDefault(context);
        return iBZOrganizations;
    }


}


