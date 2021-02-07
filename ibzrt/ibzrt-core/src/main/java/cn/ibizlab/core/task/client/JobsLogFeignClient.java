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
import cn.ibizlab.core.task.domain.JobsLog;
import cn.ibizlab.core.task.filter.JobsLogSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[JobsLog] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibztask-api:ibztask-api}", contextId = "JobsLog", fallback = JobsLogFallback.class)
public interface JobsLogFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/jobslogs/select")
    Page<JobsLog> select();


    @RequestMapping(method = RequestMethod.POST, value = "/jobslogs")
    JobsLog create(@RequestBody JobsLog jobslog);

    @RequestMapping(method = RequestMethod.POST, value = "/jobslogs/batch")
    Boolean createBatch(@RequestBody List<JobsLog> jobslogs);


    @RequestMapping(method = RequestMethod.PUT, value = "/jobslogs/{id}")
    JobsLog update(@PathVariable("id") String id,@RequestBody JobsLog jobslog);

    @RequestMapping(method = RequestMethod.PUT, value = "/jobslogs/batch")
    Boolean updateBatch(@RequestBody List<JobsLog> jobslogs);


    @RequestMapping(method = RequestMethod.DELETE, value = "/jobslogs/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/jobslogs/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/jobslogs/{id}")
    JobsLog get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/jobslogs/getdraft")
    JobsLog getDraft(JobsLog entity);


    @RequestMapping(method = RequestMethod.POST, value = "/jobslogs/checkkey")
    Boolean checkKey(@RequestBody JobsLog jobslog);


    @RequestMapping(method = RequestMethod.POST, value = "/jobslogs/save")
    Object saveEntity(@RequestBody JobsLog jobslog);

    default Boolean save(@RequestBody JobsLog jobslog) { return saveEntity(jobslog)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/jobslogs/savebatch")
    Boolean saveBatch(@RequestBody List<JobsLog> jobslogs);



    @RequestMapping(method = RequestMethod.POST, value = "/jobslogs/searchdefault")
    Page<JobsLog> searchDefault(@RequestBody JobsLogSearchContext context);


}
