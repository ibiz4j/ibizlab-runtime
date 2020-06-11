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
import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFProcessInstance] 服务对象接口
 */
@FeignClient(value = "ibzwf-api", contextId = "WFProcessInstance", fallback = WFProcessInstanceFallback.class)
public interface WFProcessInstanceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessinstances/select")
    Page<WFProcessInstance> select();


    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessinstances/getdraft")
    WFProcessInstance getDraft();


    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessinstances/{id}")
    WFProcessInstance get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/checkkey")
    Boolean checkKey(@RequestBody WFProcessInstance wfprocessinstance);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfprocessinstances/{id}")
    WFProcessInstance update(@PathVariable("id") String id,@RequestBody WFProcessInstance wfprocessinstance);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfprocessinstances/batch")
    Boolean updateBatch(@RequestBody List<WFProcessInstance> wfprocessinstances);


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/save")
    Boolean save(@RequestBody WFProcessInstance wfprocessinstance);

    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/save")
    Boolean saveBatch(@RequestBody List<WFProcessInstance> wfprocessinstances);


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances")
    WFProcessInstance create(@RequestBody WFProcessInstance wfprocessinstance);

    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/batch")
    Boolean createBatch(@RequestBody List<WFProcessInstance> wfprocessinstances);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessinstances/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessinstances/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);



    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/searchdefault")
    Page<WFProcessInstance> searchDefault(@RequestBody WFProcessInstanceSearchContext context);


}
