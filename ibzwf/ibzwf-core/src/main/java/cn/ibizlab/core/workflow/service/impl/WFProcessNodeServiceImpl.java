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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;
import cn.ibizlab.core.workflow.service.IWFProcessNodeService;

import cn.ibizlab.util.helper.CachedBeanCopier;


/**
 * 实体[流程定义节点] 无存储服务对象接口实现
 */
@Slf4j
@Service
public class WFProcessNodeServiceImpl implements IWFProcessNodeService {


    @Override
    public boolean remove(String key) {
        return true;
    }

    public void removeBatch(Collection<String> idList){
                        
    }

    @Override
    public boolean checkKey(WFProcessNode et) {
        return false;
    }
    @Override
    @Transactional
    public boolean save(WFProcessNode et) {
        //代码实现
        return true;
    }

    @Override
    public void saveBatch(List<WFProcessNode> list) {
                       
    }

    @Override
    public WFProcessNode get(String key) {
        WFProcessNode et = new WFProcessNode();
        et.setUsertaskid(key);
        return et;
    }

    @Override
    public boolean create(WFProcessNode et) {
        //代码实现
        return true;
    }

    public void createBatch(List<WFProcessNode> list){

    }

    @Override
    public boolean update(WFProcessNode et) {
        //代码实现
        return true;
    }

    public void updateBatch(List<WFProcessNode> list){
                    
    }

    @Override
    public WFProcessNode getDraft(WFProcessNode et) {
        return et;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFProcessNode> searchDefault(WFProcessNodeSearchContext context) {
        return new PageImpl<WFProcessNode>(new ArrayList(),context.getPageable(),0);
    }


}


