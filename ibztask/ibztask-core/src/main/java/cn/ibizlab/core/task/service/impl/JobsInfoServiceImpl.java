package cn.ibizlab.core.task.service.impl;

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
import cn.ibizlab.core.task.domain.JobsInfo;
import cn.ibizlab.core.task.filter.JobsInfoSearchContext;
import cn.ibizlab.core.task.service.IJobsInfoService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.task.mapper.JobsInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任务信息] 服务对象接口实现
 */
@Slf4j
@Service("JobsInfoServiceImpl")
public class JobsInfoServiceImpl extends ServiceImpl<JobsInfoMapper, JobsInfo> implements IJobsInfoService {


    private int batchSize = 500;

    @Override
    @Transactional
    public JobsInfo start(JobsInfo et) {
        et.set("Last_time","0");
        et.set("Status","0");
        update(et);
        return et;
    }
    @Override
    @Transactional
    public boolean update(JobsInfo et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("id",et.getId())))
            return false;
        CachedBeanCopier.copy(get(et.getId()),et);
        return true;
    }

    @Override
    public void updateBatch(List<JobsInfo> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(JobsInfo et) {
        return (!ObjectUtils.isEmpty(et.getId()))&&(!Objects.isNull(this.getById(et.getId())));
    }
    @Override
    @Transactional
    public JobsInfo execute(JobsInfo et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(JobsInfo et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(JobsInfo et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<JobsInfo> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<JobsInfo> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public JobsInfo getDraft(JobsInfo et) {
        return et;
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public JobsInfo get(String key) {
        JobsInfo et = getById(key);
        if(et==null){
            et=new JobsInfo();
            et.setId(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(JobsInfo et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getId()),et);
        return true;
    }

    @Override
    public void createBatch(List<JobsInfo> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public JobsInfo stop(JobsInfo et) {
        et.set("Last_time","0");
        et.set("Status","1");
        et.set("Next_time","0");
        update(et);
        return et;
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<JobsInfo> searchDefault(JobsInfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<JobsInfo> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<JobsInfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }







    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }


}



