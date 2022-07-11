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
import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.core.notify.filter.MsgUserAccountSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[MsgUserAccount] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibznotify-api:ibznotify-api}", contextId = "MsgUserAccount", fallback = MsgUserAccountFallback.class)
public interface MsgUserAccountFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts")
    MsgUserAccount create(@RequestBody MsgUserAccount msguseraccount);

    @RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/batch")
    Boolean createBatch(@RequestBody List<MsgUserAccount> msguseraccounts);


    @RequestMapping(method = RequestMethod.GET, value = "/msguseraccounts/{id}")
    MsgUserAccount get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.DELETE, value = "/msguseraccounts/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/msguseraccounts/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/msguseraccounts/{id}")
    MsgUserAccount update(@PathVariable("id") String id,@RequestBody MsgUserAccount msguseraccount);

    @RequestMapping(method = RequestMethod.PUT, value = "/msguseraccounts/batch")
    Boolean updateBatch(@RequestBody List<MsgUserAccount> msguseraccounts);


    @RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/checkkey")
    Boolean checkKey(@RequestBody MsgUserAccount msguseraccount);



    @RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/searchdefault")
    Page<MsgUserAccount> searchDefault(@RequestBody MsgUserAccountSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/msguseraccounts/getdraft")
    MsgUserAccount getDraft(MsgUserAccount entity);


    @RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/save")
    Object saveEntity(@RequestBody MsgUserAccount msguseraccount);

    default Boolean save(@RequestBody MsgUserAccount msguseraccount) { return saveEntity(msguseraccount)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/savebatch")
    Boolean saveBatch(@RequestBody List<MsgUserAccount> msguseraccounts);


    @RequestMapping(method = RequestMethod.GET, value = "/msguseraccounts/select")
    Page<MsgUserAccount> select();


}
