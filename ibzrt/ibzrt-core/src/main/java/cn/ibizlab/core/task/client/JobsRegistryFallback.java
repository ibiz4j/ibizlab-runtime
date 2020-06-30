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
import org.springframework.stereotype.Component;

/**
 * 实体[JobsRegistry] 服务对象接口
 */
@Component
public class JobsRegistryFallback implements JobsRegistryFeignClient{

    public Page<JobsRegistry> select(){
            return null;
     }

    public JobsRegistry create(JobsRegistry jobsregistry){
            return null;
     }
    public Boolean createBatch(List<JobsRegistry> jobsregistries){
            return false;
     }

    public JobsRegistry update(String id, JobsRegistry jobsregistry){
            return null;
     }
    public Boolean updateBatch(List<JobsRegistry> jobsregistries){
            return false;
     }


    public Boolean remove(String id){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public JobsRegistry get(String id){
            return null;
     }


    public JobsRegistry getDraft(){
            return null;
    }



    public Boolean checkKey(JobsRegistry jobsregistry){
            return false;
     }


    public Boolean save(JobsRegistry jobsregistry){
            return false;
     }
    public Boolean saveBatch(List<JobsRegistry> jobsregistries){
            return false;
     }

    public Page<JobsRegistry> searchDefault(JobsRegistrySearchContext context){
            return null;
     }


}
