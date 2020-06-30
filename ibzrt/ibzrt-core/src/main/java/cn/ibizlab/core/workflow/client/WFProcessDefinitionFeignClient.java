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
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.filter.WFProcessDefinitionSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFProcessDefinition] 服务对象接口
 */
@FeignClient(value = "ibzwf-api", contextId = "WFProcessDefinition", fallback = WFProcessDefinitionFallback.class)
public interface WFProcessDefinitionFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessdefinitions/select")
    Page<WFProcessDefinition> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions")
    WFProcessDefinition create(@RequestBody WFProcessDefinition wfprocessdefinition);

    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/batch")
    Boolean createBatch(@RequestBody List<WFProcessDefinition> wfprocessdefinitions);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfprocessdefinitions/{definitionkey}")
    WFProcessDefinition update(@PathVariable("definitionkey") String definitionkey,@RequestBody WFProcessDefinition wfprocessdefinition);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfprocessdefinitions/batch")
    Boolean updateBatch(@RequestBody List<WFProcessDefinition> wfprocessdefinitions);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessdefinitions/{definitionkey}")
    Boolean remove(@PathVariable("definitionkey") String definitionkey);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessdefinitions/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessdefinitions/{definitionkey}")
    WFProcessDefinition get(@PathVariable("definitionkey") String definitionkey);


    @RequestMapping(method = RequestMethod.GET, value = "/wfprocessdefinitions/getdraft")
    WFProcessDefinition getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/checkkey")
    Boolean checkKey(@RequestBody WFProcessDefinition wfprocessdefinition);


    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/save")
    Boolean save(@RequestBody WFProcessDefinition wfprocessdefinition);

    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/save")
    Boolean saveBatch(@RequestBody List<WFProcessDefinition> wfprocessdefinitions);



    @RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/searchdefault")
    Page<WFProcessDefinition> searchDefault(@RequestBody WFProcessDefinitionSearchContext context);


}
