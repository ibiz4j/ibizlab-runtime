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
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysRolePermission] 服务对象接口
 */
@FeignClient(value = "ibzuaa-api", contextId = "SysRolePermission", fallback = SysRolePermissionFallback.class)
public interface SysRolePermissionFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sysrolepermissions/select")
    Page<SysRolePermission> select();


    @RequestMapping(method = RequestMethod.GET, value = "/sysrolepermissions/{rolepermissionid}")
    SysRolePermission get(@PathVariable("rolepermissionid") String rolepermissionid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysrolepermissions/{rolepermissionid}")
    Boolean remove(@PathVariable("rolepermissionid") String rolepermissionid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysrolepermissions/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/sysrolepermissions/getdraft")
    SysRolePermission getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions")
    SysRolePermission create(@RequestBody SysRolePermission sysrolepermission);

    @RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/batch")
    Boolean createBatch(@RequestBody List<SysRolePermission> sysrolepermissions);


    @RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/checkkey")
    Boolean checkKey(@RequestBody SysRolePermission sysrolepermission);


    @RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/save")
    Boolean save(@RequestBody SysRolePermission sysrolepermission);

    @RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/save")
    Boolean saveBatch(@RequestBody List<SysRolePermission> sysrolepermissions);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysrolepermissions/{rolepermissionid}")
    SysRolePermission update(@PathVariable("rolepermissionid") String rolepermissionid,@RequestBody SysRolePermission sysrolepermission);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysrolepermissions/batch")
    Boolean updateBatch(@RequestBody List<SysRolePermission> sysrolepermissions);



    @RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/searchdefault")
    Page<SysRolePermission> searchDefault(@RequestBody SysRolePermissionSearchContext context);


}
