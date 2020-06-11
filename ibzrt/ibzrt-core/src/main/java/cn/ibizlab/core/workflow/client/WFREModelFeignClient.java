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
import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.core.workflow.filter.WFREModelSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFREModel] 服务对象接口
 */
@FeignClient(value = "ibzwf-api", contextId = "WFREModel", fallback = WFREModelFallback.class)
public interface WFREModelFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfremodels/select")
    Page<WFREModel> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wfremodels")
    WFREModel create(@RequestBody WFREModel wfremodel);

    @RequestMapping(method = RequestMethod.POST, value = "/wfremodels/batch")
    Boolean createBatch(@RequestBody List<WFREModel> wfremodels);


    @RequestMapping(method = RequestMethod.GET, value = "/wfremodels/{id}")
    WFREModel get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.POST, value = "/wfremodels/save")
    Boolean save(@RequestBody WFREModel wfremodel);

    @RequestMapping(method = RequestMethod.POST, value = "/wfremodels/save")
    Boolean saveBatch(@RequestBody List<WFREModel> wfremodels);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfremodels/{id}")
    WFREModel update(@PathVariable("id") String id,@RequestBody WFREModel wfremodel);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfremodels/batch")
    Boolean updateBatch(@RequestBody List<WFREModel> wfremodels);


    @RequestMapping(method = RequestMethod.GET, value = "/wfremodels/getdraft")
    WFREModel getDraft();


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfremodels/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfremodels/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.POST, value = "/wfremodels/checkkey")
    Boolean checkKey(@RequestBody WFREModel wfremodel);



    @RequestMapping(method = RequestMethod.POST, value = "/wfremodels/searchdefault")
    Page<WFREModel> searchDefault(@RequestBody WFREModelSearchContext context);


}
