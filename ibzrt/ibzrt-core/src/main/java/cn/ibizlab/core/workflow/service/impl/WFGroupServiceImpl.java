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
import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.filter.WFGroupSearchContext;
import cn.ibizlab.core.workflow.service.IWFGroupService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.workflow.client.WFGroupFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[角色/用户组] 服务对象接口实现
 */
@Slf4j
@Service
public class WFGroupServiceImpl implements IWFGroupService {

    @Autowired
    WFGroupFeignClient wFGroupFeignClient;


    @Override
    public boolean create(WFGroup et) {
        WFGroup rt = wFGroupFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<WFGroup> list){
        wFGroupFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(WFGroup et) {
        WFGroup rt = wFGroupFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<WFGroup> list){
        wFGroupFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=wFGroupFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        wFGroupFeignClient.removeBatch(idList);
    }

    @Override
    public WFGroup get(String id) {
		WFGroup et=wFGroupFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public WFGroup getDraft(WFGroup et) {
        et=wFGroupFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(WFGroup et) {
        return wFGroupFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(WFGroup et) {
        boolean result = true;
        Object rt = wFGroupFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), WFGroup.class);
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
    public void saveBatch(List<WFGroup> list) {
        wFGroupFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFGroup> searchDefault(WFGroupSearchContext context) {
        Page<WFGroup> wFGroups=wFGroupFeignClient.searchDefault(context);
        return wFGroups;
    }



}



