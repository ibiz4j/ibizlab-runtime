package cn.ibizlab.core.disk.service.impl;

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
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.filter.MetaDynamicModelSearchContext;
import cn.ibizlab.core.disk.service.IMetaDynamicModelService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.disk.client.MetaDynamicModelFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[动态模型] 服务对象接口实现
 */
@Slf4j
@Service
public class MetaDynamicModelServiceImpl implements IMetaDynamicModelService {

    @Autowired
    MetaDynamicModelFeignClient metaDynamicModelFeignClient;


    @Override
    public boolean create(MetaDynamicModel et) {
        MetaDynamicModel rt = metaDynamicModelFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<MetaDynamicModel> list){
        metaDynamicModelFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(MetaDynamicModel et) {
        MetaDynamicModel rt = metaDynamicModelFeignClient.update(et.getConfigid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<MetaDynamicModel> list){
        metaDynamicModelFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String configid) {
        boolean result=metaDynamicModelFeignClient.remove(configid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        metaDynamicModelFeignClient.removeBatch(idList);
    }

    @Override
    public MetaDynamicModel get(String configid) {
		MetaDynamicModel et=metaDynamicModelFeignClient.get(configid);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), configid);
        }
        else{
        }
        return  et;
    }

    @Override
    public MetaDynamicModel getDraft(MetaDynamicModel et) {
        et=metaDynamicModelFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(MetaDynamicModel et) {
        return metaDynamicModelFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public MetaDynamicModel init(MetaDynamicModel et) {
        et = metaDynamicModelFeignClient.init(et.getConfigid(), et);
        return et;
    }

    @Override
    @Transactional
    public boolean initBatch(List<MetaDynamicModel> etList) {
        for(MetaDynamicModel et : etList) {
            init(et);
        }
        return true;
    }

    @Override
    @Transactional
    public MetaDynamicModel publish(MetaDynamicModel et) {
        et = metaDynamicModelFeignClient.publish(et.getConfigid(), et);
        return et;
    }

    @Override
    @Transactional
    public boolean publishBatch(List<MetaDynamicModel> etList) {
        for(MetaDynamicModel et : etList) {
            publish(et);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(MetaDynamicModel et) {
        boolean result = true;
        Object rt = metaDynamicModelFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), MetaDynamicModel.class);
                if (rt != null) {
                    CachedBeanCopier.copy(rt, et);
                }
            } else if (rt instanceof Boolean) {
                result = (boolean) rt;
            }
        } catch (Exception e) {
        }
            return result;
    }

    @Override
    public void saveBatch(List<MetaDynamicModel> list) {
        metaDynamicModelFeignClient.saveBatch(list) ;
    }



	@Override
    public List<MetaDynamicModel> selectByPdynainstid(String configid) {
        MetaDynamicModelSearchContext context=new MetaDynamicModelSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_pdynainstid_eq(configid);
        return metaDynamicModelFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByPdynainstid(String configid) {
        Set<String> delIds=new HashSet<String>();
        for(MetaDynamicModel before:selectByPdynainstid(configid)){
            delIds.add(before.getConfigid());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 数据集
     */
    @Override
    public Page<MetaDynamicModel> searchDefault(MetaDynamicModelSearchContext context) {
        Page<MetaDynamicModel> metaDynamicModels=metaDynamicModelFeignClient.searchDefault(context);
        return metaDynamicModels;
    }

    /**
     * 查询集合 主实例数据查询
     */
    @Override
    public Page<MetaDynamicModel> searchDynaInst(MetaDynamicModelSearchContext context) {
        Page<MetaDynamicModel> metaDynamicModels=metaDynamicModelFeignClient.searchDynaInst(context);
        return metaDynamicModels;
    }

}



