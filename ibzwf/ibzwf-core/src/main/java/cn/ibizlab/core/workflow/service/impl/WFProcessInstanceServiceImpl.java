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
import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import cn.ibizlab.core.workflow.service.IWFProcessInstanceService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


/**
 * 实体[流程实例] 无存储服务对象接口实现
 */
@Slf4j
@Service
public class WFProcessInstanceServiceImpl implements IWFProcessInstanceService {


    @Override
    public boolean create(WFProcessInstance et) {
        //代码实现
        return true;
    }

    public void createBatch(List<WFProcessInstance> list){
    }

    @Override
    public boolean update(WFProcessInstance et) {
        //代码实现
        return true;
    }

    public void updateBatch(List<WFProcessInstance> list){
    }

    @Override
    public boolean remove(String key) {
        return true;
    }

    public void removeBatch(Collection<String> idList){
    }

    @Override
    public WFProcessInstance get(String key) {
        WFProcessInstance et = new WFProcessInstance();
        et.setId(key);
        return et;
    }

    @Override
    public WFProcessInstance getDraft(WFProcessInstance et) {
        return et;
    }

    @Override
    public boolean checkKey(WFProcessInstance et) {
        return false;
    }
    @Override
    @Transactional
    public WFProcessInstance jump(WFProcessInstance et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean jumpBatch(List<WFProcessInstance> etList) {
        for(WFProcessInstance et : etList) {
            jump(et);
        }
        return true;
    }

    @Override
    @Transactional
    public WFProcessInstance restart(WFProcessInstance et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean restartBatch(List<WFProcessInstance> etList) {
        for(WFProcessInstance et : etList) {
            restart(et);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(WFProcessInstance et) {
        //代码实现
        return true;
    }

    @Override
    public void saveBatch(List<WFProcessInstance> list) {
    }





    /**
     * 查询集合 流程中实例
     */
    @Override
    public Page<WFProcessInstance> searchActiveProcessInstance(WFProcessInstanceSearchContext context) {
        return new PageImpl<WFProcessInstance>(new ArrayList(),context.getPageable(),0);
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFProcessInstance> searchDefault(WFProcessInstanceSearchContext context) {
        return new PageImpl<WFProcessInstance>(new ArrayList(),context.getPageable(),0);
    }



}


