package cn.ibizlab.core.uaa.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysPSSystem] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzuaa-api:ibzuaa-api}", contextId = "SysPSSystem", fallback = SysPSSystemFallback.class)
public interface SysPSSystemFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/syspssystems/select")
    Page<SysPSSystem> select();


    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems")
    SysPSSystem create(@RequestBody SysPSSystem syspssystem);

    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/batch")
    Boolean createBatch(@RequestBody List<SysPSSystem> syspssystems);


    @RequestMapping(method = RequestMethod.PUT, value = "/syspssystems/{pssystemid}")
    SysPSSystem update(@PathVariable("pssystemid") String pssystemid,@RequestBody SysPSSystem syspssystem);

    @RequestMapping(method = RequestMethod.PUT, value = "/syspssystems/batch")
    Boolean updateBatch(@RequestBody List<SysPSSystem> syspssystems);


    @RequestMapping(method = RequestMethod.DELETE, value = "/syspssystems/{pssystemid}")
    Boolean remove(@PathVariable("pssystemid") String pssystemid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/syspssystems/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/syspssystems/{pssystemid}")
    SysPSSystem get(@PathVariable("pssystemid") String pssystemid);


    @RequestMapping(method = RequestMethod.GET, value = "/syspssystems/getdraft")
    SysPSSystem getDraft(SysPSSystem entity);


    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/checkkey")
    Boolean checkKey(@RequestBody SysPSSystem syspssystem);


    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/save")
    Boolean save(@RequestBody SysPSSystem syspssystem);

    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/savebatch")
    Boolean saveBatch(@RequestBody List<SysPSSystem> syspssystems);



    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/searchdefault")
    Page<SysPSSystem> searchDefault(@RequestBody SysPSSystemSearchContext context);



    @RequestMapping(method = RequestMethod.POST, value = "/syspssystems/searchpick")
    Page<SysPSSystem> searchPick(@RequestBody SysPSSystemSearchContext context);


}
