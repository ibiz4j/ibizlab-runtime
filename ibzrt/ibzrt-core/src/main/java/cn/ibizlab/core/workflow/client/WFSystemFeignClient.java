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
import cn.ibizlab.core.workflow.domain.WFSystem;
import cn.ibizlab.core.workflow.filter.WFSystemSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFSystem] 服务对象接口
 */
@FeignClient(value = "ibzwf-api", contextId = "WFSystem", fallback = WFSystemFallback.class)
public interface WFSystemFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfsystems/select")
    Page<WFSystem> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wfsystems")
    WFSystem create(@RequestBody WFSystem wfsystem);

    @RequestMapping(method = RequestMethod.POST, value = "/wfsystems/batch")
    Boolean createBatch(@RequestBody List<WFSystem> wfsystems);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfsystems/{pssystemid}")
    WFSystem update(@PathVariable("pssystemid") String pssystemid,@RequestBody WFSystem wfsystem);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfsystems/batch")
    Boolean updateBatch(@RequestBody List<WFSystem> wfsystems);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfsystems/{pssystemid}")
    Boolean remove(@PathVariable("pssystemid") String pssystemid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfsystems/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wfsystems/{pssystemid}")
    WFSystem get(@PathVariable("pssystemid") String pssystemid);


    @RequestMapping(method = RequestMethod.GET, value = "/wfsystems/getdraft")
    WFSystem getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/wfsystems/checkkey")
    Boolean checkKey(@RequestBody WFSystem wfsystem);


    @RequestMapping(method = RequestMethod.POST, value = "/wfsystems/save")
    Boolean save(@RequestBody WFSystem wfsystem);

    @RequestMapping(method = RequestMethod.POST, value = "/wfsystems/save")
    Boolean saveBatch(@RequestBody List<WFSystem> wfsystems);



    @RequestMapping(method = RequestMethod.POST, value = "/wfsystems/searchdefault")
    Page<WFSystem> searchDefault(@RequestBody WFSystemSearchContext context);


}
