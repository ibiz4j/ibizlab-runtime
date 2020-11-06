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


import cn.ibizlab.core.dict.client.DictOptionFeignClient;

/**
 * 实体[字典项] 服务对象接口实现
 */
@Slf4j
@Service
public class DictOptionServiceImpl implements IDictOptionService {

    @Autowired
    DictOptionFeignClient dictOptionFeignClient;


    @Override
    public boolean create(DictOption et) {
        DictOption rt = dictOptionFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<DictOption> list){
        dictOptionFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(DictOption et) {
        DictOption rt = dictOptionFeignClient.update(et.getValueKey(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<DictOption> list){
        dictOptionFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String value_key) {
        boolean result=dictOptionFeignClient.remove(value_key) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        dictOptionFeignClient.removeBatch(idList);
    }

    @Override
    public DictOption get(String value_key) {
		DictOption et=dictOptionFeignClient.get(value_key);
        if(et==null){
            et=new DictOption();
            et.setValueKey(value_key);
        }
        else{
        }
        return  et;
    }

    @Override
    public DictOption getDraft(DictOption et) {
        et=dictOptionFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(DictOption et) {
        return dictOptionFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(DictOption et) {
        if(et.getValueKey()==null) et.setValueKey((String)et.getDefaultKey(true));
        if(!dictOptionFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<DictOption> list) {
        dictOptionFeignClient.saveBatch(list) ;
    }



	@Override
    public List<DictOption> selectByCatalogId(String id) {
        DictOptionSearchContext context=new DictOptionSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_cid_eq(id);
        return dictOptionFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByCatalogId(String id) {
        Set<String> delIds=new HashSet<String>();
        for(DictOption before:selectByCatalogId(id)){
            delIds.add(before.getValueKey());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DictOption> searchDefault(DictOptionSearchContext context) {
        Page<DictOption> dictOptions=dictOptionFeignClient.searchDefault(context);
        return dictOptions;
    }




}



