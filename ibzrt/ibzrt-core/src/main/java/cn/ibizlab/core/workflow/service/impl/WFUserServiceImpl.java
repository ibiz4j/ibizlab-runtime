package cn.ibizlab.core.workflow.service.impl;

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
import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.core.workflow.filter.WFUserSearchContext;
import cn.ibizlab.core.workflow.service.IWFUserService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.workflow.client.WFUserFeignClient;

/**
 * 实体[用户] 服务对象接口实现
 */
@Slf4j
@Service
public class WFUserServiceImpl implements IWFUserService {

    @Autowired
    WFUserFeignClient wFUserFeignClient;


    @Override
    public boolean create(WFUser et) {
        WFUser rt = wFUserFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<WFUser> list){
        wFUserFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFUser et) {
        WFUser rt = wFUserFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<WFUser> list){
        wFUserFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=wFUserFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFUserFeignClient.removeBatch(idList);
    }

    @Override
    public WFUser get(String id) {
		WFUser et=wFUserFeignClient.get(id);
        if(et==null){
            et=new WFUser();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFUser getDraft(WFUser et) {
        et=wFUserFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(WFUser et) {
        return wFUserFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFUser et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!wFUserFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<WFUser> list) {
        wFUserFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUser> searchDefault(WFUserSearchContext context) {
        Page<WFUser> wFUsers=wFUserFeignClient.searchDefault(context);
        return wFUsers;
    }



}



