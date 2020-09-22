package cn.ibizlab.core.workflow.service.impl;

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
import cn.ibizlab.core.workflow.domain.WFMember;
import cn.ibizlab.core.workflow.filter.WFMemberSearchContext;
import cn.ibizlab.core.workflow.service.IWFMemberService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.workflow.mapper.WFMemberMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[成员] 服务对象接口实现
 */
@Slf4j
@Service("WFMemberServiceImpl")
public class WFMemberServiceImpl extends ServiceImpl<WFMemberMapper, WFMember> implements IWFMemberService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.workflow.service.IWFGroupService wfgroupService;
    @Autowired
    @Lazy
    protected cn.ibizlab.core.workflow.service.IWFUserService wfuserService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFMember et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getMemberid()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<WFMember> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFMember et) {
        fillParentData(et);
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("memberid",et.getMemberid())))
            return false;
        CachedBeanCopier.copy(get(et.getMemberid()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<WFMember> list) {
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
    public WFMember get(String key) {
        WFMember et = getById(key);
        if(et==null){
            et=new WFMember();
            et.setMemberid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public WFMember getDraft(WFMember et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(WFMember et) {
        return (!ObjectUtils.isEmpty(et.getMemberid()))&&(!Objects.isNull(this.getById(et.getMemberid())));
    }
    @Override
    @Transactional
    public boolean save(WFMember et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(WFMember et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<WFMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<WFMember> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<WFMember> selectByGroupid(String id) {
        return baseMapper.selectByGroupid(id);
    }

    @Override
    public void removeByGroupid(String id) {
        this.remove(new QueryWrapper<WFMember>().eq("groupid",id));
    }

    @Autowired
    @Lazy
    IWFMemberService proxyService;
	@Override
    public void saveByGroupid(String id,List<WFMember> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<WFMember> _update=new ArrayList<WFMember>();
        List<WFMember> _create=new ArrayList<WFMember>();
        for(WFMember before:selectByGroupid(id)){
            delIds.add(before.getMemberid());
        }
        for(WFMember sub:list) {
            sub.setGroupid(id);
            if(ObjectUtils.isEmpty(sub.getMemberid()))
                sub.setMemberid((String)sub.getDefaultKey(true));
            if(delIds.contains(sub.getMemberid())) {
                delIds.remove(sub.getMemberid());
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

	@Override
    public List<WFMember> selectByUserid(String id) {
        return baseMapper.selectByUserid(id);
    }

    @Override
    public void removeByUserid(String id) {
        this.remove(new QueryWrapper<WFMember>().eq("userid",id));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFMember> searchDefault(WFMemberSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFMember> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFMember>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFMember et){
        //实体关系[DER1N_WF_GROUP_MEMBER_WF_GROUP_GROUPID]
        if(!ObjectUtils.isEmpty(et.getGroupid())){
            cn.ibizlab.core.workflow.domain.WFGroup group=et.getGroup();
            if(ObjectUtils.isEmpty(group)){
                cn.ibizlab.core.workflow.domain.WFGroup majorEntity=wfgroupService.getById(et.getGroupid());
                if(ObjectUtils.isEmpty(majorEntity))
                    return;
                et.setGroup(majorEntity);
                group=majorEntity;
            }
            et.setGroupname(group.getName());
        }
        //实体关系[DER1N_WF_GROUP_MEMBER_WF_USER_USERID]
        if(!ObjectUtils.isEmpty(et.getUserid())){
            cn.ibizlab.core.workflow.domain.WFUser user=et.getUser();
            if(ObjectUtils.isEmpty(user)){
                cn.ibizlab.core.workflow.domain.WFUser majorEntity=wfuserService.getById(et.getUserid());
                if(ObjectUtils.isEmpty(majorEntity))
                    return;
                et.setUser(majorEntity);
                user=majorEntity;
            }
            et.setPersonname(user.getDisplayname());
            et.setOrgid(user.getOrgid());
            et.setOrgname(user.getOrgname());
            et.setMdeptid(user.getMdeptid());
            et.setMdeptname(user.getMdeptname());
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
    public List<WFMember> getWfmemberByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<WFMember> getWfmemberByEntities(List<WFMember> entities) {
        List ids =new ArrayList();
        for(WFMember entity : entities){
            Serializable id=entity.getMemberid();
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



