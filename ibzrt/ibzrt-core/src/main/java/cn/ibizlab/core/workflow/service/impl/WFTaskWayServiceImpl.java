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
import cn.ibizlab.core.workflow.domain.WFTaskWay;
import cn.ibizlab.core.workflow.filter.WFTaskWaySearchContext;
import cn.ibizlab.core.workflow.service.IWFTaskWayService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.workflow.client.WFTaskWayFeignClient;

/**
 * 实体[操作路径] 服务对象接口实现
 */
@Slf4j
@Service
public class WFTaskWayServiceImpl implements IWFTaskWayService {

    @Autowired
    WFTaskWayFeignClient wFTaskWayFeignClient;


    @Override
    public boolean create(WFTaskWay et) {
        WFTaskWay rt = wFTaskWayFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<WFTaskWay> list){
        wFTaskWayFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFTaskWay et) {
        WFTaskWay rt = wFTaskWayFeignClient.update(et.getSequenceflowid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<WFTaskWay> list){
        wFTaskWayFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String sequenceflowid) {
        boolean result=wFTaskWayFeignClient.remove(sequenceflowid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFTaskWayFeignClient.removeBatch(idList);
    }

    @Override
    public WFTaskWay get(String sequenceflowid) {
		WFTaskWay et=wFTaskWayFeignClient.get(sequenceflowid);
        if(et==null){
            et=new WFTaskWay();
            et.setSequenceflowid(sequenceflowid);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFTaskWay getDraft(WFTaskWay et) {
        et=wFTaskWayFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(WFTaskWay et) {
        return wFTaskWayFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFTaskWay et) {
        if(et.getSequenceflowid()==null) et.setSequenceflowid((String)et.getDefaultKey(true));
        if(!wFTaskWayFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<WFTaskWay> list) {
        wFTaskWayFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFTaskWay> searchDefault(WFTaskWaySearchContext context) {
        Page<WFTaskWay> wFTaskWays=wFTaskWayFeignClient.searchDefault(context);
        return wFTaskWays;
    }



}



