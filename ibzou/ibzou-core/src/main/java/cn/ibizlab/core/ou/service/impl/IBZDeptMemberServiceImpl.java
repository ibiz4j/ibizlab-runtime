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
import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;
import cn.ibizlab.core.ou.service.IIBZDeptMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.IBZDeptMemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门成员] 服务对象接口实现
 */
@Slf4j
@Service("IBZDeptMemberServiceImpl")
public class IBZDeptMemberServiceImpl extends ServiceImpl<IBZDeptMemberMapper, IBZDeptMember> implements IIBZDeptMemberService {

    @Autowired
    @Lazy
    private cn.ibizlab.core.ou.service.IIBZDepartmentService ibzdepartmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;
    @Autowired
    @Lazy
    private cn.ibizlab.core.ou.service.IIBZPostService ibzpostService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(IBZDeptMember et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("memberid",et.getMemberid())))
            return false;
        CachedBeanCopier.copy(get(et.getMemberid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<IBZDeptMember> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(IBZDeptMember et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getMemberid()),et);
        return true;
    }

    @Override
    public void createBatch(List<IBZDeptMember> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(IBZDeptMember et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(IBZDeptMember et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<IBZDeptMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<IBZDeptMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public IBZDeptMember getDraft(IBZDeptMember et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public IBZDeptMember get(String key) {
        IBZDeptMember et = getById(key);
        if(et==null){
            et=new IBZDeptMember();
            et.setMemberid(key);
        }
        else{
        }
        return et;
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
    public boolean checkKey(IBZDeptMember et) {
        return (!ObjectUtils.isEmpty(et.getMemberid()))&&(!Objects.isNull(this.getById(et.getMemberid())));
    }

	@Override
    public List<IBZDeptMember> selectByDeptid(String deptid) {
        return baseMapper.selectByDeptid(deptid);
    }

    @Override
    public void removeByDeptid(String deptid) {
        this.remove(new QueryWrapper<IBZDeptMember>().eq("deptid",deptid));
    }

	@Override
    public List<IBZDeptMember> selectByUserid(String userid) {
        return baseMapper.selectByUserid(userid);
    }

    @Override
    public void removeByUserid(String userid) {
        this.remove(new QueryWrapper<IBZDeptMember>().eq("userid",userid));
    }

	@Override
    public List<IBZDeptMember> selectByPostid(String postid) {
        return baseMapper.selectByPostid(postid);
    }

    @Override
    public void removeByPostid(String postid) {
        this.remove(new QueryWrapper<IBZDeptMember>().eq("postid",postid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZDeptMember> searchDefault(IBZDeptMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IBZDeptMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<IBZDeptMember>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(IBZDeptMember et){
        //实体关系[DER1N_IBZDEPTMEMBER_IBZDEPT_DEPTID]
        if(!ObjectUtils.isEmpty(et.getDeptid())){
            cn.ibizlab.core.ou.domain.IBZDepartment dept=et.getDept();
            if(ObjectUtils.isEmpty(dept)){
                cn.ibizlab.core.ou.domain.IBZDepartment majorEntity=ibzdepartmentService.get(et.getDeptid());
                et.setDept(majorEntity);
                dept=majorEntity;
            }
            et.setDeptname(dept.getDeptname());
        }
        //实体关系[DER1N_IBZDEPTMEMBER_IBZEMP_USERID]
        if(!ObjectUtils.isEmpty(et.getUserid())){
            cn.ibizlab.core.ou.domain.IBZEmployee emp=et.getEmp();
            if(ObjectUtils.isEmpty(emp)){
                cn.ibizlab.core.ou.domain.IBZEmployee majorEntity=ibzemployeeService.get(et.getUserid());
                et.setEmp(majorEntity);
                emp=majorEntity;
            }
            et.setPersonname(emp.getPersonname());
        }
        //实体关系[DER1N_IBZDEPTMEMBER_IBZPOST_POSTID]
        if(!ObjectUtils.isEmpty(et.getPostid())){
            cn.ibizlab.core.ou.domain.IBZPost post=et.getPost();
            if(ObjectUtils.isEmpty(post)){
                cn.ibizlab.core.ou.domain.IBZPost majorEntity=ibzpostService.get(et.getPostid());
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



