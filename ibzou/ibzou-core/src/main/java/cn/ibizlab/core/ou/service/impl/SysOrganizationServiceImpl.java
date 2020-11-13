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
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;
import cn.ibizlab.core.ou.service.ISysOrganizationService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.SysOrganizationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[单位机构] 服务对象接口实现
 */
@Slf4j
@Service("SysOrganizationServiceImpl")
public class SysOrganizationServiceImpl extends ServiceImpl<SysOrganizationMapper, SysOrganization> implements ISysOrganizationService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysDepartmentService sysdepartmentService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysEmployeeService sysemployeeService;

    protected cn.ibizlab.core.ou.service.ISysOrganizationService sysorganizationService = this;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysOrganization et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et))) {
            return false;
        }
        sysdepartmentService.saveByOrgid(et.getOrgid(), et.getDepts());
        CachedBeanCopier.copy(get(et.getOrgid()), et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysOrganization> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list, batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysOrganization et) {
        fillParentData(et);
        if(!update(et, (Wrapper) et.getUpdateWrapper(true).eq("orgid", et.getOrgid()))) {
            return false;
        }
        sysdepartmentService.saveByOrgid(et.getOrgid(), et.getDepts());
        CachedBeanCopier.copy(get(et.getOrgid()), et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysOrganization> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list, batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        sysdepartmentService.removeByOrgid(key) ;
        if(!ObjectUtils.isEmpty(sysdepartmentService.selectByOrgid(key)))
            throw new BadRequestAlertException("删除数据失败，当前数据存在关系实体[SysDepartment]数据，无法删除!","","");
        sysemployeeService.resetByOrgid(key);
        if(!ObjectUtils.isEmpty(sysorganizationService.selectByParentorgid(key)))
            throw new BadRequestAlertException("删除数据失败，当前数据存在关系实体[SysOrganization]数据，无法删除!","","");
        boolean result = removeById(key);
        return result ;
    }

    @Override
    @Transactional
    public void removeBatch(Collection<String> idList) {
        if(!ObjectUtils.isEmpty(sysdepartmentService.selectByOrgid(idList)))
            throw new BadRequestAlertException("删除数据失败，当前数据存在关系实体[SysDepartment]数据，无法删除!","","");
        sysemployeeService.resetByOrgid(idList);
        if(!ObjectUtils.isEmpty(sysorganizationService.selectByParentorgid(idList)))
            throw new BadRequestAlertException("删除数据失败，当前数据存在关系实体[SysOrganization]数据，无法删除!","","");
        removeByIds(idList);
    }

    @Override
    @Transactional
    public SysOrganization get(String key) {
        SysOrganization et = getById(key);
        if(et == null){
            et = new SysOrganization();
            et.setOrgid(key);
        }
        else {
            et.setDepts(sysdepartmentService.selectByOrgid(key));
        }
        return et;
    }

    @Override
    public SysOrganization getDraft(SysOrganization et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysOrganization et) {
        return (!ObjectUtils.isEmpty(et.getOrgid())) && (!Objects.isNull(this.getById(et.getOrgid())));
    }
    @Override
    @Transactional
    public boolean save(SysOrganization et) {
        if(!saveOrUpdate(et)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysOrganization et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysOrganization> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysOrganization> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SysOrganization> selectByParentorgid(String orgid) {
        return baseMapper.selectByParentorgid(orgid);
    }
    @Override
    public List<SysOrganization> selectByParentorgid(Collection<String> ids) {
        return this.list(new QueryWrapper<SysOrganization>().in("orgid",ids));
    }

    @Override
    public void removeByParentorgid(String orgid) {
        this.remove(new QueryWrapper<SysOrganization>().eq("porgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysOrganization> searchDefault(SysOrganizationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysOrganization> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysOrganization>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysOrganization et){
        //实体关系[DER1N_SYS_ORG_SYS_ORG_PORGID]
        if(!ObjectUtils.isEmpty(et.getParentorgid())){
            cn.ibizlab.core.ou.domain.SysOrganization parentorg=et.getParentorg();
            if(ObjectUtils.isEmpty(parentorg)){
                cn.ibizlab.core.ou.domain.SysOrganization majorEntity=sysorganizationService.get(et.getParentorgid());
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
    public List<SysOrganization> getSysorganizationByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SysOrganization> getSysorganizationByEntities(List<SysOrganization> entities) {
        List ids =new ArrayList();
        for(SysOrganization entity : entities){
            Serializable id=entity.getOrgid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0) {
            return this.listByIds(ids);
        }
        else {
            return entities;
        }
    }




}



