package cn.ibizlab.core.pay.service.impl;

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
import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.core.pay.filter.PayOpenAccessSearchContext;
import cn.ibizlab.core.pay.service.IPayOpenAccessService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.pay.client.PayOpenAccessFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[支付平台] 服务对象接口实现
 */
@Slf4j
@Service
public class PayOpenAccessServiceImpl implements IPayOpenAccessService {

    @Autowired
    PayOpenAccessFeignClient payOpenAccessFeignClient;


    @Override
    public boolean create(PayOpenAccess et) {
        PayOpenAccess rt = payOpenAccessFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<PayOpenAccess> list){
        payOpenAccessFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(PayOpenAccess et) {
        PayOpenAccess rt = payOpenAccessFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<PayOpenAccess> list){
        payOpenAccessFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=payOpenAccessFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        payOpenAccessFeignClient.removeBatch(idList);
    }

    @Override
    public PayOpenAccess get(String id) {
		PayOpenAccess et=payOpenAccessFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public PayOpenAccess getDraft(PayOpenAccess et) {
        et=payOpenAccessFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(PayOpenAccess et) {
        return payOpenAccessFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(PayOpenAccess et) {
        boolean result = true;
        Object rt = payOpenAccessFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), PayOpenAccess.class);
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
    public void saveBatch(List<PayOpenAccess> list) {
        payOpenAccessFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 数据集
     */
    @Override
    public Page<PayOpenAccess> searchDefault(PayOpenAccessSearchContext context) {
        Page<PayOpenAccess> payOpenAccesss=payOpenAccessFeignClient.searchDefault(context);
        return payOpenAccesss;
    }

}



