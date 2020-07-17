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
import cn.ibizlab.core.workflow.domain.WFTaskWay;
import cn.ibizlab.core.workflow.filter.WFTaskWaySearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFTaskWay] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzwf-api:ibzwf-api}", contextId = "WFTaskWay", fallback = WFTaskWayFallback.class)
public interface WFTaskWayFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wftaskways/select")
    Page<WFTaskWay> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wftaskways")
    WFTaskWay create(@RequestBody WFTaskWay wftaskway);

    @RequestMapping(method = RequestMethod.POST, value = "/wftaskways/batch")
    Boolean createBatch(@RequestBody List<WFTaskWay> wftaskways);


    @RequestMapping(method = RequestMethod.PUT, value = "/wftaskways/{sequenceflowid}")
    WFTaskWay update(@PathVariable("sequenceflowid") String sequenceflowid,@RequestBody WFTaskWay wftaskway);

    @RequestMapping(method = RequestMethod.PUT, value = "/wftaskways/batch")
    Boolean updateBatch(@RequestBody List<WFTaskWay> wftaskways);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wftaskways/{sequenceflowid}")
    Boolean remove(@PathVariable("sequenceflowid") String sequenceflowid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wftaskways/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wftaskways/{sequenceflowid}")
    WFTaskWay get(@PathVariable("sequenceflowid") String sequenceflowid);


    @RequestMapping(method = RequestMethod.GET, value = "/wftaskways/getdraft")
    WFTaskWay getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/wftaskways/checkkey")
    Boolean checkKey(@RequestBody WFTaskWay wftaskway);


    @RequestMapping(method = RequestMethod.POST, value = "/wftaskways/save")
    Boolean save(@RequestBody WFTaskWay wftaskway);

    @RequestMapping(method = RequestMethod.POST, value = "/wftaskways/save")
    Boolean saveBatch(@RequestBody List<WFTaskWay> wftaskways);



    @RequestMapping(method = RequestMethod.POST, value = "/wftaskways/searchdefault")
    Page<WFTaskWay> searchDefault(@RequestBody WFTaskWaySearchContext context);


}
