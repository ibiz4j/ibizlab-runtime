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
import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.filter.SysDeptMemberSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysDeptMember] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "SysDeptMember", fallback = SysDeptMemberFallback.class)
public interface SysDeptMemberFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers")
    SysDeptMember create(@RequestBody SysDeptMember sysdeptmember);

    @RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/batch")
    Boolean createBatch(@RequestBody List<SysDeptMember> sysdeptmembers);


    @RequestMapping(method = RequestMethod.GET, value = "/sysdeptmembers/{memberid}")
    SysDeptMember get(@PathVariable("memberid") String memberid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysdeptmembers/{memberid}")
    Boolean remove(@PathVariable("memberid") String memberid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysdeptmembers/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysdeptmembers/{memberid}")
    SysDeptMember update(@PathVariable("memberid") String memberid,@RequestBody SysDeptMember sysdeptmember);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysdeptmembers/batch")
    Boolean updateBatch(@RequestBody List<SysDeptMember> sysdeptmembers);


    @RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/checkkey")
    Boolean checkKey(@RequestBody SysDeptMember sysdeptmember);



    @RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/searchdefault")
    Page<SysDeptMember> searchDefault(@RequestBody SysDeptMemberSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/sysdeptmembers/getdraft")
    SysDeptMember getDraft(SysDeptMember entity);


    @RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/save")
    Object saveEntity(@RequestBody SysDeptMember sysdeptmember);

    default Boolean save(@RequestBody SysDeptMember sysdeptmember) { return saveEntity(sysdeptmember)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/savebatch")
    Boolean saveBatch(@RequestBody List<SysDeptMember> sysdeptmembers);


    @RequestMapping(method = RequestMethod.GET, value = "/sysdeptmembers/select")
    Page<SysDeptMember> select();


}
