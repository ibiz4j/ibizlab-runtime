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
import cn.ibizlab.core.workflow.domain.WFTaskWay;
import cn.ibizlab.core.workflow.filter.WFTaskWaySearchContext;
import cn.ibizlab.core.workflow.service.IWFTaskWayService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


/**
 * 实体[操作路径] 无存储服务对象接口实现
 */
@Slf4j
@Service
public class WFTaskWayServiceImpl implements IWFTaskWayService {


    @Override
    public boolean create(WFTaskWay et) {
        //代码实现
        return true;
    }

    public void createBatch(List<WFTaskWay> list){
    }

    @Override
    public boolean update(WFTaskWay et) {
        //代码实现
        return true;
    }

    public void updateBatch(List<WFTaskWay> list){
    }

    @Override
    public boolean remove(String key) {
        return true;
    }

    public void removeBatch(Collection<String> idList){
    }

    @Override
    public WFTaskWay get(String key) {
        WFTaskWay et = new WFTaskWay();
        et.setSequenceflowid(key);
        return et;
    }

    @Override
    public WFTaskWay getDraft(WFTaskWay et) {
        return et;
    }

    @Override
    public boolean checkKey(WFTaskWay et) {
        return false;
    }
    @Override
    @Transactional
    public boolean save(WFTaskWay et) {
        //代码实现
        return true;
    }

    @Override
    public void saveBatch(List<WFTaskWay> list) {
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFTaskWay> searchDefault(WFTaskWaySearchContext context) {
        return new PageImpl<WFTaskWay>(new ArrayList(),context.getPageable(),0);
    }


}


