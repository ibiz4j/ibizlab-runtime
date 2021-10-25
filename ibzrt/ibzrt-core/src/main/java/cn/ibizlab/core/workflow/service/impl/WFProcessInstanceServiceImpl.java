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
import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import cn.ibizlab.core.workflow.service.IWFProcessInstanceService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.workflow.client.WFProcessInstanceFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[流程实例] 服务对象接口实现
 */
@Slf4j
@Service
public class WFProcessInstanceServiceImpl implements IWFProcessInstanceService {

    @Autowired
    WFProcessInstanceFeignClient wFProcessInstanceFeignClient;


    @Override
    public boolean create(WFProcessInstance et) {
        WFProcessInstance rt = wFProcessInstanceFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<WFProcessInstance> list){
        wFProcessInstanceFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFProcessInstance et) {
        WFProcessInstance rt = wFProcessInstanceFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<WFProcessInstance> list){
        wFProcessInstanceFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=wFProcessInstanceFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFProcessInstanceFeignClient.removeBatch(idList);
    }

    @Override
    public WFProcessInstance get(String id) {
		WFProcessInstance et=wFProcessInstanceFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFProcessInstance getDraft(WFProcessInstance et) {
        et=wFProcessInstanceFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(WFProcessInstance et) {
        return wFProcessInstanceFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFProcessInstance et) {
        boolean result = true;
        Object rt = wFProcessInstanceFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), WFProcessInstance.class);
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
    public void saveBatch(List<WFProcessInstance> list) {
        wFProcessInstanceFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFProcessInstance> searchDefault(WFProcessInstanceSearchContext context) {
        Page<WFProcessInstance> wFProcessInstances=wFProcessInstanceFeignClient.searchDefault(context);
        return wFProcessInstances;
    }



}



