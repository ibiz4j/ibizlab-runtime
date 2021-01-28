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
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[MsgBody] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibznotify-api:ibznotify-api}", contextId = "MsgBody", fallback = MsgBodyFallback.class)
public interface MsgBodyFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/msgbodies/select")
    Page<MsgBody> select();


    @RequestMapping(method = RequestMethod.POST, value = "/msgbodies")
    MsgBody create(@RequestBody MsgBody msgbody);

    @RequestMapping(method = RequestMethod.POST, value = "/msgbodies/batch")
    Boolean createBatch(@RequestBody List<MsgBody> msgbodies);


    @RequestMapping(method = RequestMethod.PUT, value = "/msgbodies/{msg_id}")
    MsgBody update(@PathVariable("msg_id") String msg_id,@RequestBody MsgBody msgbody);

    @RequestMapping(method = RequestMethod.PUT, value = "/msgbodies/batch")
    Boolean updateBatch(@RequestBody List<MsgBody> msgbodies);


    @RequestMapping(method = RequestMethod.DELETE, value = "/msgbodies/{msg_id}")
    Boolean remove(@PathVariable("msg_id") String msg_id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/msgbodies/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/msgbodies/{msg_id}")
    MsgBody get(@PathVariable("msg_id") String msg_id);


    @RequestMapping(method = RequestMethod.GET, value = "/msgbodies/getdraft")
    MsgBody getDraft(MsgBody entity);


    @RequestMapping(method = RequestMethod.POST, value = "/msgbodies/checkkey")
    Boolean checkKey(@RequestBody MsgBody msgbody);


    @RequestMapping(method = RequestMethod.POST, value = "/msgbodies/save")
    Boolean save(@RequestBody MsgBody msgbody);

    @RequestMapping(method = RequestMethod.POST, value = "/msgbodies/savebatch")
    Boolean saveBatch(@RequestBody List<MsgBody> msgbodies);



    @RequestMapping(method = RequestMethod.POST, value = "/msgbodies/searchdefault")
    Page<MsgBody> searchDefault(@RequestBody MsgBodySearchContext context);


}
