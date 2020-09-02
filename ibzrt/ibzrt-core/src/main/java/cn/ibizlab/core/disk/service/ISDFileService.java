package cn.ibizlab.core.disk.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;


/**
 * 实体[SDFile] 服务对象接口
 */
public interface ISDFileService{

    boolean create(SDFile et) ;
    void createBatch(List<SDFile> list) ;
    boolean update(SDFile et) ;
    void updateBatch(List<SDFile> list) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    SDFile get(String key) ;
    SDFile getDraft(SDFile et) ;
    boolean checkKey(SDFile et) ;
    boolean save(SDFile et) ;
    void saveBatch(List<SDFile> list) ;
    Page<SDFile> searchDefault(SDFileSearchContext context) ;

}



