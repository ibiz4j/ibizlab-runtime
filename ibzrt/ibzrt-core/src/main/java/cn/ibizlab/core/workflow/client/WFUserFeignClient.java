package cn.ibizlab.core.workflow.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.core.workflow.filter.WFUserSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFUser] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzwf-api:ibzwf-api}", contextId = "WFUser", fallback = WFUserFallback.class)
public interface WFUserFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/wfusers")
    WFUser create(@RequestBody WFUser wfuser);

    @RequestMapping(method = RequestMethod.POST, value = "/wfusers/batch")
    Boolean createBatch(@RequestBody List<WFUser> wfusers);


    @RequestMapping(method = RequestMethod.GET, value = "/wfusers/{id}")
    WFUser get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfusers/{id}")
    WFUser update(@PathVariable("id") String id,@RequestBody WFUser wfuser);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfusers/batch")
    Boolean updateBatch(@RequestBody List<WFUser> wfusers);


    @RequestMapping(method = RequestMethod.POST, value = "/wfusers/checkkey")
    Boolean checkKey(@RequestBody WFUser wfuser);



    @RequestMapping(method = RequestMethod.POST, value = "/wfusers/searchdefault")
    Page<WFUser> searchDefault(@RequestBody WFUserSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/wfusers/getdraft")
    WFUser getDraft(WFUser entity);


    @RequestMapping(method = RequestMethod.POST, value = "/wfusers/save")
    Object saveEntity(@RequestBody WFUser wfuser);

    default Boolean save(@RequestBody WFUser wfuser) { return saveEntity(wfuser)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/wfusers/savebatch")
    Boolean saveBatch(@RequestBody List<WFUser> wfusers);


    @RequestMapping(method = RequestMethod.GET, value = "/wfusers/select")
    Page<WFUser> select();


}
