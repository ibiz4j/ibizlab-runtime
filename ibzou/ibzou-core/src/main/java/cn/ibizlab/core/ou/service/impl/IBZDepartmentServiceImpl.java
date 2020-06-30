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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.filter.IBZDepartmentSearchContext;
import cn.ibizlab.core.ou.service.IIBZDepartmentService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.IBZDepartmentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门] 服务对象接口实现
 */
@Slf4j
@Service("IBZDepartmentServiceImpl")
public class IBZDepartmentServiceImpl extends ServiceImpl<IBZDepartmentMapper, IBZDepartment> implements IIBZDepartmentService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZDeptMemberService ibzdeptmemberService;

    protected cn.ibizlab.core.ou.service.IIBZDepartmentService ibzdepartmentService = this;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZOrganizationService ibzorganizationService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(IBZDepartment et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getDeptid()),et);
        return true;
    }

    @Override
    public void createBatch(List<IBZDepartment> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(IBZDepartment et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("deptid",et.getDeptid())))
            return false;
        CachedBeanCopier.copy(get(et.getDeptid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<IBZDepartment> list) {
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
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public IBZDepartment get(String key) {
        IBZDepartment et = getById(key);
        if(et==null){
            et=new IBZDepartment();
            et.setDeptid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public IBZDepartment getDraft(IBZDepartment et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(IBZDepartment et) {
        return (!ObjectUtils.isEmpty(et.getDeptid()))&&(!Objects.isNull(this.getById(et.getDeptid())));
    }
    @Override
    @Transactional
    public boolean save(IBZDepartment et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(IBZDepartment et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<IBZDepartment> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<IBZDepartment> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<IBZDepartment> selectByParentdeptid(String deptid) {
        return baseMapper.selectByParentdeptid(deptid);
    }

    @Override
    public void removeByParentdeptid(String deptid) {
        this.remove(new QueryWrapper<IBZDepartment>().eq("pdeptid",deptid));
    }

	@Override
    public List<IBZDepartment> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<IBZDepartment>().eq("orgid",orgid));
    }

	@Override
    public void saveByOrgid(String orgid,List<IBZDepartment> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<IBZDepartment> _update=new ArrayList<IBZDepartment>();
        List<IBZDepartment> _create=new ArrayList<IBZDepartment>();
        for(IBZDepartment before:selectByOrgid(orgid)){
            delIds.add(before.getDeptid());
        }
        for(IBZDepartment sub:list) {
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
            this.updateBatch(_update);
        if(_create.size()>0)
            this.createBatch(_create);
        if(delIds.size()>0)
            this.removeBatch(delIds);
	}


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZDepartment> searchDefault(IBZDepartmentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IBZDepartment> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<IBZDepartment>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(IBZDepartment et){
        //实体关系[DER1N_IBZDEPT_IBZDEPT_PDEPTID]
        if(!ObjectUtils.isEmpty(et.getParentdeptid())){
            cn.ibizlab.core.ou.domain.IBZDepartment parentdept=et.getParentdept();
            if(ObjectUtils.isEmpty(parentdept)){
                cn.ibizlab.core.ou.domain.IBZDepartment majorEntity=ibzdepartmentService.get(et.getParentdeptid());
                et.setParentdept(majorEntity);
                parentdept=majorEntity;
            }
            et.setParentdeptname(parentdept.getDeptname());
        }
        //实体关系[DER1N_IBZDEPT_IBZORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.core.ou.domain.IBZOrganization org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.core.ou.domain.IBZOrganization majorEntity=ibzorganizationService.get(et.getOrgid());
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
    public List<IBZDepartment> getIbzdepartmentByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<IBZDepartment> getIbzdepartmentByEntities(List<IBZDepartment> entities) {
        List ids =new ArrayList();
        for(IBZDepartment entity : entities){
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


