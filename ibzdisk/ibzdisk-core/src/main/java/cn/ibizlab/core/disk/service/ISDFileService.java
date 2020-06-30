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
import com.alibaba.fastjson.JSONObject;
import org.springframework.cache.annotation.CacheEvict;

import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;


import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 实体[SDFile] 服务对象接口
 */
public interface ISDFileService extends IService<SDFile>{

    boolean update(SDFile et) ;
    void updateBatch(List<SDFile> list) ;
    boolean create(SDFile et) ;
    void createBatch(List<SDFile> list) ;
    boolean checkKey(SDFile et) ;
    SDFile getDraft(SDFile et) ;
    SDFile get(String key) ;
    boolean remove(String key) ;
    void removeBatch(Collection<String> idList) ;
    boolean save(SDFile et) ;
    void saveBatch(List<SDFile> list) ;
    Page<SDFile> searchDefault(SDFileSearchContext context) ;
    /**
     *自定义查询SQL
     * @param sql  select * from table where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return select * from table where id = '1'
     */
    List<JSONObject> select(String sql, Map param);
    /**
     *自定义SQL
     * @param sql  update table  set name ='test' where id =#{et.param}
     * @param param 参数列表  param.put("param","1");
     * @return     update table  set name ='test' where id = '1'
     */
    boolean execute(String sql, Map param);

    List<SDFile> getSdfileByIds(List<String> ids) ;
    List<SDFile> getSdfileByEntities(List<SDFile> entities) ;


}


