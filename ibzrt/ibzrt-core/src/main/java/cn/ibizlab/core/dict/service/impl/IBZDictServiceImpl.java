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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.dict.domain.IBZDict;
import cn.ibizlab.core.dict.filter.IBZDictSearchContext;
import cn.ibizlab.core.dict.service.IIBZDictService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.dict.client.IBZDictFeignClient;

/**
 * 实体[数据字典] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZDictServiceImpl implements IIBZDictService {

    @Autowired
    IBZDictFeignClient iBZDictFeignClient;


    @Override
    public boolean create(IBZDict et) {
        IBZDict rt = iBZDictFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZDict> list){
        iBZDictFeignClient.createBatch(list) ;
    }

    @Override
    public boolean remove(String dictid) {
        boolean result=iBZDictFeignClient.remove(dictid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZDictFeignClient.removeBatch(idList);
    }

    @Override
    public boolean update(IBZDict et) {
        IBZDict rt = iBZDictFeignClient.update(et.getDictid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZDict> list){
        iBZDictFeignClient.updateBatch(list) ;
    }

    @Override
    public IBZDict getDraft(IBZDict et) {
        et=iBZDictFeignClient.getDraft();
        return et;
    }

    @Override
    @Transactional
    public boolean save(IBZDict et) {
        if(et.getDictid()==null) et.setDictid((String)et.getDefaultKey(true));
        if(!iBZDictFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZDict> list) {
        iBZDictFeignClient.saveBatch(list) ;
    }

    @Override
    public IBZDict get(String dictid) {
		IBZDict et=iBZDictFeignClient.get(dictid);
        if(et==null){
            et=new IBZDict();
            et.setDictid(dictid);
        }
        else{
        }
        return  et;
    }

    @Override
    public boolean checkKey(IBZDict et) {
        return iBZDictFeignClient.checkKey(et);
    }




    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZDict> searchDefault(IBZDictSearchContext context) {
        Page<IBZDict> iBZDicts=iBZDictFeignClient.searchDefault(context);
        return iBZDicts;
    }


}


