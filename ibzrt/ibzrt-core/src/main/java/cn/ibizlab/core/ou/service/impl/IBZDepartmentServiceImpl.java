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
import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.filter.IBZDepartmentSearchContext;
import cn.ibizlab.core.ou.service.IIBZDepartmentService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.IBZDepartmentFeignClient;

/**
 * 实体[部门] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZDepartmentServiceImpl implements IIBZDepartmentService {

    @Autowired
    IBZDepartmentFeignClient iBZDepartmentFeignClient;

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;

    @Override
    public boolean create(IBZDepartment et) {
        IBZDepartment rt = iBZDepartmentFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZDepartment> list){
        iBZDepartmentFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(IBZDepartment et) {
        IBZDepartment rt = iBZDepartmentFeignClient.update(et.getDeptid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZDepartment> list){
        iBZDepartmentFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String deptid) {
        boolean result=iBZDepartmentFeignClient.remove(deptid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZDepartmentFeignClient.removeBatch(idList);
    }

    @Override
    public IBZDepartment get(String deptid) {
		IBZDepartment et=iBZDepartmentFeignClient.get(deptid);
        if(et==null){
            et=new IBZDepartment();
            et.setDeptid(deptid);
        }
        else{
        }
        return  et;
    }

    @Override
    public IBZDepartment getDraft(IBZDepartment et) {
        et=iBZDepartmentFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(IBZDepartment et) {
        return iBZDepartmentFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(IBZDepartment et) {
        if(et.getDeptid()==null) et.setDeptid((String)et.getDefaultKey(true));
        if(!iBZDepartmentFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZDepartment> list) {
        iBZDepartmentFeignClient.saveBatch(list) ;
    }



	@Override
    public List<IBZDepartment> selectByParentdeptid(String deptid) {
        IBZDepartmentSearchContext context=new IBZDepartmentSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_pdeptid_eq(deptid);
        return iBZDepartmentFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByParentdeptid(String deptid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZDepartment before:selectByParentdeptid(deptid)){
            delIds.add(before.getDeptid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<IBZDepartment> selectByOrgid(String orgid) {
        IBZDepartmentSearchContext context=new IBZDepartmentSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_orgid_eq(orgid);
        return iBZDepartmentFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByOrgid(String orgid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZDepartment before:selectByOrgid(orgid)){
            delIds.add(before.getDeptid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

    @Autowired
    @Lazy
    IIBZDepartmentService proxyService;
	@Override
    public void saveByOrgid(String orgid,List<IBZDepartment> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<IBZDepartment> _update=new ArrayList<IBZDepartment>();
        List<IBZDepartment> _create=new ArrayList<IBZDepartment>();
        for(IBZDepartment before:selectByOrgid(orgid)){
            delIds.add(before.getDeptid());
        }
        for(IBZDepartment sub:list) {
            sub.setOrgid(orgid);
            if(ObjectUtils.isEmpty(sub.getDeptid()))
                sub.setDeptid((String)sub.getDefaultKey(true));
            if(delIds.contains(sub.getDeptid())) {
                delIds.remove(sub.getDeptid());
                _update.add(sub);
            }
            else
                _create.add(sub);
        }
        if(_update.size()>0)
            proxyService.updateBatch(_update);
        if(_create.size()>0)
            proxyService.createBatch(_create);
        if(delIds.size()>0)
            proxyService.removeBatch(delIds);
	}



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZDepartment> searchDefault(IBZDepartmentSearchContext context) {
        Page<IBZDepartment> iBZDepartments=iBZDepartmentFeignClient.searchDefault(context);
        return iBZDepartments;
    }



}



