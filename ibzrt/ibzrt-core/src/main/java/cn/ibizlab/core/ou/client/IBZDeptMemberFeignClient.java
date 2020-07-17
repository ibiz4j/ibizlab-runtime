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
import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZDeptMember] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "IBZDeptMember", fallback = IBZDeptMemberFallback.class)
public interface IBZDeptMemberFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzdeptmembers/select")
    Page<IBZDeptMember> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers")
    IBZDeptMember create(@RequestBody IBZDeptMember ibzdeptmember);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/batch")
    Boolean createBatch(@RequestBody List<IBZDeptMember> ibzdeptmembers);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdeptmembers/{memberid}")
    IBZDeptMember update(@PathVariable("memberid") String memberid,@RequestBody IBZDeptMember ibzdeptmember);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdeptmembers/batch")
    Boolean updateBatch(@RequestBody List<IBZDeptMember> ibzdeptmembers);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdeptmembers/{memberid}")
    Boolean remove(@PathVariable("memberid") String memberid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdeptmembers/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdeptmembers/{memberid}")
    IBZDeptMember get(@PathVariable("memberid") String memberid);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdeptmembers/getdraft")
    IBZDeptMember getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/checkkey")
    Boolean checkKey(@RequestBody IBZDeptMember ibzdeptmember);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/save")
    Boolean save(@RequestBody IBZDeptMember ibzdeptmember);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/save")
    Boolean saveBatch(@RequestBody List<IBZDeptMember> ibzdeptmembers);



    @RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/searchdefault")
    Page<IBZDeptMember> searchDefault(@RequestBody IBZDeptMemberSearchContext context);


}
