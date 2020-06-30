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
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;
import cn.ibizlab.core.uaa.service.ISysPermissionService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.uaa.mapper.SysPermissionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[权限/资源] 服务对象接口实现
 */
@Slf4j
@Service("SysPermissionServiceImpl")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysRolePermissionService sysrolepermissionService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean save(SysPermission et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SysPermission et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SysPermission> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SysPermission> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SysPermission getDraft(SysPermission et) {
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
    public boolean update(SysPermission et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("sys_permissionid",et.getPermissionid())))
            return false;
        CachedBeanCopier.copy(get(et.getPermissionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SysPermission> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SysPermission et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPermissionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SysPermission> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SysPermission et) {
        return (!ObjectUtils.isEmpty(et.getPermissionid()))&&(!Objects.isNull(this.getById(et.getPermissionid())));
    }
    @Override
    @Transactional
    public SysPermission get(String key) {
        SysPermission et = getById(key);
        if(et==null){
            et=new SysPermission();
            et.setPermissionid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysPermission> searchDefault(SysPermissionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysPermission> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysPermission>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


