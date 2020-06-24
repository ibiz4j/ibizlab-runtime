package cn.ibizlab.core.task.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.task.domain.JobsInfo;
import cn.ibizlab.core.task.filter.JobsInfoSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[JobsInfo] 服务对象接口
 */
@FeignClient(value = "ibztask-api", contextId = "JobsInfo", fallback = JobsInfoFallback.class)
public interface JobsInfoFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/jobsinfos/select")
    Page<JobsInfo> select();


    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/{id}/start")
    JobsInfo start(@PathVariable("id") String id,@RequestBody JobsInfo jobsinfo);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/save")
    Boolean save(@RequestBody JobsInfo jobsinfo);

    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/save")
    Boolean saveBatch(@RequestBody List<JobsInfo> jobsinfos);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos")
    JobsInfo create(@RequestBody JobsInfo jobsinfo);

    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/batch")
    Boolean createBatch(@RequestBody List<JobsInfo> jobsinfos);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/checkkey")
    Boolean checkKey(@RequestBody JobsInfo jobsinfo);


    @RequestMapping(method = RequestMethod.GET, value = "/jobsinfos/getdraft")
    JobsInfo getDraft();


    @RequestMapping(method = RequestMethod.PUT, value = "/jobsinfos/{id}")
    JobsInfo update(@PathVariable("id") String id,@RequestBody JobsInfo jobsinfo);

    @RequestMapping(method = RequestMethod.PUT, value = "/jobsinfos/batch")
    Boolean updateBatch(@RequestBody List<JobsInfo> jobsinfos);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/{id}/execute")
    JobsInfo execute(@PathVariable("id") String id,@RequestBody JobsInfo jobsinfo);


    @RequestMapping(method = RequestMethod.DELETE, value = "/jobsinfos/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/jobsinfos/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/{id}/stop")
    JobsInfo stop(@PathVariable("id") String id,@RequestBody JobsInfo jobsinfo);


    @RequestMapping(method = RequestMethod.GET, value = "/jobsinfos/{id}")
    JobsInfo get(@PathVariable("id") String id);



    @RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/searchdefault")
    Page<JobsInfo> searchDefault(@RequestBody JobsInfoSearchContext context);


}
