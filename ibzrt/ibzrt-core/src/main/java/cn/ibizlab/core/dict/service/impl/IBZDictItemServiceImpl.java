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
import cn.ibizlab.core.dict.domain.IBZDictItem;
import cn.ibizlab.core.dict.filter.IBZDictItemSearchContext;
import cn.ibizlab.core.dict.service.IIBZDictItemService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.dict.client.IBZDictItemFeignClient;

/**
 * 实体[字典项目] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZDictItemServiceImpl implements IIBZDictItemService {

    @Autowired
    IBZDictItemFeignClient iBZDictItemFeignClient;


    @Override
    public boolean update(IBZDictItem et) {
        IBZDictItem rt = iBZDictItemFeignClient.update(et.getItemid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZDictItem> list){
        iBZDictItemFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean checkKey(IBZDictItem et) {
        return iBZDictItemFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(IBZDictItem et) {
        if(et.getItemid()==null) et.setItemid((String)et.getDefaultKey(true));
        if(!iBZDictItemFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZDictItem> list) {
        iBZDictItemFeignClient.saveBatch(list) ;
    }

    @Override
    public boolean remove(String itemid) {
        boolean result=iBZDictItemFeignClient.remove(itemid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZDictItemFeignClient.removeBatch(idList);
    }

    @Override
    public IBZDictItem get(String itemid) {
		IBZDictItem et=iBZDictItemFeignClient.get(itemid);
        if(et==null){
            et=new IBZDictItem();
            et.setItemid(itemid);
        }
        else{
        }
        return  et;
    }

    @Override
    public boolean create(IBZDictItem et) {
        IBZDictItem rt = iBZDictItemFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZDictItem> list){
        iBZDictItemFeignClient.createBatch(list) ;
    }

    @Override
    public IBZDictItem getDraft(IBZDictItem et) {
        et=iBZDictItemFeignClient.getDraft();
        return et;
    }



	@Override
    public List<IBZDictItem> selectByDictid(String dictid) {
        IBZDictItemSearchContext context=new IBZDictItemSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_dictid_eq(dictid);
        return iBZDictItemFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByDictid(String dictid) {
        Set<String> delIds=new HashSet<String>();
        for(IBZDictItem before:selectByDictid(dictid)){
            delIds.add(before.getItemid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }

	@Override
    public void saveByDictid(String dictid,List<IBZDictItem> list) {
        if(list==null)
            return;
        Set<String> delIds=new HashSet<String>();
        List<IBZDictItem> _update=new ArrayList<IBZDictItem>();
        List<IBZDictItem> _create=new ArrayList<IBZDictItem>();
        for(IBZDictItem before:selectByDictid(dictid)){
            delIds.add(before.getItemid());
        }
        for(IBZDictItem sub:list) {
            sub.setDictid(dictid);
            if(ObjectUtils.isEmpty(sub.getItemid()))
                sub.setItemid((String)sub.getDefaultKey(true));
            if(delIds.contains(sub.getItemid())) {
                delIds.remove(sub.getItemid());
                _update.add(sub);
            }
            else
                _create.add(sub);
        }
        if(_update.size()>0)
            this.updateBatch(_update);
        if(_create.size()>0)
            this.createBatch(_create);
        if(delIds.size()>0)
            this.removeBatch(delIds);
	}



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZDictItem> searchDefault(IBZDictItemSearchContext context) {
        Page<IBZDictItem> iBZDictItems=iBZDictItemFeignClient.searchDefault(context);
        return iBZDictItems;
    }


}



