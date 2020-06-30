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
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[DictOption] 服务对象接口
 */
@FeignClient(value = "ibzdict-api", contextId = "DictOption", fallback = DictOptionFallback.class)
public interface DictOptionFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/dictoptions/select")
    Page<DictOption> select();


    @RequestMapping(method = RequestMethod.POST, value = "/dictoptions")
    DictOption create(@RequestBody DictOption dictoption);

    @RequestMapping(method = RequestMethod.POST, value = "/dictoptions/batch")
    Boolean createBatch(@RequestBody List<DictOption> dictoptions);


    @RequestMapping(method = RequestMethod.PUT, value = "/dictoptions/{value_key}")
    DictOption update(@PathVariable("value_key") String value_key,@RequestBody DictOption dictoption);

    @RequestMapping(method = RequestMethod.PUT, value = "/dictoptions/batch")
    Boolean updateBatch(@RequestBody List<DictOption> dictoptions);


    @RequestMapping(method = RequestMethod.DELETE, value = "/dictoptions/{value_key}")
    Boolean remove(@PathVariable("value_key") String value_key);

    @RequestMapping(method = RequestMethod.DELETE, value = "/dictoptions/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/dictoptions/{value_key}")
    DictOption get(@PathVariable("value_key") String value_key);


    @RequestMapping(method = RequestMethod.GET, value = "/dictoptions/getdraft")
    DictOption getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/dictoptions/checkkey")
    Boolean checkKey(@RequestBody DictOption dictoption);


    @RequestMapping(method = RequestMethod.POST, value = "/dictoptions/save")
    Boolean save(@RequestBody DictOption dictoption);

    @RequestMapping(method = RequestMethod.POST, value = "/dictoptions/save")
    Boolean saveBatch(@RequestBody List<DictOption> dictoptions);



    @RequestMapping(method = RequestMethod.POST, value = "/dictoptions/searchdefault")
    Page<DictOption> searchDefault(@RequestBody DictOptionSearchContext context);


}
