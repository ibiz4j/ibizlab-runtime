package cn.ibizlab.core.ou.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.ou.domain.SysTeamMember;
import cn.ibizlab.core.ou.filter.SysTeamMemberSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysTeamMember] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "SysTeamMember", fallback = SysTeamMemberFallback.class)
public interface SysTeamMemberFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/systeammembers/select")
    Page<SysTeamMember> select();


    @RequestMapping(method = RequestMethod.POST, value = "/systeammembers")
    SysTeamMember create(@RequestBody SysTeamMember systeammember);

    @RequestMapping(method = RequestMethod.POST, value = "/systeammembers/batch")
    Boolean createBatch(@RequestBody List<SysTeamMember> systeammembers);


    @RequestMapping(method = RequestMethod.PUT, value = "/systeammembers/{teammemberid}")
    SysTeamMember update(@PathVariable("teammemberid") String teammemberid,@RequestBody SysTeamMember systeammember);

    @RequestMapping(method = RequestMethod.PUT, value = "/systeammembers/batch")
    Boolean updateBatch(@RequestBody List<SysTeamMember> systeammembers);


    @RequestMapping(method = RequestMethod.DELETE, value = "/systeammembers/{teammemberid}")
    Boolean remove(@PathVariable("teammemberid") String teammemberid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/systeammembers/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/systeammembers/{teammemberid}")
    SysTeamMember get(@PathVariable("teammemberid") String teammemberid);


    @RequestMapping(method = RequestMethod.GET, value = "/systeammembers/getdraft")
    SysTeamMember getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/systeammembers/checkkey")
    Boolean checkKey(@RequestBody SysTeamMember systeammember);


    @RequestMapping(method = RequestMethod.POST, value = "/systeammembers/save")
    Boolean save(@RequestBody SysTeamMember systeammember);

    @RequestMapping(method = RequestMethod.POST, value = "/systeammembers/save")
    Boolean saveBatch(@RequestBody List<SysTeamMember> systeammembers);



    @RequestMapping(method = RequestMethod.POST, value = "/systeammembers/searchdefault")
    Page<SysTeamMember> searchDefault(@RequestBody SysTeamMemberSearchContext context);


}
