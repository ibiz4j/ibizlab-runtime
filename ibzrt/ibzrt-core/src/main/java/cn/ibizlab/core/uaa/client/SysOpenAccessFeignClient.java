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
import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.filter.SysOpenAccessSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysOpenAccess] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzuaa-api:ibzuaa-api}", contextId = "SysOpenAccess", fallback = SysOpenAccessFallback.class)
public interface SysOpenAccessFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sysopenaccesses/select")
    Page<SysOpenAccess> select();


    @RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses")
    SysOpenAccess create(@RequestBody SysOpenAccess sysopenaccess);

    @RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/batch")
    Boolean createBatch(@RequestBody List<SysOpenAccess> sysopenaccesses);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysopenaccesses/{id}")
    SysOpenAccess update(@PathVariable("id") String id,@RequestBody SysOpenAccess sysopenaccess);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysopenaccesses/batch")
    Boolean updateBatch(@RequestBody List<SysOpenAccess> sysopenaccesses);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysopenaccesses/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysopenaccesses/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/sysopenaccesses/{id}")
    SysOpenAccess get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/sysopenaccesses/getdraft")
    SysOpenAccess getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/checkkey")
    Boolean checkKey(@RequestBody SysOpenAccess sysopenaccess);


    @RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/save")
    Boolean save(@RequestBody SysOpenAccess sysopenaccess);

    @RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/save")
    Boolean saveBatch(@RequestBody List<SysOpenAccess> sysopenaccesses);



    @RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/searchdefault")
    Page<SysOpenAccess> searchDefault(@RequestBody SysOpenAccessSearchContext context);


}
