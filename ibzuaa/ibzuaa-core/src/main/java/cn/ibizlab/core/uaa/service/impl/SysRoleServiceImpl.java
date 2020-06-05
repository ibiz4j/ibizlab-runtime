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
import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;
import cn.ibizlab.core.uaa.service.ISysRoleService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.uaa.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[系统角色] 服务对象接口实现
 */
@Slf4j
@Service("SysRoleServiceImpl")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    @Lazy
    private cn.ibizlab.core.uaa.service.ISysRolePermissionService sysrolepermissionService;
    @Autowired
    @Lazy
    private cn.ibizlab.core.uaa.service.ISysUserRoleService sysuserroleService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(SysRole et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SysRole et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SysRole> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SysRole> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysRole et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("sys_roleid",et.getRoleid())))
            return false;
        CachedBeanCopier.copy(get(et.getRoleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SysRole> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SysRole et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getRoleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SysRole> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public SysRole get(String key) {
        SysRole et = getById(key);
        if(et==null){
            et=new SysRole();
            et.setRoleid(key);
        }
        else{
        }
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
    public SysRole getDraft(SysRole et) {
        return et;
    }

    @Override
    public boolean checkKey(SysRole et) {
        return (!ObjectUtils.isEmpty(et.getRoleid()))&&(!Objects.isNull(this.getById(et.getRoleid())));
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysRole> searchDefault(SysRoleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysRole> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysRole>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


