package cn.ibizlab.core.dict.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[DictCatalog] 服务对象接口
 */
@FeignClient(value = "ibzdict-api", contextId = "DictCatalog", fallback = DictCatalogFallback.class)
public interface DictCatalogFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/select")
    Page<DictCatalog> select();


    @RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/getdraft")
    DictCatalog getDraft();


    @RequestMapping(method = RequestMethod.PUT, value = "/dictcatalogs/{id}")
    DictCatalog update(@PathVariable("id") String id,@RequestBody DictCatalog dictcatalog);

    @RequestMapping(method = RequestMethod.PUT, value = "/dictcatalogs/batch")
    Boolean updateBatch(@RequestBody List<DictCatalog> dictcatalogs);


    @RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs")
    DictCatalog create(@RequestBody DictCatalog dictcatalog);

    @RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/batch")
    Boolean createBatch(@RequestBody List<DictCatalog> dictcatalogs);


    @RequestMapping(method = RequestMethod.DELETE, value = "/dictcatalogs/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/dictcatalogs/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/{id}")
    DictCatalog get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/save")
    Boolean save(@RequestBody DictCatalog dictcatalog);

    @RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/save")
    Boolean saveBatch(@RequestBody List<DictCatalog> dictcatalogs);


    @RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/checkkey")
    Boolean checkKey(@RequestBody DictCatalog dictcatalog);



    @RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/searchdefault")
    Page<DictCatalog> searchDefault(@RequestBody DictCatalogSearchContext context);


}
