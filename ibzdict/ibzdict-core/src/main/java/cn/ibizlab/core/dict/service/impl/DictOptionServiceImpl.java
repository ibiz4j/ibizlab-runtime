package cn.ibizlab.core.dict.service.impl;

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
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import cn.ibizlab.core.dict.service.IDictOptionService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.dict.mapper.DictOptionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[字典项] 服务对象接口实现
 */
@Slf4j
@Service("DictOptionServiceImpl")
public class DictOptionServiceImpl extends ServiceImpl<DictOptionMapper, DictOption> implements IDictOptionService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.dict.service.IDictCatalogService dictcatalogService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(DictOption et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getValueKey()),et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<DictOption> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(DictOption et) {
        fillParentData(et);
         if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vkey",et.getValueKey())))
            return false;
        CachedBeanCopier.copy(get(et.getValueKey()),et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<DictOption> list) {
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
    public DictOption get(String key) {
        DictOption et = getById(key);
        if(et==null){
            et=new DictOption();
            et.setValueKey(key);
        }
        else{
        }
        return et;
    }

    @Override
    public DictOption getDraft(DictOption et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(DictOption et) {
        return (!ObjectUtils.isEmpty(et.getValueKey()))&&(!Objects.isNull(this.getById(et.getValueKey())));
    }
    @Override
    @Transactional
    public boolean save(DictOption et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(DictOption et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<DictOption> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<DictOption> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<DictOption> selectByCatalogId(String id) {
        return baseMapper.selectByCatalogId(id);
    }

    @Override
    public void removeByCatalogId(String id) {
        this.remove(new QueryWrapper<DictOption>().eq("cid",id));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DictOption> searchDefault(DictOptionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DictOption> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<DictOption>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(DictOption et){
        //实体关系[DER1N_DICT_OPTION_DICT_CATALOG_CID]
        if(!ObjectUtils.isEmpty(et.getCatalogId())){
            cn.ibizlab.core.dict.domain.DictCatalog catalog=et.getCatalog();
            if(ObjectUtils.isEmpty(catalog)){
                cn.ibizlab.core.dict.domain.DictCatalog majorEntity=dictcatalogService.get(et.getCatalogId());
                et.setCatalog(majorEntity);
                catalog=majorEntity;
            }
            et.setCatalogName(catalog.getName());
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



