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
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.filter.SysUserAuthSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysUserAuth] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzuaa-api:ibzuaa-api}", contextId = "SysUserAuth", fallback = SysUserAuthFallback.class)
public interface SysUserAuthFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sysuserauths/select")
    Page<SysUserAuth> select();


    @RequestMapping(method = RequestMethod.POST, value = "/sysuserauths")
    SysUserAuth create(@RequestBody SysUserAuth sysuserauth);

    @RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/batch")
    Boolean createBatch(@RequestBody List<SysUserAuth> sysuserauths);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysuserauths/{id}")
    SysUserAuth update(@PathVariable("id") String id,@RequestBody SysUserAuth sysuserauth);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysuserauths/batch")
    Boolean updateBatch(@RequestBody List<SysUserAuth> sysuserauths);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysuserauths/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysuserauths/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/sysuserauths/{id}")
    SysUserAuth get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/sysuserauths/getdraft")
    SysUserAuth getDraft(SysUserAuth entity);


    @RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/checkkey")
    Boolean checkKey(@RequestBody SysUserAuth sysuserauth);


    @RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/save")
    Boolean save(@RequestBody SysUserAuth sysuserauth);

    @RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/savebatch")
    Boolean saveBatch(@RequestBody List<SysUserAuth> sysuserauths);



    @RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/searchdefault")
    Page<SysUserAuth> searchDefault(@RequestBody SysUserAuthSearchContext context);


}
