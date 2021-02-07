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
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;
import cn.ibizlab.core.notify.service.IMsgBodyService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.notify.client.MsgBodyFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[消息] 服务对象接口实现
 */
@Slf4j
@Service
public class MsgBodyServiceImpl implements IMsgBodyService {

    @Autowired
    MsgBodyFeignClient msgBodyFeignClient;


    @Override
    public boolean create(MsgBody et) {
        MsgBody rt = msgBodyFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<MsgBody> list){
        msgBodyFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(MsgBody et) {
        MsgBody rt = msgBodyFeignClient.update(et.getMsgId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<MsgBody> list){
        msgBodyFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String msg_id) {
        boolean result=msgBodyFeignClient.remove(msg_id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        msgBodyFeignClient.removeBatch(idList);
    }

    @Override
    public MsgBody get(String msg_id) {
		MsgBody et=msgBodyFeignClient.get(msg_id);
        if(et==null){
            et=new MsgBody();
            et.setMsgId(msg_id);
        }
        else{
        }
        return  et;
    }

    @Override
    public MsgBody getDraft(MsgBody et) {
        et=msgBodyFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(MsgBody et) {
        return msgBodyFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(MsgBody et) {
        boolean result = true;
        Object rt = msgBodyFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), MsgBody.class);
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
    public void saveBatch(List<MsgBody> list) {
        msgBodyFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 数据集
     */
    @Override
    public Page<MsgBody> searchDefault(MsgBodySearchContext context) {
        Page<MsgBody> msgBodys=msgBodyFeignClient.searchDefault(context);
        return msgBodys;
    }

}



