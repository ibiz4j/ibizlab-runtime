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
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[MsgTemplate] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibznotify-api:ibznotify-api}", contextId = "MsgTemplate", fallback = MsgTemplateFallback.class)
public interface MsgTemplateFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/select")
    Page<MsgTemplate> select();


    @RequestMapping(method = RequestMethod.POST, value = "/msgtemplates")
    MsgTemplate create(@RequestBody MsgTemplate msgtemplate);

    @RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/batch")
    Boolean createBatch(@RequestBody List<MsgTemplate> msgtemplates);


    @RequestMapping(method = RequestMethod.PUT, value = "/msgtemplates/{tid}")
    MsgTemplate update(@PathVariable("tid") String tid,@RequestBody MsgTemplate msgtemplate);

    @RequestMapping(method = RequestMethod.PUT, value = "/msgtemplates/batch")
    Boolean updateBatch(@RequestBody List<MsgTemplate> msgtemplates);


    @RequestMapping(method = RequestMethod.DELETE, value = "/msgtemplates/{tid}")
    Boolean remove(@PathVariable("tid") String tid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/msgtemplates/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/{tid}")
    MsgTemplate get(@PathVariable("tid") String tid);


    @RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/getdraft")
    MsgTemplate getDraft(MsgTemplate entity);


    @RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/checkkey")
    Boolean checkKey(@RequestBody MsgTemplate msgtemplate);


    @RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/save")
    Object saveEntity(@RequestBody MsgTemplate msgtemplate);

    default Boolean save(@RequestBody MsgTemplate msgtemplate) { return saveEntity(msgtemplate)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/savebatch")
    Boolean saveBatch(@RequestBody List<MsgTemplate> msgtemplates);



    @RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/searchdefault")
    Page<MsgTemplate> searchDefault(@RequestBody MsgTemplateSearchContext context);


}
