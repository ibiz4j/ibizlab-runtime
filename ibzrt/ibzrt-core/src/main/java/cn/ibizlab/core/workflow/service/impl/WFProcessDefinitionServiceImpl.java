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
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.filter.WFProcessDefinitionSearchContext;
import cn.ibizlab.core.workflow.service.IWFProcessDefinitionService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.workflow.client.WFProcessDefinitionFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[流程定义] 服务对象接口实现
 */
@Slf4j
@Service
public class WFProcessDefinitionServiceImpl implements IWFProcessDefinitionService {

    @Autowired
    WFProcessDefinitionFeignClient wFProcessDefinitionFeignClient;


    @Override
    public boolean create(WFProcessDefinition et) {
        WFProcessDefinition rt = wFProcessDefinitionFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<WFProcessDefinition> list){
        wFProcessDefinitionFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFProcessDefinition et) {
        WFProcessDefinition rt = wFProcessDefinitionFeignClient.update(et.getDefinitionkey(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<WFProcessDefinition> list){
        wFProcessDefinitionFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String definitionkey) {
        boolean result=wFProcessDefinitionFeignClient.remove(definitionkey) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFProcessDefinitionFeignClient.removeBatch(idList);
    }

    @Override
    public WFProcessDefinition get(String definitionkey) {
		WFProcessDefinition et=wFProcessDefinitionFeignClient.get(definitionkey);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), definitionkey);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFProcessDefinition getDraft(WFProcessDefinition et) {
        et=wFProcessDefinitionFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(WFProcessDefinition et) {
        return wFProcessDefinitionFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFProcessDefinition et) {
        boolean result = true;
        Object rt = wFProcessDefinitionFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), WFProcessDefinition.class);
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
    public void saveBatch(List<WFProcessDefinition> list) {
        wFProcessDefinitionFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFProcessDefinition> searchDefault(WFProcessDefinitionSearchContext context) {
        Page<WFProcessDefinition> wFProcessDefinitions=wFProcessDefinitionFeignClient.searchDefault(context);
        return wFProcessDefinitions;
    }



}



