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

import cn.ibizlab.core.workflow.domain.WFSystem;
import cn.ibizlab.core.workflow.mapper.WFCoreMapper;
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
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.core.workflow.service.IWFTaskService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


/**
 * 实体[工作流任务] 无存储服务对象接口实现
 */
@Slf4j
@Service
public class WFTaskServiceImpl implements IWFTaskService {


    @Override
    public boolean create(WFTask et) {
        //代码实现
        return true;
    }

    public void createBatch(List<WFTask> list){
    }

    @Override
    public boolean update(WFTask et) {
        //代码实现
        return true;
    }

    public void updateBatch(List<WFTask> list){
    }

    @Override
    public boolean remove(String key) {
        return true;
    }

    public void removeBatch(Collection<String> idList){
    }

    @Override
    public WFTask get(String key) {
        WFTask et = new WFTask();
        et.setId(key);
        return et;
    }

    @Override
    public WFTask getDraft(WFTask et) {
        return et;
    }

    @Override
    public boolean checkKey(WFTask et) {
        return false;
    }
    @Override
    @Transactional
    public boolean save(WFTask et) {
        //代码实现
        return true;
    }

    @Override
    public void saveBatch(List<WFTask> list) {
    }




    @Autowired
    private WFCoreMapper wfCoreMapper;

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFTask> searchDefault(WFTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages=wfCoreMapper.searchMyTask(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


}


