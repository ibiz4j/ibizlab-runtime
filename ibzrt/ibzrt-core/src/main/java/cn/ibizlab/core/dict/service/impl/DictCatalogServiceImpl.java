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
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.dict.client.DictCatalogFeignClient;

/**
 * 实体[字典] 服务对象接口实现
 */
@Slf4j
@Service
public class DictCatalogServiceImpl implements IDictCatalogService {

    @Autowired
    DictCatalogFeignClient dictCatalogFeignClient;


    @Override
    public boolean create(DictCatalog et) {
        DictCatalog rt = dictCatalogFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<DictCatalog> list){
        dictCatalogFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(DictCatalog et) {
        DictCatalog rt = dictCatalogFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<DictCatalog> list){
        dictCatalogFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=dictCatalogFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        dictCatalogFeignClient.removeBatch(idList);
    }

    @Override
    public DictCatalog get(String id) {
		DictCatalog et=dictCatalogFeignClient.get(id);
        if(et==null){
            et=new DictCatalog();
            et.setId(id);
        }
        else{
        }
        return  et;
    }

    @Override
    public DictCatalog getDraft(DictCatalog et) {
        et=dictCatalogFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(DictCatalog et) {
        return dictCatalogFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(DictCatalog et) {
        if(et.getId()==null) et.setId((String)et.getDefaultKey(true));
        if(!dictCatalogFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<DictCatalog> list) {
        dictCatalogFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DictCatalog> searchDefault(DictCatalogSearchContext context) {
        Page<DictCatalog> dictCatalogs=dictCatalogFeignClient.searchDefault(context);
        return dictCatalogs;
    }




}



