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
import cn.ibizlab.core.ou.domain.IBZTeamMember;
import cn.ibizlab.core.ou.filter.IBZTeamMemberSearchContext;
import cn.ibizlab.core.ou.service.IIBZTeamMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.IBZTeamMemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组成员] 服务对象接口实现
 */
@Slf4j
@Service("IBZTeamMemberServiceImpl")
public class IBZTeamMemberServiceImpl extends ServiceImpl<IBZTeamMemberMapper, IBZTeamMember> implements IIBZTeamMemberService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZEmployeeService ibzemployeeService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZPostService ibzpostService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.IIBZTeamService ibzteamService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(IBZTeamMember et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTeammemberid()),et);
        return true;
    }

    @Override
    public void createBatch(List<IBZTeamMember> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(IBZTeamMember et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("teammemberid",et.getTeammemberid())))
            return false;
        CachedBeanCopier.copy(get(et.getTeammemberid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<IBZTeamMember> list) {
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
    public IBZTeamMember get(String key) {
        IBZTeamMember et = getById(key);
        if(et==null){
            et=new IBZTeamMember();
            et.setTeammemberid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public IBZTeamMember getDraft(IBZTeamMember et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(IBZTeamMember et) {
        return (!ObjectUtils.isEmpty(et.getTeammemberid()))&&(!Objects.isNull(this.getById(et.getTeammemberid())));
    }
    @Override
    @Transactional
    public boolean save(IBZTeamMember et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(IBZTeamMember et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<IBZTeamMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<IBZTeamMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<IBZTeamMember> selectByUserid(String userid) {
        return baseMapper.selectByUserid(userid);
    }

    @Override
    public void removeByUserid(String userid) {
        this.remove(new QueryWrapper<IBZTeamMember>().eq("userid",userid));
    }

	@Override
    public List<IBZTeamMember> selectByPostid(String postid) {
        return baseMapper.selectByPostid(postid);
    }

    @Override
    public void removeByPostid(String postid) {
        this.remove(new QueryWrapper<IBZTeamMember>().eq("postid",postid));
    }

	@Override
    public List<IBZTeamMember> selectByTeamid(String teamid) {
        return baseMapper.selectByTeamid(teamid);
    }

    @Override
    public void removeByTeamid(String teamid) {
        this.remove(new QueryWrapper<IBZTeamMember>().eq("teamid",teamid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZTeamMember> searchDefault(IBZTeamMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IBZTeamMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<IBZTeamMember>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(IBZTeamMember et){
        //实体关系[DER1N_IBZTEAMMEMBER_IBZEMP_USERID]
        if(!ObjectUtils.isEmpty(et.getUserid())){
            cn.ibizlab.core.ou.domain.IBZEmployee emp=et.getEmp();
            if(ObjectUtils.isEmpty(emp)){
                cn.ibizlab.core.ou.domain.IBZEmployee majorEntity=ibzemployeeService.get(et.getUserid());
                et.setEmp(majorEntity);
                emp=majorEntity;
            }
            et.setPersonname(emp.getPersonname());
        }
        //实体关系[DER1N_IBZTEAMMEMBER_IBZPOST_POSTID]
        if(!ObjectUtils.isEmpty(et.getPostid())){
            cn.ibizlab.core.ou.domain.IBZPost post=et.getPost();
            if(ObjectUtils.isEmpty(post)){
                cn.ibizlab.core.ou.domain.IBZPost majorEntity=ibzpostService.get(et.getPostid());
                et.setPost(majorEntity);
                post=majorEntity;
            }
            et.setPostname(post.getPostname());
        }
        //实体关系[DER1N_IBZTEAMMEMBER_IBZTEAM_TEAMID]
        if(!ObjectUtils.isEmpty(et.getTeamid())){
            cn.ibizlab.core.ou.domain.IBZTeam team=et.getTeam();
            if(ObjectUtils.isEmpty(team)){
                cn.ibizlab.core.ou.domain.IBZTeam majorEntity=ibzteamService.get(et.getTeamid());
                et.setTeam(majorEntity);
                team=majorEntity;
            }
            et.setTeamname(team.getTeamname());
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


