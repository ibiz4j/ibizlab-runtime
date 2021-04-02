package cn.ibizlab.core.notify.service.impl;

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
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.filter.MsgOpenAccessSearchContext;
import cn.ibizlab.core.notify.service.IMsgOpenAccessService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.notify.client.MsgOpenAccessFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[接入开放平台] 服务对象接口实现
 */
@Slf4j
@Service
public class MsgOpenAccessServiceImpl implements IMsgOpenAccessService {

    @Autowired
    MsgOpenAccessFeignClient msgOpenAccessFeignClient;


    @Override
    public boolean create(MsgOpenAccess et) {
        MsgOpenAccess rt = msgOpenAccessFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<MsgOpenAccess> list){
        msgOpenAccessFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(MsgOpenAccess et) {
        MsgOpenAccess rt = msgOpenAccessFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<MsgOpenAccess> list){
        msgOpenAccessFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=msgOpenAccessFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        msgOpenAccessFeignClient.removeBatch(idList);
    }

    @Override
    public MsgOpenAccess get(String id) {
		MsgOpenAccess et=msgOpenAccessFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public MsgOpenAccess getDraft(MsgOpenAccess et) {
        et=msgOpenAccessFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(MsgOpenAccess et) {
        return msgOpenAccessFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(MsgOpenAccess et) {
        boolean result = true;
        Object rt = msgOpenAccessFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), MsgOpenAccess.class);
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
    public void saveBatch(List<MsgOpenAccess> list) {
        msgOpenAccessFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<MsgOpenAccess> searchDefault(MsgOpenAccessSearchContext context) {
        Page<MsgOpenAccess> msgOpenAccesss=msgOpenAccessFeignClient.searchDefault(context);
        return msgOpenAccesss;
    }

}



