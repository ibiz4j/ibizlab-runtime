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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.core.workflow.filter.WFREModelSearchContext;
import cn.ibizlab.core.workflow.service.IWFREModelService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.workflow.client.WFREModelFeignClient;

/**
 * 实体[流程模型] 服务对象接口实现
 */
@Slf4j
@Service
public class WFREModelServiceImpl implements IWFREModelService {

    @Autowired
    WFREModelFeignClient wFREModelFeignClient;


    @Override
    public boolean create(WFREModel et) {
        WFREModel rt = wFREModelFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<WFREModel> list){
        wFREModelFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFREModel et) {
        WFREModel rt = wFREModelFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<WFREModel> list){
        wFREModelFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=wFREModelFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFREModelFeignClient.removeBatch(idList);
    }

    @Override
    public WFREModel get(String id) {
		WFREModel et=wFREModelFeignClient.get(id);
        if(et==null){
            et=new WFREModel();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFREModel getDraft(WFREModel et) {
        et=wFREModelFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(WFREModel et) {
        return wFREModelFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFREModel et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!wFREModelFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<WFREModel> list) {
        wFREModelFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFREModel> searchDefault(WFREModelSearchContext context) {
        Page<WFREModel> wFREModels=wFREModelFeignClient.searchDefault(context);
        return wFREModels;
    }



}



