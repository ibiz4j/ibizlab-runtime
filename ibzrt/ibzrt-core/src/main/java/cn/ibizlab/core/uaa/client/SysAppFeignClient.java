package cn.ibizlab.core.uaa.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysApp] 服务对象接口
 */
@FeignClient(value = "ibzuaa-api", contextId = "SysApp", fallback = SysAppFallback.class)
public interface SysAppFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sysapps/select")
    Page<SysApp> select();


    @RequestMapping(method = RequestMethod.PUT, value = "/sysapps/{id}")
    SysApp update(@PathVariable("id") String id,@RequestBody SysApp sysapp);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysapps/batch")
    Boolean updateBatch(@RequestBody List<SysApp> sysapps);


    @RequestMapping(method = RequestMethod.GET, value = "/sysapps/getdraft")
    SysApp getDraft();


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysapps/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysapps/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/sysapps/{id}")
    SysApp get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.POST, value = "/sysapps")
    SysApp create(@RequestBody SysApp sysapp);

    @RequestMapping(method = RequestMethod.POST, value = "/sysapps/batch")
    Boolean createBatch(@RequestBody List<SysApp> sysapps);


    @RequestMapping(method = RequestMethod.POST, value = "/sysapps/save")
    Boolean save(@RequestBody SysApp sysapp);

    @RequestMapping(method = RequestMethod.POST, value = "/sysapps/save")
    Boolean saveBatch(@RequestBody List<SysApp> sysapps);


    @RequestMapping(method = RequestMethod.POST, value = "/sysapps/checkkey")
    Boolean checkKey(@RequestBody SysApp sysapp);



    @RequestMapping(method = RequestMethod.POST, value = "/sysapps/searchdefault")
    Page<SysApp> searchDefault(@RequestBody SysAppSearchContext context);


}
