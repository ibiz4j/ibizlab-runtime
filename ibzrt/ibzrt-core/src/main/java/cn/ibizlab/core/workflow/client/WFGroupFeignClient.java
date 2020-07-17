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
import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.filter.WFGroupSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFGroup] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzwf-api:ibzwf-api}", contextId = "WFGroup", fallback = WFGroupFallback.class)
public interface WFGroupFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfgroups/select")
    Page<WFGroup> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wfgroups")
    WFGroup create(@RequestBody WFGroup wfgroup);

    @RequestMapping(method = RequestMethod.POST, value = "/wfgroups/batch")
    Boolean createBatch(@RequestBody List<WFGroup> wfgroups);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfgroups/{id}")
    WFGroup update(@PathVariable("id") String id,@RequestBody WFGroup wfgroup);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfgroups/batch")
    Boolean updateBatch(@RequestBody List<WFGroup> wfgroups);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfgroups/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfgroups/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wfgroups/{id}")
    WFGroup get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/wfgroups/getdraft")
    WFGroup getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/wfgroups/checkkey")
    Boolean checkKey(@RequestBody WFGroup wfgroup);


    @RequestMapping(method = RequestMethod.POST, value = "/wfgroups/save")
    Boolean save(@RequestBody WFGroup wfgroup);

    @RequestMapping(method = RequestMethod.POST, value = "/wfgroups/save")
    Boolean saveBatch(@RequestBody List<WFGroup> wfgroups);



    @RequestMapping(method = RequestMethod.POST, value = "/wfgroups/searchdefault")
    Page<WFGroup> searchDefault(@RequestBody WFGroupSearchContext context);


}
