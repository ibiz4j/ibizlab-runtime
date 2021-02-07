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
import cn.ibizlab.core.task.domain.JobsRegistry;
import cn.ibizlab.core.task.filter.JobsRegistrySearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[JobsRegistry] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibztask-api:ibztask-api}", contextId = "JobsRegistry", fallback = JobsRegistryFallback.class)
public interface JobsRegistryFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/jobsregistries/select")
    Page<JobsRegistry> select();


    @RequestMapping(method = RequestMethod.POST, value = "/jobsregistries")
    JobsRegistry create(@RequestBody JobsRegistry jobsregistry);

    @RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/batch")
    Boolean createBatch(@RequestBody List<JobsRegistry> jobsregistries);


    @RequestMapping(method = RequestMethod.PUT, value = "/jobsregistries/{id}")
    JobsRegistry update(@PathVariable("id") String id,@RequestBody JobsRegistry jobsregistry);

    @RequestMapping(method = RequestMethod.PUT, value = "/jobsregistries/batch")
    Boolean updateBatch(@RequestBody List<JobsRegistry> jobsregistries);


    @RequestMapping(method = RequestMethod.DELETE, value = "/jobsregistries/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/jobsregistries/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/jobsregistries/{id}")
    JobsRegistry get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/jobsregistries/getdraft")
    JobsRegistry getDraft(JobsRegistry entity);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/checkkey")
    Boolean checkKey(@RequestBody JobsRegistry jobsregistry);


    @RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/save")
    Object saveEntity(@RequestBody JobsRegistry jobsregistry);

    default Boolean save(@RequestBody JobsRegistry jobsregistry) { return saveEntity(jobsregistry)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/savebatch")
    Boolean saveBatch(@RequestBody List<JobsRegistry> jobsregistries);



    @RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/searchdefault")
    Page<JobsRegistry> searchDefault(@RequestBody JobsRegistrySearchContext context);


}
