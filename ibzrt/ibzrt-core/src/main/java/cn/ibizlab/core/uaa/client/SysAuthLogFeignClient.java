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
import cn.ibizlab.core.uaa.domain.SysAuthLog;
import cn.ibizlab.core.uaa.filter.SysAuthLogSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysAuthLog] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzuaa-api:ibzuaa-api}", contextId = "SysAuthLog", fallback = SysAuthLogFallback.class)
public interface SysAuthLogFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sysauthlogs/select")
    Page<SysAuthLog> select();


    @RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs")
    SysAuthLog create(@RequestBody SysAuthLog sysauthlog);

    @RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/batch")
    Boolean createBatch(@RequestBody List<SysAuthLog> sysauthlogs);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysauthlogs/{logid}")
    SysAuthLog update(@PathVariable("logid") String logid,@RequestBody SysAuthLog sysauthlog);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysauthlogs/batch")
    Boolean updateBatch(@RequestBody List<SysAuthLog> sysauthlogs);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysauthlogs/{logid}")
    Boolean remove(@PathVariable("logid") String logid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysauthlogs/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/sysauthlogs/{logid}")
    SysAuthLog get(@PathVariable("logid") String logid);


    @RequestMapping(method = RequestMethod.GET, value = "/sysauthlogs/getdraft")
    SysAuthLog getDraft(SysAuthLog entity);


    @RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/checkkey")
    Boolean checkKey(@RequestBody SysAuthLog sysauthlog);


    @RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/save")
    Object saveEntity(@RequestBody SysAuthLog sysauthlog);

    default Boolean save(@RequestBody SysAuthLog sysauthlog) { return saveEntity(sysauthlog)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/savebatch")
    Boolean saveBatch(@RequestBody List<SysAuthLog> sysauthlogs);



    @RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/searchdefault")
    Page<SysAuthLog> searchDefault(@RequestBody SysAuthLogSearchContext context);


}
