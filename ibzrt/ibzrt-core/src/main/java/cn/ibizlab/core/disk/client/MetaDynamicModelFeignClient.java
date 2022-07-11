package cn.ibizlab.core.disk.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.filter.MetaDynamicModelSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[MetaDynamicModel] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzdisk-api:ibzdisk-api}", contextId = "MetaDynamicModel", fallback = MetaDynamicModelFallback.class)
public interface MetaDynamicModelFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels")
    MetaDynamicModel create(@RequestBody MetaDynamicModel metadynamicmodel);

    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/batch")
    Boolean createBatch(@RequestBody List<MetaDynamicModel> metadynamicmodels);


    @RequestMapping(method = RequestMethod.GET, value = "/metadynamicmodels/{configid}")
    MetaDynamicModel get(@PathVariable("configid") String configid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/metadynamicmodels/{configid}")
    Boolean remove(@PathVariable("configid") String configid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/metadynamicmodels/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/metadynamicmodels/{configid}")
    MetaDynamicModel update(@PathVariable("configid") String configid,@RequestBody MetaDynamicModel metadynamicmodel);

    @RequestMapping(method = RequestMethod.PUT, value = "/metadynamicmodels/batch")
    Boolean updateBatch(@RequestBody List<MetaDynamicModel> metadynamicmodels);


    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/checkkey")
    Boolean checkKey(@RequestBody MetaDynamicModel metadynamicmodel);



    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/searchdefault")
    Page<MetaDynamicModel> searchDefault(@RequestBody MetaDynamicModelSearchContext context);



    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/searchdynainst")
    Page<MetaDynamicModel> searchDynaInst(@RequestBody MetaDynamicModelSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/metadynamicmodels/getdraft")
    MetaDynamicModel getDraft(MetaDynamicModel entity);


    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/{configid}/init")
    MetaDynamicModel init(@PathVariable("configid") String configid,@RequestBody MetaDynamicModel metadynamicmodel);


    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/{configid}/publish")
    MetaDynamicModel publish(@PathVariable("configid") String configid,@RequestBody MetaDynamicModel metadynamicmodel);


    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/save")
    Object saveEntity(@RequestBody MetaDynamicModel metadynamicmodel);

    default Boolean save(@RequestBody MetaDynamicModel metadynamicmodel) { return saveEntity(metadynamicmodel)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/savebatch")
    Boolean saveBatch(@RequestBody List<MetaDynamicModel> metadynamicmodels);


    @RequestMapping(method = RequestMethod.GET, value = "/metadynamicmodels/select")
    Page<MetaDynamicModel> select();


}
