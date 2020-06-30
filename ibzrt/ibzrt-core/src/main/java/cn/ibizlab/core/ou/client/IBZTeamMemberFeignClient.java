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
import cn.ibizlab.core.ou.domain.IBZTeamMember;
import cn.ibizlab.core.ou.filter.IBZTeamMemberSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZTeamMember] 服务对象接口
 */
@FeignClient(value = "ibzou-api", contextId = "IBZTeamMember", fallback = IBZTeamMemberFallback.class)
public interface IBZTeamMemberFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzteammembers/select")
    Page<IBZTeamMember> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers")
    IBZTeamMember create(@RequestBody IBZTeamMember ibzteammember);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/batch")
    Boolean createBatch(@RequestBody List<IBZTeamMember> ibzteammembers);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzteammembers/{teammemberid}")
    IBZTeamMember update(@PathVariable("teammemberid") String teammemberid,@RequestBody IBZTeamMember ibzteammember);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzteammembers/batch")
    Boolean updateBatch(@RequestBody List<IBZTeamMember> ibzteammembers);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzteammembers/{teammemberid}")
    Boolean remove(@PathVariable("teammemberid") String teammemberid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzteammembers/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzteammembers/{teammemberid}")
    IBZTeamMember get(@PathVariable("teammemberid") String teammemberid);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzteammembers/getdraft")
    IBZTeamMember getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/checkkey")
    Boolean checkKey(@RequestBody IBZTeamMember ibzteammember);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/save")
    Boolean save(@RequestBody IBZTeamMember ibzteammember);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/save")
    Boolean saveBatch(@RequestBody List<IBZTeamMember> ibzteammembers);



    @RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/searchdefault")
    Page<IBZTeamMember> searchDefault(@RequestBody IBZTeamMemberSearchContext context);


}
