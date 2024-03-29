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
import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.core.task.filter.JobsLockSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[JobsLock] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibztask-api:ibztask-api}", contextId = "JobsLock", fallback = JobsLockFallback.class)
public interface JobsLockFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/jobslocks")
    JobsLock create(@RequestBody JobsLock jobslock);

    @RequestMapping(method = RequestMethod.POST, value = "/jobslocks/batch")
    Boolean createBatch(@RequestBody List<JobsLock> jobslocks);


    @RequestMapping(method = RequestMethod.GET, value = "/jobslocks/{id}")
    JobsLock get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.DELETE, value = "/jobslocks/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/jobslocks/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/jobslocks/{id}")
    JobsLock update(@PathVariable("id") String id,@RequestBody JobsLock jobslock);

    @RequestMapping(method = RequestMethod.PUT, value = "/jobslocks/batch")
    Boolean updateBatch(@RequestBody List<JobsLock> jobslocks);


    @RequestMapping(method = RequestMethod.POST, value = "/jobslocks/checkkey")
    Boolean checkKey(@RequestBody JobsLock jobslock);



    @RequestMapping(method = RequestMethod.POST, value = "/jobslocks/searchdefault")
    Page<JobsLock> searchDefault(@RequestBody JobsLockSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/jobslocks/getdraft")
    JobsLock getDraft(JobsLock entity);


    @RequestMapping(method = RequestMethod.POST, value = "/jobslocks/save")
    Object saveEntity(@RequestBody JobsLock jobslock);

    default Boolean save(@RequestBody JobsLock jobslock) { return saveEntity(jobslock)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/jobslocks/savebatch")
    Boolean saveBatch(@RequestBody List<JobsLock> jobslocks);


    @RequestMapping(method = RequestMethod.GET, value = "/jobslocks/select")
    Page<JobsLock> select();


}
