package cn.ibizlab.core.uaa.service.impl;

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
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.uaa.client.SysPSSystemFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[系统] 服务对象接口实现
 */
@Slf4j
@Service
public class SysPSSystemServiceImpl implements ISysPSSystemService {

    @Autowired
    SysPSSystemFeignClient sysPSSystemFeignClient;


    @Override
    public boolean create(SysPSSystem et) {
        SysPSSystem rt = sysPSSystemFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SysPSSystem> list){
        sysPSSystemFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysPSSystem et) {
        SysPSSystem rt = sysPSSystemFeignClient.update(et.getPssystemid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SysPSSystem> list){
        sysPSSystemFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String pssystemid) {
        boolean result=sysPSSystemFeignClient.remove(pssystemid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysPSSystemFeignClient.removeBatch(idList);
    }

    @Override
    public SysPSSystem get(String pssystemid) {
		SysPSSystem et=sysPSSystemFeignClient.get(pssystemid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), pssystemid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysPSSystem getDraft(SysPSSystem et) {
        et=sysPSSystemFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SysPSSystem et) {
        return sysPSSystemFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysPSSystem et) {
        boolean result = true;
        Object rt = sysPSSystemFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), SysPSSystem.class);
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
    public void saveBatch(List<SysPSSystem> list) {
        sysPSSystemFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysPSSystem> searchDefault(SysPSSystemSearchContext context) {
        Page<SysPSSystem> sysPSSystems=sysPSSystemFeignClient.searchDefault(context);
        return sysPSSystems;
    }

    /**
     * 查询集合 Pick
     */
    @Override
    public Page<SysPSSystem> searchPick(SysPSSystemSearchContext context) {
        Page<SysPSSystem> sysPSSystems=sysPSSystemFeignClient.searchPick(context);
        return sysPSSystems;
    }

}



