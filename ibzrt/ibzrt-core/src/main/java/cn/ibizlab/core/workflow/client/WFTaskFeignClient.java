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
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFTask] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzwf-api:ibzwf-api}", contextId = "WFTask", fallback = WFTaskFallback.class)
public interface WFTaskFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wftasks/select")
    Page<WFTask> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wftasks")
    WFTask create(@RequestBody WFTask wftask);

    @RequestMapping(method = RequestMethod.POST, value = "/wftasks/batch")
    Boolean createBatch(@RequestBody List<WFTask> wftasks);


    @RequestMapping(method = RequestMethod.PUT, value = "/wftasks/{id}")
    WFTask update(@PathVariable("id") String id,@RequestBody WFTask wftask);

    @RequestMapping(method = RequestMethod.PUT, value = "/wftasks/batch")
    Boolean updateBatch(@RequestBody List<WFTask> wftasks);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wftasks/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wftasks/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wftasks/{id}")
    WFTask get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/wftasks/getdraft")
    WFTask getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/wftasks/checkkey")
    Boolean checkKey(@RequestBody WFTask wftask);


    @RequestMapping(method = RequestMethod.POST, value = "/wftasks/save")
    Boolean save(@RequestBody WFTask wftask);

    @RequestMapping(method = RequestMethod.POST, value = "/wftasks/savebatch")
    Boolean saveBatch(@RequestBody List<WFTask> wftasks);



    @RequestMapping(method = RequestMethod.POST, value = "/wftasks/searchdefault")
    Page<WFTask> searchDefault(@RequestBody WFTaskSearchContext context);


}
