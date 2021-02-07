package cn.ibizlab.core.workflow.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.workflow.domain.WFMember;
import cn.ibizlab.core.workflow.filter.WFMemberSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[WFMember] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzwf-api:ibzwf-api}", contextId = "WFMember", fallback = WFMemberFallback.class)
public interface WFMemberFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/wfmembers/select")
    Page<WFMember> select();


    @RequestMapping(method = RequestMethod.POST, value = "/wfmembers")
    WFMember create(@RequestBody WFMember wfmember);

    @RequestMapping(method = RequestMethod.POST, value = "/wfmembers/batch")
    Boolean createBatch(@RequestBody List<WFMember> wfmembers);


    @RequestMapping(method = RequestMethod.PUT, value = "/wfmembers/{memberid}")
    WFMember update(@PathVariable("memberid") String memberid,@RequestBody WFMember wfmember);

    @RequestMapping(method = RequestMethod.PUT, value = "/wfmembers/batch")
    Boolean updateBatch(@RequestBody List<WFMember> wfmembers);


    @RequestMapping(method = RequestMethod.DELETE, value = "/wfmembers/{memberid}")
    Boolean remove(@PathVariable("memberid") String memberid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/wfmembers/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/wfmembers/{memberid}")
    WFMember get(@PathVariable("memberid") String memberid);


    @RequestMapping(method = RequestMethod.GET, value = "/wfmembers/getdraft")
    WFMember getDraft(WFMember entity);


    @RequestMapping(method = RequestMethod.POST, value = "/wfmembers/checkkey")
    Boolean checkKey(@RequestBody WFMember wfmember);


    @RequestMapping(method = RequestMethod.POST, value = "/wfmembers/save")
    Object saveEntity(@RequestBody WFMember wfmember);

    default Boolean save(@RequestBody WFMember wfmember) { return saveEntity(wfmember)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/wfmembers/savebatch")
    Boolean saveBatch(@RequestBody List<WFMember> wfmembers);



    @RequestMapping(method = RequestMethod.POST, value = "/wfmembers/searchdefault")
    Page<WFMember> searchDefault(@RequestBody WFMemberSearchContext context);


}
