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
import cn.ibizlab.core.dict.domain.IBZDict;
import cn.ibizlab.core.dict.filter.IBZDictSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZDict] 服务对象接口
 */
@FeignClient(value = "ibzdict-api", contextId = "IBZDict", fallback = IBZDictFallback.class)
public interface IBZDictFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzdicts/select")
    Page<IBZDict> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdicts")
    IBZDict create(@RequestBody IBZDict ibzdict);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdicts/batch")
    Boolean createBatch(@RequestBody List<IBZDict> ibzdicts);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdicts/{dictid}")
    Boolean remove(@PathVariable("dictid") String dictid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdicts/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdicts/{dictid}")
    IBZDict update(@PathVariable("dictid") String dictid,@RequestBody IBZDict ibzdict);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdicts/batch")
    Boolean updateBatch(@RequestBody List<IBZDict> ibzdicts);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdicts/getdraft")
    IBZDict getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdicts/save")
    Boolean save(@RequestBody IBZDict ibzdict);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdicts/save")
    Boolean saveBatch(@RequestBody List<IBZDict> ibzdicts);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdicts/{dictid}")
    IBZDict get(@PathVariable("dictid") String dictid);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdicts/checkkey")
    Boolean checkKey(@RequestBody IBZDict ibzdict);



    @RequestMapping(method = RequestMethod.POST, value = "/ibzdicts/searchdefault")
    Page<IBZDict> searchDefault(@RequestBody IBZDictSearchContext context);


}
