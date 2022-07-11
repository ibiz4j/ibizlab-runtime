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
import org.springframework.stereotype.Component;

/**
 * 实体[JobsLock] 服务对象接口
 */
@Component
public class JobsLockFallback implements JobsLockFeignClient {

    public JobsLock create(JobsLock jobslock) {
        return null;
    }
    public Boolean createBatch(List<JobsLock> jobslocks) {
        return false;
    }

    public JobsLock get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public JobsLock update(String id, JobsLock jobslock) {
        return null;
    }
    public Boolean updateBatch(List<JobsLock> jobslocks) {
        return false;
    }


    public Boolean checkKey(JobsLock jobslock) {
        return false;
    }


    public Page<JobsLock> searchDefault(JobsLockSearchContext context) {
        return null;
    }


    public JobsLock getDraft(JobsLock entity){
        return null;
    }



    public Object saveEntity(JobsLock jobslock) {
        return null;
    }

    public Boolean save(JobsLock jobslock) {
        return false;
    }
    public Boolean saveBatch(List<JobsLock> jobslocks) {
        return false;
    }

    public Page<JobsLock> select() {
        return null;
    }

}
