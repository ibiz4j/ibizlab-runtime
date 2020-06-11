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
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.filter.IBZEmployeeSearchContext;
import cn.ibizlab.core.ou.service.IIBZEmployeeService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.ou.client.IBZEmployeeFeignClient;

/**
 * 实体[人员] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZEmployeeServiceImpl implements IIBZEmployeeService {

    @Autowired
    IBZEmployeeFeignClient iBZEmployeeFeignClient;


    @Override
    public boolean remove(String userid) {
        boolean result=iBZEmployeeFeignClient.remove(userid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZEmployeeFeignClient.removeBatch(idList);
    }

    @Override
    public boolean update(IBZEmployee et) {
        IBZEmployee rt = iBZEmployeeFeignClient.update(et.getUserid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZEmployee> list){
        iBZEmployeeFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean checkKey(IBZEmployee et) {
        return iBZEmployeeFeignClient.checkKey(et);
    }
    @Override
    public IBZEmployee get(String userid) {
		IBZEmployee et=iBZEmployeeFeignClient.get(userid);
        if(et==null){
            et=new IBZEmployee();
            et.setUserid(userid);
        }
        else{
        }
        return  et;
    }

    @Override
    @Transactional
    public boolean save(IBZEmployee et) {
        if(et.getUserid()==null) et.setUserid((String)et.getDefaultKey(true));
        if(!iBZEmployeeFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZEmployee> list) {
        iBZEmployeeFeignClient.saveBatch(list) ;
    }

    @Override
    @Transactional
    public IBZEmployee initPwd(IBZEmployee et) {
        //自定义代码
        return et;
    }

    @Override
    public IBZEmployee getDraft(IBZEmployee et) {
        et=iBZEmployeeFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean create(IBZEmployee et) {
        IBZEmployee rt = iBZEmployeeFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZEmployee> list){
        iBZEmployeeFeignClient.createBatch(list) ;
    }



	@Override
    public List<IBZEmployee> selectByMdeptid(String deptid) {
        IBZEmployeeSearchContext context=new IBZEmployeeSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_mdeptid_eq(deptid);
        return iBZEmployeeFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByMdeptid(String deptid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZEmployee before:selectByMdeptid(deptid)){
            delIds.add(before.getUserid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public List<IBZEmployee> selectByOrgid(String orgid) {
        IBZEmployeeSearchContext context=new IBZEmployeeSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_orgid_eq(orgid);
        return iBZEmployeeFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByOrgid(String orgid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZEmployee before:selectByOrgid(orgid)){
            delIds.add(before.getUserid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZEmployee> searchDefault(IBZEmployeeSearchContext context) {
        Page<IBZEmployee> iBZEmployees=iBZEmployeeFeignClient.searchDefault(context);
        return iBZEmployees;
    }


}


