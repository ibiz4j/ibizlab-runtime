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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import cn.ibizlab.core.ou.service.ISysDepartmentService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.SysDepartmentFeignClient;

/**
 * 实体[部门] 服务对象接口实现
 */
@Slf4j
@Service
public class SysDepartmentServiceImpl implements ISysDepartmentService {

    @Autowired
    SysDepartmentFeignClient sysDepartmentFeignClient;

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysEmployeeService sysemployeeService;

    @Override
    public boolean create(SysDepartment et) {
        SysDepartment rt = sysDepartmentFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysDepartment> list){
        sysDepartmentFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysDepartment et) {
        SysDepartment rt = sysDepartmentFeignClient.update(et.getDeptid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysDepartment> list){
        sysDepartmentFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String deptid) {
        boolean result=sysDepartmentFeignClient.remove(deptid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysDepartmentFeignClient.removeBatch(idList);
    }

    @Override
    public SysDepartment get(String deptid) {
		SysDepartment et=sysDepartmentFeignClient.get(deptid);
        if(et==null){
            et=new SysDepartment();
            et.setDeptid(deptid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysDepartment getDraft(SysDepartment et) {
        et=sysDepartmentFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysDepartment et) {
        return sysDepartmentFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysDepartment et) {
        if(et.getDeptid()==null) et.setDeptid((String)et.getDefaultKey(true));
        if(!sysDepartmentFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysDepartment> list) {
        sysDepartmentFeignClient.saveBatch(list) ;
    }



	@Override
    public List<SysDepartment> selectByParentdeptid(String deptid) {
        SysDepartmentSearchContext context=new SysDepartmentSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_pdeptid_eq(deptid);
        return sysDepartmentFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByParentdeptid(String deptid) {
        Set<String> delIds=new HashSet<String>();
        for(SysDepartment before:selectByParentdeptid(deptid)){
            delIds.add(before.getDeptid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<SysDepartment> selectByOrgid(String orgid) {
        SysDepartmentSearchContext context=new SysDepartmentSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_orgid_eq(orgid);
        return sysDepartmentFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByOrgid(String orgid) {
        Set<String> delIds=new HashSet<String>();
        for(SysDepartment before:selectByOrgid(orgid)){
            delIds.add(before.getDeptid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

    @Autowired
    @Lazy
    ISysDepartmentService proxyService;
	@Override
    public void saveByOrgid(String orgid,List<SysDepartment> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<SysDepartment> _update=new ArrayList<SysDepartment>();
        List<SysDepartment> _create=new ArrayList<SysDepartment>();
        for(SysDepartment before:selectByOrgid(orgid)){
            delIds.add(before.getDeptid());
        }
        for(SysDepartment sub:list) {
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
    public Page<SysDepartment> searchDefault(SysDepartmentSearchContext context) {
        Page<SysDepartment> sysDepartments=sysDepartmentFeignClient.searchDefault(context);
        return sysDepartments;
    }



}



