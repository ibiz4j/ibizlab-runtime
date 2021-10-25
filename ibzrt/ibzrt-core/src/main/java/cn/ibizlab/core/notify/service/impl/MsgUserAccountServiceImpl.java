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
import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.core.notify.filter.MsgUserAccountSearchContext;
import cn.ibizlab.core.notify.service.IMsgUserAccountService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.notify.client.MsgUserAccountFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[绑定消息账号] 服务对象接口实现
 */
@Slf4j
@Service
public class MsgUserAccountServiceImpl implements IMsgUserAccountService {

    @Autowired
    MsgUserAccountFeignClient msgUserAccountFeignClient;


    @Override
    public boolean create(MsgUserAccount et) {
        MsgUserAccount rt = msgUserAccountFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<MsgUserAccount> list){
        msgUserAccountFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(MsgUserAccount et) {
        MsgUserAccount rt = msgUserAccountFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<MsgUserAccount> list){
        msgUserAccountFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=msgUserAccountFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        msgUserAccountFeignClient.removeBatch(idList);
    }

    @Override
    public MsgUserAccount get(String id) {
		MsgUserAccount et=msgUserAccountFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public MsgUserAccount getDraft(MsgUserAccount et) {
        et=msgUserAccountFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(MsgUserAccount et) {
        return msgUserAccountFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(MsgUserAccount et) {
        boolean result = true;
        Object rt = msgUserAccountFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), MsgUserAccount.class);
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
    public void saveBatch(List<MsgUserAccount> list) {
        msgUserAccountFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<MsgUserAccount> searchDefault(MsgUserAccountSearchContext context) {
        Page<MsgUserAccount> msgUserAccounts=msgUserAccountFeignClient.searchDefault(context);
        return msgUserAccounts;
    }



}



