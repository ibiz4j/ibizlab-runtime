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
import org.springframework.stereotype.Component;

/**
 * 实体[JobsLog] 服务对象接口
 */
@Component
public class JobsLogFallback implements JobsLogFeignClient {

    public JobsLog create(JobsLog jobslog) {
        return null;
    }
    public Boolean createBatch(List<JobsLog> jobslogs) {
        return false;
    }

    public JobsLog get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public JobsLog update(String id, JobsLog jobslog) {
        return null;
    }
    public Boolean updateBatch(List<JobsLog> jobslogs) {
        return false;
    }


    public Boolean checkKey(JobsLog jobslog) {
        return false;
    }


    public Page<JobsLog> searchDefault(JobsLogSearchContext context) {
        return null;
    }


    public JobsLog getDraft(JobsLog entity){
        return null;
    }



    public Object saveEntity(JobsLog jobslog) {
        return null;
    }

    public Boolean save(JobsLog jobslog) {
        return false;
    }
    public Boolean saveBatch(List<JobsLog> jobslogs) {
        return false;
    }

    public Page<JobsLog> select() {
        return null;
    }

}
