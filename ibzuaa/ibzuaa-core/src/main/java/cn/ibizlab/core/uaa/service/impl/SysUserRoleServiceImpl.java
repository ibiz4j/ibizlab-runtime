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
import cn.ibizlab.core.uaa.domain.SysUserRole;
import cn.ibizlab.core.uaa.filter.SysUserRoleSearchContext;
import cn.ibizlab.core.uaa.service.ISysUserRoleService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.uaa.mapper.SysUserRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色关系] 服务对象接口实现
 */
@Slf4j
@Service("SysUserRoleServiceImpl")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysRoleService sysroleService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.uaa.service.ISysUserService sysuserService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysUserRole et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getUserroleid()), et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysUserRole> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysUserRole et) {
        fillParentData(et);
        if(!update(et, (Wrapper) et.getUpdateWrapper(true).eq("sys_user_roleid", et.getUserroleid()))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getUserroleid()), et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysUserRole> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list, batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result = removeById(key);
        return result ;
    }

    @Override
    @Transactional
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public SysUserRole get(String key) {
        SysUserRole et = getById(key);
        if (et == null) {
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), key);
        }
        else {
        }
        return et;
    }

    @Override
    public SysUserRole getDraft(SysUserRole et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysUserRole et) {
        return (!ObjectUtils.isEmpty(et.getUserroleid())) && (!Objects.isNull(this.getById(et.getUserroleid())));
    }
    @Override
    @Transactional
    public boolean save(SysUserRole et) {
        if(!saveOrUpdate(et)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysUserRole et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? getProxyService().update(et) : getProxyService().create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysUserRole> list) {
        list.forEach(item->fillParentData(item));
        List<SysUserRole> create = new ArrayList<>();
        List<SysUserRole> update = new ArrayList<>();
        for (SysUserRole et : list) {
            if (ObjectUtils.isEmpty(et.getUserroleid()) || ObjectUtils.isEmpty(getById(et.getUserroleid()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            getProxyService().createBatch(create);
        }
        if (update.size() > 0) {
            getProxyService().updateBatch(update);
        }
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysUserRole> list) {
        list.forEach(item->fillParentData(item));
        List<SysUserRole> create = new ArrayList<>();
        List<SysUserRole> update = new ArrayList<>();
        for (SysUserRole et : list) {
            if (ObjectUtils.isEmpty(et.getUserroleid()) || ObjectUtils.isEmpty(getById(et.getUserroleid()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            getProxyService().createBatch(create);
        }
        if (update.size() > 0) {
            getProxyService().updateBatch(update);
        }
    }


	@Override
    public List<SysUserRole> selectByRoleid(String roleid) {
        return baseMapper.selectByRoleid(roleid);
    }
    @Override
    public void removeByRoleid(Collection<String> ids) {
        this.remove(new QueryWrapper<SysUserRole>().in("sys_roleid",ids));
    }

    @Override
    public void removeByRoleid(String roleid) {
        this.remove(new QueryWrapper<SysUserRole>().eq("sys_roleid",roleid));
    }

	@Override
    public List<SysUserRole> selectByUserid(String userid) {
        return baseMapper.selectByUserid(userid);
    }
    @Override
    public void removeByUserid(String userid) {
        this.remove(new QueryWrapper<SysUserRole>().eq("sys_userid",userid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysUserRole> searchDefault(SysUserRoleSearchContext context) {
            com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysUserRole> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
            return new PageImpl<SysUserRole>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysUserRole et){
        //实体关系[DER1N_SYS_USER_ROLE_SYS_ROLE_SYS_ROLEID]
        if(!ObjectUtils.isEmpty(et.getRoleid())){
            cn.ibizlab.core.uaa.domain.SysRole role=et.getRole();
            if(ObjectUtils.isEmpty(role)){
                cn.ibizlab.core.uaa.domain.SysRole majorEntity=sysroleService.get(et.getRoleid());
                et.setRole(majorEntity);
                role=majorEntity;
            }
            et.setRolename(role.getRolename());
        }
        //实体关系[DER1N_SYS_USER_ROLE_SYS_USER_SYS_USERID]
        if(!ObjectUtils.isEmpty(et.getUserid())){
            cn.ibizlab.core.uaa.domain.SysUser user=et.getUser();
            if(ObjectUtils.isEmpty(user)){
                cn.ibizlab.core.uaa.domain.SysUser majorEntity=sysuserService.get(et.getUserid());
                et.setUser(majorEntity);
                user=majorEntity;
            }
            et.setPersonname(user.getPersonname());
            et.setLoginname(user.getLoginname());
            et.setOrgname(user.getOrgname());
            et.setMdeptname(user.getMdeptname());
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





    public ISysUserRoleService getProxyService() {
        return cn.ibizlab.util.security.SpringContextHolder.getBean(this.getClass());
    }
}



