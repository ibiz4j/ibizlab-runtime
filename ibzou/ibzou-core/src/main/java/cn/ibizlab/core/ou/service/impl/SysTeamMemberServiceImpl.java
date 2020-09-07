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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.SysTeamMember;
import cn.ibizlab.core.ou.filter.SysTeamMemberSearchContext;
import cn.ibizlab.core.ou.service.ISysTeamMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.SysTeamMemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组成员] 服务对象接口实现
 */
@Slf4j
@Service("SysTeamMemberServiceImpl")
public class SysTeamMemberServiceImpl extends ServiceImpl<SysTeamMemberMapper, SysTeamMember> implements ISysTeamMemberService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysEmployeeService sysemployeeService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysPostService syspostService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.ou.service.ISysTeamService systeamService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SysTeamMember et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTeammemberid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SysTeamMember> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SysTeamMember et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("teammemberid",et.getTeammemberid())))
            return false;
        CachedBeanCopier.copy(get(et.getTeammemberid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SysTeamMember> list) {
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
    public SysTeamMember get(String key) {
        SysTeamMember et = getById(key);
        if(et==null){
            et=new SysTeamMember();
            et.setTeammemberid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SysTeamMember getDraft(SysTeamMember et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SysTeamMember et) {
        return (!ObjectUtils.isEmpty(et.getTeammemberid()))&&(!Objects.isNull(this.getById(et.getTeammemberid())));
    }
    @Override
    @Transactional
    public boolean save(SysTeamMember et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(SysTeamMember et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SysTeamMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SysTeamMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SysTeamMember> selectByUserid(String userid) {
        return baseMapper.selectByUserid(userid);
    }

    @Override
    public void removeByUserid(String userid) {
        this.remove(new QueryWrapper<SysTeamMember>().eq("userid",userid));
    }

	@Override
    public List<SysTeamMember> selectByPostid(String postid) {
        return baseMapper.selectByPostid(postid);
    }

    @Override
    public void removeByPostid(String postid) {
        this.remove(new QueryWrapper<SysTeamMember>().eq("postid",postid));
    }

	@Override
    public List<SysTeamMember> selectByTeamid(String teamid) {
        return baseMapper.selectByTeamid(teamid);
    }

    @Override
    public void removeByTeamid(String teamid) {
        this.remove(new QueryWrapper<SysTeamMember>().eq("teamid",teamid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysTeamMember> searchDefault(SysTeamMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysTeamMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SysTeamMember>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SysTeamMember et){
        //实体关系[DER1N_SYS_TEAMMEMBER_SYS_EMP_USERID]
        if(!ObjectUtils.isEmpty(et.getUserid())){
            cn.ibizlab.core.ou.domain.SysEmployee emp=et.getEmp();
            if(ObjectUtils.isEmpty(emp)){
                cn.ibizlab.core.ou.domain.SysEmployee majorEntity=sysemployeeService.get(et.getUserid());
                et.setEmp(majorEntity);
                emp=majorEntity;
            }
            et.setPersonname(emp.getPersonname());
        }
        //实体关系[DER1N_SYS_TEAMMEMBER_SYS_POST_POSTID]
        if(!ObjectUtils.isEmpty(et.getPostid())){
            cn.ibizlab.core.ou.domain.SysPost post=et.getPost();
            if(ObjectUtils.isEmpty(post)){
                cn.ibizlab.core.ou.domain.SysPost majorEntity=syspostService.get(et.getPostid());
                et.setPost(majorEntity);
                post=majorEntity;
            }
            et.setPostname(post.getPostname());
        }
        //实体关系[DER1N_SYS_TEAMMEMBER_SYS_TEAM_TEAMID]
        if(!ObjectUtils.isEmpty(et.getTeamid())){
            cn.ibizlab.core.ou.domain.SysTeam team=et.getTeam();
            if(ObjectUtils.isEmpty(team)){
                cn.ibizlab.core.ou.domain.SysTeam majorEntity=systeamService.get(et.getTeamid());
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



