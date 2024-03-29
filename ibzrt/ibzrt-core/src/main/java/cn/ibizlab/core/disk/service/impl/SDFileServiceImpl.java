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
import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;
import cn.ibizlab.core.disk.service.ISDFileService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.JSONObject;


import cn.ibizlab.core.disk.client.SDFileFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实体[文件] 服务对象接口实现
 */
@Slf4j
@Service
public class SDFileServiceImpl implements ISDFileService {

    @Autowired
    SDFileFeignClient sDFileFeignClient;


    @Override
    public boolean create(SDFile et) {
        SDFile rt = sDFileFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<SDFile> list){
        sDFileFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SDFile et) {
        SDFile rt = sDFileFeignClient.update(et.getId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<SDFile> list){
        sDFileFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String id) {
        boolean result=sDFileFeignClient.remove(id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sDFileFeignClient.removeBatch(idList);
    }

    @Override
    public SDFile get(String id) {
		SDFile et=sDFileFeignClient.get(id);
        if(et==null){
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), id);
        }
        else{
        }
        return  et;
    }

    @Override
    public SDFile getDraft(SDFile et) {
        et=sDFileFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(SDFile et) {
        return sDFileFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SDFile et) {
        boolean result = true;
        Object rt = sDFileFeignClient.saveEntity(et);
        if(rt == null)
          return false;
        try {
            if (rt instanceof Map) {
                ObjectMapper mapper = new ObjectMapper();
                rt = mapper.readValue(mapper.writeValueAsString(rt), SDFile.class);
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
    public void saveBatch(List<SDFile> list) {
        sDFileFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SDFile> searchDefault(SDFileSearchContext context) {
        Page<SDFile> sDFiles=sDFileFeignClient.searchDefault(context);
        return sDFiles;
    }



}



