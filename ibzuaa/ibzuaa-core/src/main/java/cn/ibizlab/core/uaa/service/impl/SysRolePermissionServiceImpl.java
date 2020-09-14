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
import cn.ibizlab.util.errors.BadRequestAlertException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.uaa.mapper.SysRolePermissionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[角色权限关系] 服务对象接口实现
 */
@Slf4j
@Service("SysRolePermissionServiceImpl")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysPermissionService syspermissionService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysRoleService sysroleService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysRolePermission et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getRolepermissionid()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysRolePermission> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysRolePermission et) {
        fillParentData(et);
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("sys_role_permissionid",et.getRolepermissionid())))
            return false;
        CachedBeanCopier.copy(get(et.getRolepermissionid()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysRolePermission> list) {
        list.forEach(item->fillParentData(item));
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
    public SysRolePermission get(String key) {
        SysRolePermission et = getById(key);
        if(et==null){
            et=new SysRolePermission();
            et.setRolepermissionid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SysRolePermission getDraft(SysRolePermission et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysRolePermission et) {
        return (!ObjectUtils.isEmpty(et.getRolepermissionid()))&&(!Objects.isNull(this.getById(et.getRolepermissionid())));
    }
    @Override
    @Transactional
    public boolean save(SysRolePermission et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysRolePermission et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysRolePermission> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysRolePermission> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SysRolePermission> selectByPermissionid(String permissionid) {
        return baseMapper.selectByPermissionid(permissionid);
    }

    @Override
    public void removeByPermissionid(String permissionid) {
        this.remove(new QueryWrapper<SysRolePermission>().eq("sys_permissionid",permissionid));
    }

	@Override
    public List<SysRolePermission> selectByRoleid(String roleid) {
        return baseMapper.selectByRoleid(roleid);
    }

    @Override
    public void removeByRoleid(String roleid) {
        this.remove(new QueryWrapper<SysRolePermission>().eq("sys_roleid",roleid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysRolePermission> searchDefault(SysRolePermissionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysRolePermission> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysRolePermission>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysRolePermission et){
        //实体关系[DER1N_SYS_ROLE_PERMISSION_SYS_PERMISSION_SYS_PERMISSIONID]
        if(!ObjectUtils.isEmpty(et.getPermissionid())){
            cn.ibizlab.core.uaa.domain.SysPermission permission=et.getPermission();
            if(ObjectUtils.isEmpty(permission)){
                cn.ibizlab.core.uaa.domain.SysPermission majorEntity=syspermissionService.get(et.getPermissionid());
                et.setPermission(majorEntity);
                permission=majorEntity;
            }
            et.setPermissionname(permission.getPermissionname());
            et.setPermissiontype(permission.getPermissiontype());
            et.setPermissionenable(permission.getEnable());
        }
        //实体关系[DER1N_SYS_ROLE_PERMISSION_SYS_ROLE_SYS_ROLEID]
        if(!ObjectUtils.isEmpty(et.getRoleid())){
            cn.ibizlab.core.uaa.domain.SysRole role=et.getRole();
            if(ObjectUtils.isEmpty(role)){
                cn.ibizlab.core.uaa.domain.SysRole majorEntity=sysroleService.get(et.getRoleid());
                et.setRole(majorEntity);
                role=majorEntity;
            }
            et.setRolename(role.getRolename());
        }
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



