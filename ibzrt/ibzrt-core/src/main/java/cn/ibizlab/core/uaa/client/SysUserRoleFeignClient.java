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
import cn.ibizlab.core.uaa.domain.SysUserRole;
import cn.ibizlab.core.uaa.filter.SysUserRoleSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysUserRole] 服务对象接口
 */
@FeignClient(value = "ibzuaa-api", contextId = "SysUserRole", fallback = SysUserRoleFallback.class)
public interface SysUserRoleFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sysuserroles/select")
    Page<SysUserRole> select();


    @RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/checkkey")
    Boolean checkKey(@RequestBody SysUserRole sysuserrole);


    @RequestMapping(method = RequestMethod.GET, value = "/sysuserroles/getdraft")
    SysUserRole getDraft();


    @RequestMapping(method = RequestMethod.PUT, value = "/sysuserroles/{userroleid}")
    SysUserRole update(@PathVariable("userroleid") String userroleid,@RequestBody SysUserRole sysuserrole);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysuserroles/batch")
    Boolean updateBatch(@RequestBody List<SysUserRole> sysuserroles);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysuserroles/{userroleid}")
    Boolean remove(@PathVariable("userroleid") String userroleid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysuserroles/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.POST, value = "/sysuserroles")
    SysUserRole create(@RequestBody SysUserRole sysuserrole);

    @RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/batch")
    Boolean createBatch(@RequestBody List<SysUserRole> sysuserroles);


    @RequestMapping(method = RequestMethod.GET, value = "/sysuserroles/{userroleid}")
    SysUserRole get(@PathVariable("userroleid") String userroleid);


    @RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/save")
    Boolean save(@RequestBody SysUserRole sysuserrole);

    @RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/save")
    Boolean saveBatch(@RequestBody List<SysUserRole> sysuserroles);



    @RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/searchdefault")
    Page<SysUserRole> searchDefault(@RequestBody SysUserRoleSearchContext context);


}
