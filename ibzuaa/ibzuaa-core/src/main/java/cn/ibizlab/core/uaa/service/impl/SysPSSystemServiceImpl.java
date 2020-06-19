package cn.ibizlab.core.uaa.service.impl;

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
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.uaa.mapper.SysPSSystemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[系统] 服务对象接口实现
 */
@Slf4j
@Service("SysPSSystemServiceImpl")
public class SysPSSystemServiceImpl extends ServiceImpl<SysPSSystemMapper, SysPSSystem> implements ISysPSSystemService {


    private int batchSize = 500;

    @Override
    public boolean checkKey(SysPSSystem et) {
        return (!ObjectUtils.isEmpty(et.getPssystemid()))&&(!Objects.isNull(this.getById(et.getPssystemid())));
    }
    @Override
    @Transactional
    public SysPSSystem get(String key) {
        SysPSSystem et = getById(key);
        if(et==null){
            et=new SysPSSystem();
            et.setPssystemid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(SysPSSystem et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPssystemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SysPSSystem> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public SysPSSystem getDraft(SysPSSystem et) {
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
    public boolean save(SysPSSystem et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SysPSSystem et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SysPSSystem> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SysPSSystem> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysPSSystem et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pssystemid",et.getPssystemid())))
            return false;
        CachedBeanCopier.copy(get(et.getPssystemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SysPSSystem> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 Pick
     */
    @Override
    public Page<SysPSSystem> searchPick(SysPSSystemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysPSSystem> pages=baseMapper.searchPick(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysPSSystem>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysPSSystem> searchDefault(SysPSSystemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysPSSystem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysPSSystem>(pages.getRecords(), context.getPageable(), pages.getTotal());
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



