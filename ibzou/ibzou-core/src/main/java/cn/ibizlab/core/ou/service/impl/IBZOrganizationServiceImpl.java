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
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;
import cn.ibizlab.core.ou.service.IIBZOrganizationService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.IBZOrganizationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[单位机构] 服务对象接口实现
 */
@Slf4j
@Service("IBZOrganizationServiceImpl")
public class IBZOrganizationServiceImpl extends ServiceImpl<IBZOrganizationMapper, IBZOrganization> implements IIBZOrganizationService {

    @Autowired
    @Lazy
    private cn.ibizlab.core.ou.service.IIBZDepartmentService ibzdepartmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;

    private cn.ibizlab.core.ou.service.IIBZOrganizationService ibzorganizationService = this;

    private int batchSize = 500;

    @Override
    public boolean checkKey(IBZOrganization et) {
        return (!ObjectUtils.isEmpty(et.getOrgid()))&&(!Objects.isNull(this.getById(et.getOrgid())));
    }
    @Override
    @Transactional
    public boolean update(IBZOrganization et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgid",et.getOrgid())))
            return false;
        ibzdepartmentService.saveByOrgid(et.getOrgid(),et.getDepts());
        CachedBeanCopier.copy(get(et.getOrgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<IBZOrganization> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(IBZOrganization et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        ibzdepartmentService.saveByOrgid(et.getOrgid(),et.getDepts());
        CachedBeanCopier.copy(get(et.getOrgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<IBZOrganization> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(IBZOrganization et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(IBZOrganization et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<IBZOrganization> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<IBZOrganization> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        ibzdepartmentService.removeByOrgid(key) ;
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public IBZOrganization get(String key) {
        IBZOrganization et = getById(key);
        if(et==null){
            et=new IBZOrganization();
            et.setOrgid(key);
        }
        else{
            et.setDepts(ibzdepartmentService.selectByOrgid(key));
        }
        return et;
    }

    @Override
    public IBZOrganization getDraft(IBZOrganization et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<IBZOrganization> selectByParentorgid(String orgid) {
        return baseMapper.selectByParentorgid(orgid);
    }

    @Override
    public void removeByParentorgid(String orgid) {
        this.remove(new QueryWrapper<IBZOrganization>().eq("porgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZOrganization> searchDefault(IBZOrganizationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IBZOrganization> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<IBZOrganization>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(IBZOrganization et){
        //实体关系[DER1N_IBZORG_IBZORG_PORGID]
        if(!ObjectUtils.isEmpty(et.getParentorgid())){
            cn.ibizlab.core.ou.domain.IBZOrganization parentorg=et.getParentorg();
            if(ObjectUtils.isEmpty(parentorg)){
                cn.ibizlab.core.ou.domain.IBZOrganization majorEntity=ibzorganizationService.get(et.getParentorgid());
                et.setParentorg(majorEntity);
                parentorg=majorEntity;
            }
            et.setParentorgname(parentorg.getOrgname());
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
    public List<IBZOrganization> getIbzorganizationByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<IBZOrganization> getIbzorganizationByEntities(List<IBZOrganization> entities) {
        List ids =new ArrayList();
        for(IBZOrganization entity : entities){
            Serializable id=entity.getOrgid();
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



