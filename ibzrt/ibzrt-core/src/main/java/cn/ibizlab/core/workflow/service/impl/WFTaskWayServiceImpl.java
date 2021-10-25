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
import cn.ibizlab.util.errors.BadRequestAlertException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFTaskWay;
import cn.ibizlab.core.workflow.filter.WFTaskWaySearchContext;
import cn.ibizlab.core.workflow.service.IWFTaskWayService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.workflow.client.WFTaskWayFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        CachedBeanCopier.copy(rt, et);
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
        CachedBeanCopier.copy(rt, et);
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
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), sequenceflowid);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFTaskWay getDraft(WFTaskWay et) {
        et=wFTaskWayFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(WFTaskWay et) {
        return wFTaskWayFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFTaskWay et) {
        boolean result = true;
        Object rt = wFTaskWayFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), WFTaskWay.class);
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



