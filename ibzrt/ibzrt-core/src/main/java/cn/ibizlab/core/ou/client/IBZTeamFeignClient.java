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
import cn.ibizlab.core.ou.domain.IBZTeam;
import cn.ibizlab.core.ou.filter.IBZTeamSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZTeam] 服务对象接口
 */
@FeignClient(value = "ibzou-api", contextId = "IBZTeam", fallback = IBZTeamFallback.class)
public interface IBZTeamFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzteams/select")
    Page<IBZTeam> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzteams/checkkey")
    Boolean checkKey(@RequestBody IBZTeam ibzteam);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzteams")
    IBZTeam create(@RequestBody IBZTeam ibzteam);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzteams/batch")
    Boolean createBatch(@RequestBody List<IBZTeam> ibzteams);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzteams/{teamid}")
    IBZTeam update(@PathVariable("teamid") String teamid,@RequestBody IBZTeam ibzteam);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzteams/batch")
    Boolean updateBatch(@RequestBody List<IBZTeam> ibzteams);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzteams/{teamid}")
    Boolean remove(@PathVariable("teamid") String teamid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzteams/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzteams/{teamid}")
    IBZTeam get(@PathVariable("teamid") String teamid);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzteams/save")
    Boolean save(@RequestBody IBZTeam ibzteam);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzteams/save")
    Boolean saveBatch(@RequestBody List<IBZTeam> ibzteams);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzteams/getdraft")
    IBZTeam getDraft();



    @RequestMapping(method = RequestMethod.POST, value = "/ibzteams/searchdefault")
    Page<IBZTeam> searchDefault(@RequestBody IBZTeamSearchContext context);


}
