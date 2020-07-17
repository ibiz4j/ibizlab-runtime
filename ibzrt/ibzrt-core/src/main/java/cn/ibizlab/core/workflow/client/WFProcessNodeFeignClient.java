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
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFProcessNode] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzwf-api:ibzwf-api}", contextId = "WFProcessNode", fallback = WFProcessNodeFallback.class)
public interface WFProcessNodeFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessnodes/select")
    Page<WFProcessNode> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes")
    WFProcessNode create(@RequestBody WFProcessNode wfprocessnode);

    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/batch")
    Boolean createBatch(@RequestBody List<WFProcessNode> wfprocessnodes);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfprocessnodes/{usertaskid}")
    WFProcessNode update(@PathVariable("usertaskid") String usertaskid,@RequestBody WFProcessNode wfprocessnode);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfprocessnodes/batch")
    Boolean updateBatch(@RequestBody List<WFProcessNode> wfprocessnodes);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessnodes/{usertaskid}")
    Boolean remove(@PathVariable("usertaskid") String usertaskid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessnodes/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessnodes/{usertaskid}")
    WFProcessNode get(@PathVariable("usertaskid") String usertaskid);


    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessnodes/getdraft")
    WFProcessNode getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/checkkey")
    Boolean checkKey(@RequestBody WFProcessNode wfprocessnode);


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/save")
    Boolean save(@RequestBody WFProcessNode wfprocessnode);

    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/save")
    Boolean saveBatch(@RequestBody List<WFProcessNode> wfprocessnodes);



    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/searchdefault")
    Page<WFProcessNode> searchDefault(@RequestBody WFProcessNodeSearchContext context);


}
