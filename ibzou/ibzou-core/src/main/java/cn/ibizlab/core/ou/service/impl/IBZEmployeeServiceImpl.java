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
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.filter.IBZEmployeeSearchContext;
import cn.ibizlab.core.ou.service.IIBZEmployeeService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.IBZEmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员] 服务对象接口实现
 */
@Slf4j
@Service("IBZEmployeeServiceImpl")
public class IBZEmployeeServiceImpl extends ServiceImpl<IBZEmployeeMapper, IBZEmployee> implements IIBZEmployeeService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZDeptMemberService ibzdeptmemberService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZTeamMemberService ibzteammemberService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZDepartmentService ibzdepartmentService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZOrganizationService ibzorganizationService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZPostService ibzpostService;

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.logic.IIBZEmployeesaveDeptMemberLogic savedeptmemberLogic;

    protected int batchSize = 500;

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
    public IBZEmployee initPwd(IBZEmployee et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(IBZEmployee et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserid()),et);
        savedeptmemberLogic.execute(et);
        return true;
    }

    @Override
    public void createBatch(List<IBZEmployee> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(IBZEmployee et) {
        return (!ObjectUtils.isEmpty(et.getUserid()))&&(!Objects.isNull(this.getById(et.getUserid())));
    }
    @Override
    @Transactional
    public boolean update(IBZEmployee et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userid",et.getUserid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserid()),et);
        savedeptmemberLogic.execute(et);
        return true;
    }

    @Override
    public void updateBatch(List<IBZEmployee> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(IBZEmployee et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(IBZEmployee et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<IBZEmployee> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<IBZEmployee> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public IBZEmployee get(String key) {
        IBZEmployee et = getById(key);
        if(et==null){
            et=new IBZEmployee();
            et.setUserid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public IBZEmployee getDraft(IBZEmployee et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<IBZEmployee> selectByMdeptid(String deptid) {
        return baseMapper.selectByMdeptid(deptid);
    }

    @Override
    public void removeByMdeptid(String deptid) {
        this.remove(new QueryWrapper<IBZEmployee>().eq("mdeptid",deptid));
    }

	@Override
    public List<IBZEmployee> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<IBZEmployee>().eq("orgid",orgid));
    }

	@Override
    public List<IBZEmployee> selectByPostid(String postid) {
        return baseMapper.selectByPostid(postid);
    }

    @Override
    public void removeByPostid(String postid) {
        this.remove(new QueryWrapper<IBZEmployee>().eq("postid",postid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZEmployee> searchDefault(IBZEmployeeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IBZEmployee> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<IBZEmployee>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(IBZEmployee et){
        //实体关系[DER1N_IBZEMP_IBZDEPT_MDEPTID]
        if(!ObjectUtils.isEmpty(et.getMdeptid())){
            cn.ibizlab.core.ou.domain.IBZDepartment maindept=et.getMaindept();
            if(ObjectUtils.isEmpty(maindept)){
                cn.ibizlab.core.ou.domain.IBZDepartment majorEntity=ibzdepartmentService.get(et.getMdeptid());
                et.setMaindept(majorEntity);
                maindept=majorEntity;
            }
            et.setMdeptcode(maindept.getDeptcode());
            et.setMdeptname(maindept.getDeptname());
        }
        //实体关系[DER1N_IBZEMP_IBZORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.core.ou.domain.IBZOrganization org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.core.ou.domain.IBZOrganization majorEntity=ibzorganizationService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgcode(org.getOrgcode());
            et.setOrgname(org.getOrgname());
        }
        //实体关系[DER1N_IBZEMP_IBZPOST_POSTID]
        if(!ObjectUtils.isEmpty(et.getPostid())){
            cn.ibizlab.core.ou.domain.IBZPost post=et.getPost();
            if(ObjectUtils.isEmpty(post)){
                cn.ibizlab.core.ou.domain.IBZPost majorEntity=ibzpostService.get(et.getPostid());
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
    public List<IBZEmployee> getIbzemployeeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<IBZEmployee> getIbzemployeeByEntities(List<IBZEmployee> entities) {
        List ids =new ArrayList();
        for(IBZEmployee entity : entities){
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


