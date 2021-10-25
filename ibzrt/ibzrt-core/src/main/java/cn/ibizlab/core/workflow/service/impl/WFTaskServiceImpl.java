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
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.core.workflow.service.IWFTaskService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.workflow.client.WFTaskFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[工作流任务] 服务对象接口实现
 */
@Slf4j
@Service
public class WFTaskServiceImpl implements IWFTaskService {

    @Autowired
    WFTaskFeignClient wFTaskFeignClient;


    @Override
    public boolean create(WFTask et) {
        WFTask rt = wFTaskFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<WFTask> list){
        wFTaskFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFTask et) {
        WFTask rt = wFTaskFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<WFTask> list){
        wFTaskFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=wFTaskFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFTaskFeignClient.removeBatch(idList);
    }

    @Override
    public WFTask get(String id) {
		WFTask et=wFTaskFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFTask getDraft(WFTask et) {
        et=wFTaskFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(WFTask et) {
        return wFTaskFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFTask et) {
        boolean result = true;
        Object rt = wFTaskFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), WFTask.class);
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
    public void saveBatch(List<WFTask> list) {
        wFTaskFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFTask> searchDefault(WFTaskSearchContext context) {
        Page<WFTask> wFTasks=wFTaskFeignClient.searchDefault(context);
        return wFTasks;
    }



}



