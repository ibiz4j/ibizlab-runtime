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
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZOrganization] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "IBZOrganization", fallback = IBZOrganizationFallback.class)
public interface IBZOrganizationFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/select")
    Page<IBZOrganization> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations")
    IBZOrganization create(@RequestBody IBZOrganization ibzorganization);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/batch")
    Boolean createBatch(@RequestBody List<IBZOrganization> ibzorganizations);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{orgid}")
    IBZOrganization update(@PathVariable("orgid") String orgid,@RequestBody IBZOrganization ibzorganization);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/batch")
    Boolean updateBatch(@RequestBody List<IBZOrganization> ibzorganizations);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{orgid}")
    Boolean remove(@PathVariable("orgid") String orgid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{orgid}")
    IBZOrganization get(@PathVariable("orgid") String orgid);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/getdraft")
    IBZOrganization getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/checkkey")
    Boolean checkKey(@RequestBody IBZOrganization ibzorganization);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/save")
    Boolean save(@RequestBody IBZOrganization ibzorganization);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/save")
    Boolean saveBatch(@RequestBody List<IBZOrganization> ibzorganizations);



    @RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/searchdefault")
    Page<IBZOrganization> searchDefault(@RequestBody IBZOrganizationSearchContext context);


}
