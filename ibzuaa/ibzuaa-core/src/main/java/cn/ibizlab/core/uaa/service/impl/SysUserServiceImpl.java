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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.filter.SysUserSearchContext;
import cn.ibizlab.core.uaa.service.ISysUserService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.uaa.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[系统用户] 服务对象接口实现
 */
@Slf4j
@Service("SysUserServiceImpl")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysUserAuthService sysuserauthService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysUserRoleService sysuserroleService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysUser et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SysUser> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysUser et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userid",et.getUserid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SysUser> list) {
        updateBatchById(list,batchSize);
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
    public SysUser get(String key) {
        SysUser et = getById(key);
        if(et==null){
            et=new SysUser();
            et.setUserid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SysUser getDraft(SysUser et) {
        return et;
    }

    @Override
    public boolean checkKey(SysUser et) {
        return (!ObjectUtils.isEmpty(et.getUserid()))&&(!Objects.isNull(this.getById(et.getUserid())));
    }
    @Override
    @Transactional
    public boolean save(SysUser et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysUser et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SysUser> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SysUser> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysUser> searchDefault(SysUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysUser> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
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

    @Override
    public List<SysUser> getSysuserByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SysUser> getSysuserByEntities(List<SysUser> entities) {
        List ids =new ArrayList();
        for(SysUser entity : entities){
            Serializable id=entity.getUserid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



