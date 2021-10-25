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
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;
import cn.ibizlab.core.notify.service.IMsgTemplateService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.notify.client.MsgTemplateFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[消息模板] 服务对象接口实现
 */
@Slf4j
@Service
public class MsgTemplateServiceImpl implements IMsgTemplateService {

    @Autowired
    MsgTemplateFeignClient msgTemplateFeignClient;


    @Override
    public boolean create(MsgTemplate et) {
        MsgTemplate rt = msgTemplateFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<MsgTemplate> list){
        msgTemplateFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(MsgTemplate et) {
        MsgTemplate rt = msgTemplateFeignClient.update(et.getTid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<MsgTemplate> list){
        msgTemplateFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String tid) {
        boolean result=msgTemplateFeignClient.remove(tid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        msgTemplateFeignClient.removeBatch(idList);
    }

    @Override
    public MsgTemplate get(String tid) {
		MsgTemplate et=msgTemplateFeignClient.get(tid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), tid);
        }
        else{
        }
        return  et;
    }

    @Override
    public MsgTemplate getDraft(MsgTemplate et) {
        et=msgTemplateFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(MsgTemplate et) {
        return msgTemplateFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(MsgTemplate et) {
        boolean result = true;
        Object rt = msgTemplateFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), MsgTemplate.class);
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
    public void saveBatch(List<MsgTemplate> list) {
        msgTemplateFeignClient.saveBatch(list) ;
    }



	@Override
    public List<MsgTemplate> selectByAccessId(String id) {
        MsgTemplateSearchContext context=new MsgTemplateSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_accessid_eq(id);
        return msgTemplateFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByAccessId(String id) {
        Set<String> delIds=new HashSet<String>();
        for(MsgTemplate before:selectByAccessId(id)){
            delIds.add(before.getTid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<MsgTemplate> searchDefault(MsgTemplateSearchContext context) {
        Page<MsgTemplate> msgTemplates=msgTemplateFeignClient.searchDefault(context);
        return msgTemplates;
    }



}



