package cn.ibizlab.core.uaa.service.impl;

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
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;
import cn.ibizlab.core.uaa.service.ISysAppService;

import cn.ibizlab.util.helper.CachedBeanCopier;


/**
 * 实体[应用] 无存储服务对象接口实现
 */
@Slf4j
@Service
public class SysAppServiceImpl implements ISysAppService {


    @Override
    public boolean create(SysApp et) {
        //代码实现
        return true;
    }

    public void createBatch(List<SysApp> list){

    }

    @Override
    public boolean update(SysApp et) {
        //代码实现
        return true;
    }

    public void updateBatch(List<SysApp> list){
                    
    }

    @Override
    public boolean remove(String key) {
        return true;
    }

    public void removeBatch(Collection<String> idList){
                        
    }

    @Override
    public SysApp get(String key) {
        SysApp et = new SysApp();
        et.setId(key);
        return et;
    }

    @Override
    public SysApp getDraft(SysApp et) {
        return et;
    }

    @Override
    public boolean checkKey(SysApp et) {
        return false;
    }
    @Override
    @Transactional
    public boolean save(SysApp et) {
        //代码实现
        return true;
    }

    @Override
    public void saveBatch(List<SysApp> list) {
                       
    }



	@Override
    public List<SysApp> selectBySystemid(String pssystemid) {
        return null;
    }

    @Override
    public void removeBySystemid(String pssystemid) {
        Set<String> delIds=new HashSet<String>();
        for(SysApp before:selectBySystemid(pssystemid)){
            delIds.add(before.getId());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysApp> searchDefault(SysAppSearchContext context) {
        return new PageImpl<SysApp>(new ArrayList(),context.getPageable(),0);
    }


}

