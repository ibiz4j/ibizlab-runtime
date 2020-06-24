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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;
import cn.ibizlab.core.disk.service.ISDFileService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.disk.repository.SDFileRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import javax.annotation.Resource;
import com.mongodb.QueryBuilder;
/**
 * 实体[文件] 服务对象接口实现
 */
@Slf4j
@Service
public class SDFileServiceImpl implements ISDFileService {

    @Autowired
    private SDFileRepository repository;

    @Override
    @Transactional
    public boolean update(SDFile et) {
        repository.save(et);
        CachedBeanCopier.copy(get(et.getId()),et);
        return true ;
    }

    @Override
    public void updateBatch(List<SDFile> list) {
        repository.saveAll(list);
    }

    @Override
    @Transactional
    public boolean create(SDFile et) {
        repository.insert(et);
        CachedBeanCopier.copy(get(et.getId()),et);
        return true ;
    }

    @Override
    public void createBatch(List<SDFile> list) {
        repository.insert(list);
    }

    @Override
    public boolean checkKey(SDFile et) {
        return repository.findById(et.getId()).isPresent();
    }

    @Override
    public SDFile getDraft(SDFile et) {
        return et;
    }

    @Override
    @Transactional
    public SDFile get(String key) {
        Optional<SDFile> result = repository.findById(key);
        if(!result.isPresent()){
            SDFile et=new SDFile();
            et.setId(key);
            return et;
        }
        else{
            SDFile et=result.get();
            return et;
        }
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        repository.deleteById(key);
        return true ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        repository.deleteAll(repository.findAllById(idList));
    }

    @Override
    @Transactional
    public boolean save(SDFile et) {
        repository.save(et);
        CachedBeanCopier.copy(get(et.getId()),et);
        return true ;
    }


    @Override
    public void saveBatch(List<SDFile> list) {
        repository.saveAll(list);
    }



    

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SDFile> searchDefault(SDFileSearchContext context) {
        Query query = new BasicQuery(context.getSelectCond().get().toString());
        long total = mongoTemplate.count(query, SDFile.class);
        List<SDFile> list=mongoTemplate.find(query.with(context.getPageable()),SDFile.class);
        return new PageImpl<SDFile>(list,context.getPageable(),total);
    }


    @Override
    public List<SDFile> getSdfileByIds(List<String> ids) {
        QueryBuilder permissionCond=new QueryBuilder();
        permissionCond.and("id").in(ids);
        Query query = new BasicQuery(permissionCond.get().toString());
        return mongoTemplate.find(query,SDFile.class);
    }

    @Override
    public List<SDFile> getSdfileByEntities(List<SDFile> entities) {

        List ids =new ArrayList();
        for(SDFile entity : entities){
            Serializable id=entity.getId();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0){
            QueryBuilder permissionCond=new QueryBuilder();
            permissionCond.and("id").in(ids);
            Query query = new BasicQuery(permissionCond.get().toString());
            return mongoTemplate.find(query,SDFile.class);
        }
        else
            return entities;
    }

}




