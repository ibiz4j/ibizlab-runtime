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
import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.filter.SysDeptMemberSearchContext;
import cn.ibizlab.core.ou.service.ISysDeptMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.SysDeptMemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门成员] 服务对象接口实现
 */
@Slf4j
@Service("SysDeptMemberServiceImpl")
public class SysDeptMemberServiceImpl extends ServiceImpl<SysDeptMemberMapper, SysDeptMember> implements ISysDeptMemberService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysDepartmentService sysdepartmentService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysEmployeeService sysemployeeService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysPostService syspostService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysDeptMember et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getMemberid()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<SysDeptMember> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysDeptMember et) {
        fillParentData(et);
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("memberid",et.getMemberid())))
            return false;
        CachedBeanCopier.copy(get(et.getMemberid()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<SysDeptMember> list) {
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
    public SysDeptMember get(String key) {
        SysDeptMember et = getById(key);
        if(et==null){
            et=new SysDeptMember();
            et.setMemberid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SysDeptMember getDraft(SysDeptMember et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysDeptMember et) {
        return (!ObjectUtils.isEmpty(et.getMemberid()))&&(!Objects.isNull(this.getById(et.getMemberid())));
    }
    @Override
    @Transactional
    public boolean save(SysDeptMember et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysDeptMember et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<SysDeptMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<SysDeptMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SysDeptMember> selectByDeptid(String deptid) {
        return baseMapper.selectByDeptid(deptid);
    }

    @Override
    public void removeByDeptid(String deptid) {
        this.remove(new QueryWrapper<SysDeptMember>().eq("deptid",deptid));
    }

	@Override
    public List<SysDeptMember> selectByUserid(String userid) {
        return baseMapper.selectByUserid(userid);
    }

    @Override
    public void removeByUserid(String userid) {
        this.remove(new QueryWrapper<SysDeptMember>().eq("userid",userid));
    }

	@Override
    public List<SysDeptMember> selectByPostid(String postid) {
        return baseMapper.selectByPostid(postid);
    }

    @Override
    public void removeByPostid(String postid) {
        this.remove(new QueryWrapper<SysDeptMember>().eq("postid",postid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysDeptMember> searchDefault(SysDeptMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysDeptMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysDeptMember>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysDeptMember et){
        //实体关系[DER1N_SYS_DEPTMEMBER_SYS_DEPT_DEPTID]
        if(!ObjectUtils.isEmpty(et.getDeptid())){
            cn.ibizlab.core.ou.domain.SysDepartment dept=et.getDept();
            if(ObjectUtils.isEmpty(dept)){
                cn.ibizlab.core.ou.domain.SysDepartment majorEntity=sysdepartmentService.getById(et.getDeptid());
                if(ObjectUtils.isEmpty(majorEntity))
                    return;
                et.setDept(majorEntity);
                dept=majorEntity;
            }
            et.setDeptname(dept.getDeptname());
            et.setBcode(dept.getBcode());
        }
        //实体关系[DER1N_SYS_DEPTMEMBER_SYS_EMP_USERID]
        if(!ObjectUtils.isEmpty(et.getUserid())){
            cn.ibizlab.core.ou.domain.SysEmployee emp=et.getEmp();
            if(ObjectUtils.isEmpty(emp)){
                cn.ibizlab.core.ou.domain.SysEmployee majorEntity=sysemployeeService.getById(et.getUserid());
                if(ObjectUtils.isEmpty(majorEntity))
                    return;
                et.setEmp(majorEntity);
                emp=majorEntity;
            }
            et.setPersonname(emp.getPersonname());
        }
        //实体关系[DER1N_SYS_DEPTMEMBER_SYS_POST_POSTID]
        if(!ObjectUtils.isEmpty(et.getPostid())){
            cn.ibizlab.core.ou.domain.SysPost post=et.getPost();
            if(ObjectUtils.isEmpty(post)){
                cn.ibizlab.core.ou.domain.SysPost majorEntity=syspostService.getById(et.getPostid());
                if(ObjectUtils.isEmpty(majorEntity))
                    return;
                et.setPost(majorEntity);
                post=majorEntity;
            }
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



}



