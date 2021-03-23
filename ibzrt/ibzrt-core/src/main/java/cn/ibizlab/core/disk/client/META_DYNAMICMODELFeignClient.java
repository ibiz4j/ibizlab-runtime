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
import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import cn.ibizlab.core.disk.filter.META_DYNAMICMODELSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[META_DYNAMICMODEL] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzdisk-api:ibzdisk-api}", contextId = "META-DYNAMICMODEL", fallback = META_DYNAMICMODELFallback.class)
public interface META_DYNAMICMODELFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/meta_dynamicmodels/select")
    Page<META_DYNAMICMODEL> select();


    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels")
    META_DYNAMICMODEL create(@RequestBody META_DYNAMICMODEL meta_dynamicmodel);

    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/batch")
    Boolean createBatch(@RequestBody List<META_DYNAMICMODEL> meta_dynamicmodels);


    @RequestMapping(method = RequestMethod.PUT, value = "/meta_dynamicmodels/{configid}")
    META_DYNAMICMODEL update(@PathVariable("configid") String configid,@RequestBody META_DYNAMICMODEL meta_dynamicmodel);

    @RequestMapping(method = RequestMethod.PUT, value = "/meta_dynamicmodels/batch")
    Boolean updateBatch(@RequestBody List<META_DYNAMICMODEL> meta_dynamicmodels);


    @RequestMapping(method = RequestMethod.DELETE, value = "/meta_dynamicmodels/{configid}")
    Boolean remove(@PathVariable("configid") String configid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/meta_dynamicmodels/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/meta_dynamicmodels/{configid}")
    META_DYNAMICMODEL get(@PathVariable("configid") String configid);


    @RequestMapping(method = RequestMethod.GET, value = "/meta_dynamicmodels/getdraft")
    META_DYNAMICMODEL getDraft(META_DYNAMICMODEL entity);


    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/checkkey")
    Boolean checkKey(@RequestBody META_DYNAMICMODEL meta_dynamicmodel);


    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/{configid}/init")
    META_DYNAMICMODEL init(@PathVariable("configid") String configid,@RequestBody META_DYNAMICMODEL meta_dynamicmodel);


    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/{configid}/publish")
    META_DYNAMICMODEL publish(@PathVariable("configid") String configid,@RequestBody META_DYNAMICMODEL meta_dynamicmodel);


    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/save")
    Object saveEntity(@RequestBody META_DYNAMICMODEL meta_dynamicmodel);

    default Boolean save(@RequestBody META_DYNAMICMODEL meta_dynamicmodel) { return saveEntity(meta_dynamicmodel)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/savebatch")
    Boolean saveBatch(@RequestBody List<META_DYNAMICMODEL> meta_dynamicmodels);



    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/searchdefault")
    Page<META_DYNAMICMODEL> searchDefault(@RequestBody META_DYNAMICMODELSearchContext context);



    @RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/searchdynainst")
    Page<META_DYNAMICMODEL> searchDynaInst(@RequestBody META_DYNAMICMODELSearchContext context);


}
