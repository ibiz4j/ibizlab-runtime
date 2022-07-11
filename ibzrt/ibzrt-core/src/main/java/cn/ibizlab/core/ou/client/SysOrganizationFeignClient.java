package cn.ibizlab.core.ou.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysOrganization] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "SysOrganization", fallback = SysOrganizationFallback.class)
public interface SysOrganizationFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/sysorganizations")
    SysOrganization create(@RequestBody SysOrganization sysorganization);

    @RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/batch")
    Boolean createBatch(@RequestBody List<SysOrganization> sysorganizations);


    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{orgid}")
    SysOrganization get(@PathVariable("orgid") String orgid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{orgid}")
    Boolean remove(@PathVariable("orgid") String orgid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{orgid}")
    SysOrganization update(@PathVariable("orgid") String orgid,@RequestBody SysOrganization sysorganization);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/batch")
    Boolean updateBatch(@RequestBody List<SysOrganization> sysorganizations);


    @RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/checkkey")
    Boolean checkKey(@RequestBody SysOrganization sysorganization);



    @RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/searchdefault")
    Page<SysOrganization> searchDefault(@RequestBody SysOrganizationSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/getdraft")
    SysOrganization getDraft(SysOrganization entity);


    @RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/save")
    Object saveEntity(@RequestBody SysOrganization sysorganization);

    default Boolean save(@RequestBody SysOrganization sysorganization) { return saveEntity(sysorganization)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/savebatch")
    Boolean saveBatch(@RequestBody List<SysOrganization> sysorganizations);


    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/select")
    Page<SysOrganization> select();


}
