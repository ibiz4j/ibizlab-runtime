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
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.filter.SysEmployeeSearchContext;
import cn.ibizlab.core.ou.service.ISysEmployeeService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.SysEmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员] 服务对象接口实现
 */
@Slf4j
@Service("SysEmployeeServiceImpl")
public class SysEmployeeServiceImpl extends ServiceImpl<SysEmployeeMapper, SysEmployee> implements ISysEmployeeService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysDeptMemberService sysdeptmemberService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysTeamMemberService systeammemberService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysDepartmentService sysdepartmentService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysOrganizationService sysorganizationService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysPostService syspostService;
    @Autowired
    @Lazy
    ISysEmployeeService proxyService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysEmployee et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getUserid()), et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysEmployee> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list, batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysEmployee et) {
        fillParentData(et);
        if(!update(et, (Wrapper) et.getUpdateWrapper(true).eq("userid", et.getUserid()))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getUserid()), et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysEmployee> list) {
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
    public SysEmployee get(String key) {
        SysEmployee et = getById(key);
        if(et == null){
            et = new SysEmployee();
            et.setUserid(key);
        }
        else {
        }
        return et;
    }

    @Override
    public SysEmployee getDraft(SysEmployee et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysEmployee et) {
        return (!ObjectUtils.isEmpty(et.getUserid())) && (!Objects.isNull(this.getById(et.getUserid())));
    }
    @Override
    @Transactional
    public SysEmployee initPwd(SysEmployee et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean initPwdBatch(List<SysEmployee> etList) {
        for(SysEmployee et : etList) {
            initPwd(et);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(SysEmployee et) {
        if(!saveOrUpdate(et)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysEmployee et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? proxyService.update(et) : proxyService.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysEmployee> list) {
        list.forEach(item->fillParentData(item));
        List<SysEmployee> create = new ArrayList<>();
        List<SysEmployee> update = new ArrayList<>();
        for (SysEmployee et : list) {
            if (ObjectUtils.isEmpty(et.getUserid()) || ObjectUtils.isEmpty(getById(et.getUserid()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            proxyService.createBatch(create);
        }
        if (update.size() > 0) {
            proxyService.updateBatch(update);
        }
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysEmployee> list) {
        list.forEach(item->fillParentData(item));
        List<SysEmployee> create = new ArrayList<>();
        List<SysEmployee> update = new ArrayList<>();
        for (SysEmployee et : list) {
            if (ObjectUtils.isEmpty(et.getUserid()) || ObjectUtils.isEmpty(getById(et.getUserid()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            proxyService.createBatch(create);
        }
        if (update.size() > 0) {
            proxyService.updateBatch(update);
        }
    }


	@Override
    public List<SysEmployee> selectByMdeptid(String deptid) {
        return baseMapper.selectByMdeptid(deptid);
    }
    @Override
    public void resetByMdeptid(String deptid) {
        this.update(new UpdateWrapper<SysEmployee>().set("mdeptid",null).eq("mdeptid",deptid));
    }

    @Override
    public void resetByMdeptid(Collection<String> ids) {
        this.update(new UpdateWrapper<SysEmployee>().set("mdeptid",null).in("mdeptid",ids));
    }

    @Override
    public void removeByMdeptid(String deptid) {
        this.remove(new QueryWrapper<SysEmployee>().eq("mdeptid",deptid));
    }

	@Override
    public List<SysEmployee> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }
    @Override
    public void resetByOrgid(String orgid) {
        this.update(new UpdateWrapper<SysEmployee>().set("orgid",null).eq("orgid",orgid));
    }

    @Override
    public void resetByOrgid(Collection<String> ids) {
        this.update(new UpdateWrapper<SysEmployee>().set("orgid",null).in("orgid",ids));
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<SysEmployee>().eq("orgid",orgid));
    }

	@Override
    public List<SysEmployee> selectByPostid(String postid) {
        return baseMapper.selectByPostid(postid);
    }
    @Override
    public void removeByPostid(String postid) {
        this.remove(new QueryWrapper<SysEmployee>().eq("postid",postid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysEmployee> searchDefault(SysEmployeeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysEmployee> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysEmployee>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysEmployee et){
        //实体关系[DER1N_SYS_EMP_SYS_DEPT_MDEPTID]
        if(!ObjectUtils.isEmpty(et.getMdeptid())){
            cn.ibizlab.core.ou.domain.SysDepartment maindept=et.getMaindept();
            if(ObjectUtils.isEmpty(maindept)){
                cn.ibizlab.core.ou.domain.SysDepartment majorEntity=sysdepartmentService.get(et.getMdeptid());
                et.setMaindept(majorEntity);
                maindept=majorEntity;
            }
            et.setMdeptcode(maindept.getDeptcode());
            et.setMdeptname(maindept.getDeptname());
        }
        //实体关系[DER1N_SYS_EMP_SYS_ORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.core.ou.domain.SysOrganization org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.core.ou.domain.SysOrganization majorEntity=sysorganizationService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgcode(org.getOrgcode());
            et.setOrgname(org.getOrgname());
        }
        //实体关系[DER1N_SYS_EMP_SYS_POST_POSTID]
        if(!ObjectUtils.isEmpty(et.getPostid())){
            cn.ibizlab.core.ou.domain.SysPost post=et.getPost();
            if(ObjectUtils.isEmpty(post)){
                cn.ibizlab.core.ou.domain.SysPost majorEntity=syspostService.get(et.getPostid());
                et.setPost(majorEntity);
                post=majorEntity;
            }
            et.setPostcode(post.getPostcode());
            et.setPostname(post.getPostname());
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
    public List<SysEmployee> getSysemployeeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SysEmployee> getSysemployeeByEntities(List<SysEmployee> entities) {
        List ids =new ArrayList();
        for(SysEmployee entity : entities){
            Serializable id=entity.getUserid();
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



