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
import cn.ibizlab.core.dict.domain.IBZDictItem;
import cn.ibizlab.core.dict.filter.IBZDictItemSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZDictItem] 服务对象接口
 */
@FeignClient(value = "ibzdict-api", contextId = "IBZDictItem", fallback = IBZDictItemFallback.class)
public interface IBZDictItemFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzdictitems/select")
    Page<IBZDictItem> select();


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdictitems/{itemid}")
    IBZDictItem update(@PathVariable("itemid") String itemid,@RequestBody IBZDictItem ibzdictitem);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdictitems/batch")
    Boolean updateBatch(@RequestBody List<IBZDictItem> ibzdictitems);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdictitems/checkkey")
    Boolean checkKey(@RequestBody IBZDictItem ibzdictitem);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdictitems/save")
    Boolean save(@RequestBody IBZDictItem ibzdictitem);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdictitems/save")
    Boolean saveBatch(@RequestBody List<IBZDictItem> ibzdictitems);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdictitems/{itemid}")
    Boolean remove(@PathVariable("itemid") String itemid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdictitems/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdictitems/{itemid}")
    IBZDictItem get(@PathVariable("itemid") String itemid);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdictitems")
    IBZDictItem create(@RequestBody IBZDictItem ibzdictitem);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdictitems/batch")
    Boolean createBatch(@RequestBody List<IBZDictItem> ibzdictitems);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdictitems/getdraft")
    IBZDictItem getDraft();



    @RequestMapping(method = RequestMethod.POST, value = "/ibzdictitems/searchdefault")
    Page<IBZDictItem> searchDefault(@RequestBody IBZDictItemSearchContext context);


}
