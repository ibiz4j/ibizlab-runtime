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
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;
import cn.ibizlab.core.workflow.service.IWFProcessNodeService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.workflow.client.WFProcessNodeFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[流程定义节点] 服务对象接口实现
 */
@Slf4j
@Service
public class WFProcessNodeServiceImpl implements IWFProcessNodeService {

    @Autowired
    WFProcessNodeFeignClient wFProcessNodeFeignClient;


    @Override
    public boolean create(WFProcessNode et) {
        WFProcessNode rt = wFProcessNodeFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<WFProcessNode> list){
        wFProcessNodeFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFProcessNode et) {
        WFProcessNode rt = wFProcessNodeFeignClient.update(et.getUsertaskid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<WFProcessNode> list){
        wFProcessNodeFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String usertaskid) {
        boolean result=wFProcessNodeFeignClient.remove(usertaskid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFProcessNodeFeignClient.removeBatch(idList);
    }

    @Override
    public WFProcessNode get(String usertaskid) {
		WFProcessNode et=wFProcessNodeFeignClient.get(usertaskid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), usertaskid);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFProcessNode getDraft(WFProcessNode et) {
        et=wFProcessNodeFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(WFProcessNode et) {
        return wFProcessNodeFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFProcessNode et) {
        boolean result = true;
        Object rt = wFProcessNodeFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), WFProcessNode.class);
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
    public void saveBatch(List<WFProcessNode> list) {
        wFProcessNodeFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFProcessNode> searchDefault(WFProcessNodeSearchContext context) {
        Page<WFProcessNode> wFProcessNodes=wFProcessNodeFeignClient.searchDefault(context);
        return wFProcessNodes;
    }



}



