package cn.ibizlab.core.notify.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.filter.MsgOpenAccessSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[MsgOpenAccess] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibznotify-api:ibznotify-api}", contextId = "MsgOpenAccess", fallback = MsgOpenAccessFallback.class)
public interface MsgOpenAccessFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses")
    MsgOpenAccess create(@RequestBody MsgOpenAccess msgopenaccess);

    @RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/batch")
    Boolean createBatch(@RequestBody List<MsgOpenAccess> msgopenaccesses);


    @RequestMapping(method = RequestMethod.GET, value = "/msgopenaccesses/{id}")
    MsgOpenAccess get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.DELETE, value = "/msgopenaccesses/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/msgopenaccesses/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/msgopenaccesses/{id}")
    MsgOpenAccess update(@PathVariable("id") String id,@RequestBody MsgOpenAccess msgopenaccess);

    @RequestMapping(method = RequestMethod.PUT, value = "/msgopenaccesses/batch")
    Boolean updateBatch(@RequestBody List<MsgOpenAccess> msgopenaccesses);


    @RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/checkkey")
    Boolean checkKey(@RequestBody MsgOpenAccess msgopenaccess);



    @RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/searchdefault")
    Page<MsgOpenAccess> searchDefault(@RequestBody MsgOpenAccessSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/msgopenaccesses/getdraft")
    MsgOpenAccess getDraft(MsgOpenAccess entity);


    @RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/save")
    Object saveEntity(@RequestBody MsgOpenAccess msgopenaccess);

    default Boolean save(@RequestBody MsgOpenAccess msgopenaccess) { return saveEntity(msgopenaccess)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/savebatch")
    Boolean saveBatch(@RequestBody List<MsgOpenAccess> msgopenaccesses);


    @RequestMapping(method = RequestMethod.GET, value = "/msgopenaccesses/select")
    Page<MsgOpenAccess> select();


}
