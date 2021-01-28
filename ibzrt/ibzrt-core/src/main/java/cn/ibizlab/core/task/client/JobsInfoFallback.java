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
import org.springframework.stereotype.Component;

/**
 * 实体[JobsInfo] 服务对象接口
 */
@Component
public class JobsInfoFallback implements JobsInfoFeignClient {

    public Page<JobsInfo> select() {
        return null;
    }

    public JobsInfo create(JobsInfo jobsinfo) {
        return null;
    }
    public Boolean createBatch(List<JobsInfo> jobsinfos) {
        return false;
    }

    public JobsInfo update(String id, JobsInfo jobsinfo) {
        return null;
    }
    public Boolean updateBatch(List<JobsInfo> jobsinfos) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public JobsInfo get(String id) {
        return null;
    }


    public JobsInfo getDraft(JobsInfo entity){
        return null;
    }



    public Boolean checkKey(JobsInfo jobsinfo) {
        return false;
    }


    public JobsInfo execute( String id, JobsInfo jobsinfo) {
        return null;
    }

    public Boolean save(JobsInfo jobsinfo) {
        return false;
    }
    public Boolean saveBatch(List<JobsInfo> jobsinfos) {
        return false;
    }

    public JobsInfo start( String id, JobsInfo jobsinfo) {
        return null;
    }

    public JobsInfo stop( String id, JobsInfo jobsinfo) {
        return null;
    }

    public Page<JobsInfo> searchDefault(JobsInfoSearchContext context) {
        return null;
    }


}
