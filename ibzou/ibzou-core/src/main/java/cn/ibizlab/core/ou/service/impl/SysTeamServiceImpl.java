package cn.ibizlab.core.ou.service.impl;

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
import cn.ibizlab.core.ou.domain.SysTeam;
import cn.ibizlab.core.ou.filter.SysTeamSearchContext;
import cn.ibizlab.core.ou.service.ISysTeamService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.SysTeamMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组] 服务对象接口实现
 */
@Slf4j
@Service("SysTeamServiceImpl")
public class SysTeamServiceImpl extends ServiceImpl<SysTeamMapper, SysTeam> implements ISysTeamService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysTeamMemberService systeammemberService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysTeam et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTeamid()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysTeam> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysTeam et) {
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("teamid",et.getTeamid())))
            return false;
        CachedBeanCopier.copy(get(et.getTeamid()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysTeam> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    @Transactional
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public SysTeam get(String key) {
        SysTeam et = getById(key);
        if(et==null){
            et=new SysTeam();
            et.setTeamid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SysTeam getDraft(SysTeam et) {
        return et;
    }

    @Override
    public boolean checkKey(SysTeam et) {
        return (!ObjectUtils.isEmpty(et.getTeamid()))&&(!Objects.isNull(this.getById(et.getTeamid())));
    }
    @Override
    @Transactional
    public boolean save(SysTeam et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysTeam et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysTeam> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysTeam> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysTeam> searchDefault(SysTeamSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysTeam> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysTeam>(pages.getRecords(), context.getPageable(), pages.getTotal());
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



