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
import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import cn.ibizlab.core.ou.service.ISysDepartmentService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.SysDepartmentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门] 服务对象接口实现
 */
@Slf4j
@Service("SysDepartmentServiceImpl")
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements ISysDepartmentService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysDeptMemberService sysdeptmemberService;

    protected cn.ibizlab.core.ou.service.ISysDepartmentService sysdepartmentService = this;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysEmployeeService sysemployeeService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysOrganizationService sysorganizationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysDepartment et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getDeptid()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysDepartment> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysDepartment et) {
        fillParentData(et);
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("deptid",et.getDeptid())))
            return false;
        CachedBeanCopier.copy(get(et.getDeptid()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysDepartment> list) {
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
    public SysDepartment get(String key) {
        SysDepartment et = getById(key);
        if(et==null){
            et=new SysDepartment();
            et.setDeptid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SysDepartment getDraft(SysDepartment et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysDepartment et) {
        return (!ObjectUtils.isEmpty(et.getDeptid()))&&(!Objects.isNull(this.getById(et.getDeptid())));
    }
    @Override
    @Transactional
    public boolean save(SysDepartment et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysDepartment et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysDepartment> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysDepartment> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SysDepartment> selectByParentdeptid(String deptid) {
        return baseMapper.selectByParentdeptid(deptid);
    }

    @Override
    public void removeByParentdeptid(String deptid) {
        this.remove(new QueryWrapper<SysDepartment>().eq("pdeptid",deptid));
    }

	@Override
    public List<SysDepartment> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<SysDepartment>().eq("orgid",orgid));
    }

    @Autowired
    @Lazy
    ISysDepartmentService proxyService;
	@Override
    public void saveByOrgid(String orgid,List<SysDepartment> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<SysDepartment> _update=new ArrayList<SysDepartment>();
        List<SysDepartment> _create=new ArrayList<SysDepartment>();
        for(SysDepartment before:selectByOrgid(orgid)){
            delIds.add(before.getDeptid());
        }
        for(SysDepartment sub:list) {
            sub.setOrgid(orgid);
            if(ObjectUtils.isEmpty(sub.getDeptid()))
                sub.setDeptid((String)sub.getDefaultKey(true));
            if(delIds.contains(sub.getDeptid())) {
                delIds.remove(sub.getDeptid());
                _update.add(sub);
            }
            else
                _create.add(sub);
        }
        if(_update.size()>0)
            proxyService.updateBatch(_update);
        if(_create.size()>0)
            proxyService.createBatch(_create);
        if(delIds.size()>0)
            proxyService.removeBatch(delIds);
	}


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysDepartment> searchDefault(SysDepartmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysDepartment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysDepartment>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysDepartment et){
        //实体关系[DER1N_SYS_DEPT_SYS_DEPT_PDEPTID]
        if(!ObjectUtils.isEmpty(et.getParentdeptid())){
            cn.ibizlab.core.ou.domain.SysDepartment parentdept=et.getParentdept();
            if(ObjectUtils.isEmpty(parentdept)){
                cn.ibizlab.core.ou.domain.SysDepartment majorEntity=sysdepartmentService.get(et.getParentdeptid());
                et.setParentdept(majorEntity);
                parentdept=majorEntity;
            }
            et.setParentdeptname(parentdept.getDeptname());
        }
        //实体关系[DER1N_SYS_DEPT_SYS_ORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.core.ou.domain.SysOrganization org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.core.ou.domain.SysOrganization majorEntity=sysorganizationService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgname(org.getOrgname());
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

    @Override
    public List<SysDepartment> getSysdepartmentByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SysDepartment> getSysdepartmentByEntities(List<SysDepartment> entities) {
        List ids =new ArrayList();
        for(SysDepartment entity : entities){
            Serializable id=entity.getDeptid();
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



