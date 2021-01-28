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
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysPermission] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzuaa-api:ibzuaa-api}", contextId = "SysPermission", fallback = SysPermissionFallback.class)
public interface SysPermissionFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/syspermissions/select")
    Page<SysPermission> select();


    @RequestMapping(method = RequestMethod.POST, value = "/syspermissions")
    SysPermission create(@RequestBody SysPermission syspermission);

    @RequestMapping(method = RequestMethod.POST, value = "/syspermissions/batch")
    Boolean createBatch(@RequestBody List<SysPermission> syspermissions);


    @RequestMapping(method = RequestMethod.PUT, value = "/syspermissions/{permissionid}")
    SysPermission update(@PathVariable("permissionid") String permissionid,@RequestBody SysPermission syspermission);

    @RequestMapping(method = RequestMethod.PUT, value = "/syspermissions/batch")
    Boolean updateBatch(@RequestBody List<SysPermission> syspermissions);


    @RequestMapping(method = RequestMethod.DELETE, value = "/syspermissions/{permissionid}")
    Boolean remove(@PathVariable("permissionid") String permissionid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/syspermissions/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/syspermissions/{permissionid}")
    SysPermission get(@PathVariable("permissionid") String permissionid);


    @RequestMapping(method = RequestMethod.GET, value = "/syspermissions/getdraft")
    SysPermission getDraft(SysPermission entity);


    @RequestMapping(method = RequestMethod.POST, value = "/syspermissions/checkkey")
    Boolean checkKey(@RequestBody SysPermission syspermission);


    @RequestMapping(method = RequestMethod.POST, value = "/syspermissions/save")
    Boolean save(@RequestBody SysPermission syspermission);

    @RequestMapping(method = RequestMethod.POST, value = "/syspermissions/savebatch")
    Boolean saveBatch(@RequestBody List<SysPermission> syspermissions);



    @RequestMapping(method = RequestMethod.POST, value = "/syspermissions/searchdefault")
    Page<SysPermission> searchDefault(@RequestBody SysPermissionSearchContext context);


}
