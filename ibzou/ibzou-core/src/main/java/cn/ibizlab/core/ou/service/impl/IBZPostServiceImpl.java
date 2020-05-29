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
import cn.ibizlab.core.ou.domain.IBZPost;
import cn.ibizlab.core.ou.filter.IBZPostSearchContext;
import cn.ibizlab.core.ou.service.IIBZPostService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.ou.mapper.IBZPostMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位] 服务对象接口实现
 */
@Slf4j
@Service("IBZPostServiceImpl")
public class IBZPostServiceImpl extends ServiceImpl<IBZPostMapper, IBZPost> implements IIBZPostService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(IBZPost et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("postid",et.getPostid())))
            return false;
        CachedBeanCopier.copy(get(et.getPostid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<IBZPost> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public IBZPost getDraft(IBZPost et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(IBZPost et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(IBZPost et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<IBZPost> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<IBZPost> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(IBZPost et) {
        return (!ObjectUtils.isEmpty(et.getPostid()))&&(!Objects.isNull(this.getById(et.getPostid())));
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
    public IBZPost get(String key) {
        IBZPost et = getById(key);
        if(et==null){
            et=new IBZPost();
            et.setPostid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(IBZPost et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPostid()),et);
        return true;
    }

    @Override
    public void createBatch(List<IBZPost> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZPost> searchDefault(IBZPostSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<IBZPost> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<IBZPost>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


