package cn.ibizlab.core.task.service.impl;


import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.core.task.domain.JobsRegistry;
import cn.ibizlab.core.task.service.IJobsInfoService;
import cn.ibizlab.core.task.service.IJobsLockService;
import cn.ibizlab.core.task.service.IJobsLogService;
import cn.ibizlab.core.task.service.IJobsRegistryService;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DataObject;
import com.baomidou.jobs.JobsClock;
import com.baomidou.jobs.model.JobsInfo;
import com.baomidou.jobs.model.JobsLog;
import com.baomidou.jobs.model.param.RegistryParam;
import com.baomidou.jobs.service.IJobsService;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Jobs Admin Impl
 *
 * @author jobob
 * @since 2019-07-12
 */
@Slf4j
@Service
public class JobsServiceImpl implements IJobsService {
    @Autowired
    private IJobsRegistryService jobsRegistryService;
    @Autowired
    private IJobsLockService jobsLockService;
    @Autowired
    private IJobsInfoService jobsInfoService;
    @Autowired
    public IJobsLogService jobsLogService;

    @Override
    public boolean registry(RegistryParam registryParam) {
        JobsRegistry jobsRegistry = new JobsRegistry();

        jobsRegistry.setApp(registryParam.getApp());
        jobsRegistry.setAddress(registryParam.getAddress());
        jobsRegistry.setStatus(registryParam.getRegisterStatusEnum().getValue());
        jobsRegistry.setUpdateTime(new Timestamp(JobsClock.currentTimeMillis()));

        int ret = jobsRegistryService.getBaseMapper().update(jobsRegistry,
                Wrappers.<JobsRegistry>lambdaQuery().eq(JobsRegistry::getApp, registryParam.getApp())
                        .eq(JobsRegistry::getAddress, registryParam.getAddress()));
        if (ret < 1) {
            ret = jobsRegistryService.getBaseMapper().insert(jobsRegistry);
        }
        return ret > 0;

    }

    @Override
    public List<JobsInfo> getJobsInfoList(long nextTime) {
        List<cn.ibizlab.core.task.domain.JobsInfo> list = jobsInfoService.list(Wrappers.<cn.ibizlab.core.task.domain.JobsInfo>lambdaQuery()
                .eq(cn.ibizlab.core.task.domain.JobsInfo::getStatus, 0)
                .le(cn.ibizlab.core.task.domain.JobsInfo::getNextTime, nextTime));
        List<JobsInfo> ret = new ArrayList<>();
        list.forEach(obj->ret.add(change(obj)));
        return ret;
    }

    @Override
    public JobsInfo getJobsInfoById(Long id) {
        return change(jobsInfoService.getById(id));
    }

    @Override
    public boolean updateJobsInfoById(JobsInfo jobsInfo) {
        return jobsInfoService.updateById(change(jobsInfo));
    }

    @Override
    @Transactional
    public boolean tryLock(String name, String owner) {
        JobsLock lock = new JobsLock();
        lock.setName(name);
        lock.setOwner(owner);
        lock.setCreateTime(new Timestamp(JobsClock.currentTimeMillis()));
        return jobsLockService.getBaseMapper().insert(lock)>0;
    }

    @Override
    @Transactional
    public boolean unlock(String name, String owner) {
        jobsLockService.getBaseMapper().delete(Wrappers.<JobsLock>lambdaQuery().eq(JobsLock::getName, name)
                .eq(null != owner, JobsLock::getOwner, owner));
        return true;
    }

    @Override
    public int removeTimeOutApp(int timeout) {
        JobsRegistry jobsRegistry = new JobsRegistry();
        jobsRegistry.setStatus(1);
        if(jobsRegistryService.update(jobsRegistry, Wrappers.<JobsRegistry>lambdaQuery()
                .eq(JobsRegistry::getStatus, 0).le(JobsRegistry::getUpdateTime, new Timestamp(JobsClock.currentTimeMillis() - timeout))))
            return 1;
        return 0;
    }

    @Override
    public boolean removeApp(RegistryParam registryParam) {
        JobsRegistry jobsRegistry = new JobsRegistry();
        jobsRegistry.setApp(registryParam.getApp());
        jobsRegistry.setAddress(registryParam.getAddress());
        jobsRegistry.setStatus(registryParam.getRegisterStatusEnum().getValue());

        return jobsRegistryService.getBaseMapper().update(jobsRegistry,Wrappers.<JobsRegistry>lambdaQuery().eq(JobsRegistry::getApp, registryParam.getApp())
                .eq(JobsRegistry::getAddress, registryParam.getAddress()))>0;
    }

    @Override
    public List<String> getAppAddressList(String app) {
        List<JobsRegistry> jobsRegistryList = jobsRegistryService.list(Wrappers.<JobsRegistry>lambdaQuery()
                .eq(JobsRegistry::getApp, app).eq(JobsRegistry::getStatus, 0));
        return CollectionUtils.isEmpty(jobsRegistryList) ? null : jobsRegistryList.stream()
                .map(j -> j.getAddress()).collect(Collectors.toList());
    }

    @Override
    public boolean saveOrUpdateLogById(JobsLog jobsLog) {
        if (null == jobsLog) {
            return false;
        }
        if(jobsLog.getId()==null)
            return jobsLogService.getBaseMapper().insert(change(jobsLog))>0;
        else
            return jobsLogService.getBaseMapper().updateById(change(jobsLog))>0;
    }

    private JobsInfo change(cn.ibizlab.core.task.domain.JobsInfo et)
    {
        if(et == null)
            return null;
        JobsInfo jobsInfo = new JobsInfo();
        jobsInfo.setApp(et.getApp());
        jobsInfo.setAuthor(et.getAuthor());
        jobsInfo.setCron(et.getCron());
        jobsInfo.setFailRetryCount(et.getFailRetryCount());
        jobsInfo.setHandler(et.getHandler());
        jobsInfo.setParam(et.getParam());
        jobsInfo.setRemark(et.getRemark());
        jobsInfo.setStatus(et.getStatus());
        jobsInfo.setTenantId(et.getTenantId());
        jobsInfo.setTimeout(et.getTimeout());
        if(et.getId()!=null)
            jobsInfo.setId(DataObject.getLongValue(et.getId(),et.getCreateTime().getTime()));
        if(et.getLastTime()!=null)
            jobsInfo.setLastTime(et.getLastTime());
        if(et.getNextTime()!=null)
            jobsInfo.setNextTime(et.getNextTime());
        if(et.getCreateTime()!=null)
            jobsInfo.setCreateTime(et.getCreateTime().getTime());
        if(et.getUpdateTime()!=null)
            jobsInfo.setUpdateTime(et.getUpdateTime().getTime());
        return jobsInfo;
    }

    private cn.ibizlab.core.task.domain.JobsInfo change(JobsInfo et)
    {
        if(et == null)
            return null;
        cn.ibizlab.core.task.domain.JobsInfo jobsInfo = new cn.ibizlab.core.task.domain.JobsInfo();
        jobsInfo.setApp(et.getApp());
        jobsInfo.setAuthor(et.getAuthor());
        jobsInfo.setCron(et.getCron());
        jobsInfo.setFailRetryCount(et.getFailRetryCount());
        jobsInfo.setHandler(et.getHandler());
        jobsInfo.setParam(et.getParam());
        jobsInfo.setRemark(et.getRemark());
        jobsInfo.setStatus(et.getStatus());
        jobsInfo.setTenantId(et.getTenantId());
        jobsInfo.setTimeout(et.getTimeout());
        if(et.getId()!=null)
            jobsInfo.setId(et.getId()+"");
        if(et.getLastTime()!=null)
            jobsInfo.setLastTime(et.getLastTime());
        if(et.getNextTime()!=null)
            jobsInfo.setNextTime(et.getNextTime());
        if(et.getCreateTime()!=null)
            jobsInfo.setCreateTime(new Timestamp(et.getCreateTime()));
        if(et.getUpdateTime()!=null)
            jobsInfo.setUpdateTime(new Timestamp(et.getUpdateTime()));
        return jobsInfo;
    }


    private cn.ibizlab.core.task.domain.JobsLog change(JobsLog et)
    {
        if(et == null)
            return null;
        cn.ibizlab.core.task.domain.JobsLog jobsLog = new cn.ibizlab.core.task.domain.JobsLog();
        jobsLog.setAddress(et.getAddress());
        jobsLog.setFailRetryCount(et.getFailRetryCount());
        jobsLog.setHandler(et.getHandler());
        jobsLog.setParam(et.getParam());
        jobsLog.setTriggerCode(et.getTriggerCode());
        jobsLog.setTriggerMsg(et.getTriggerMsg());
        jobsLog.setTriggerType(et.getTriggerType());
        if(et.getId()!=null)
            jobsLog.setId(et.getId()+"");
        if(et.getCreateTime()!=null)
            jobsLog.setCreateTime(new Timestamp(et.getCreateTime()));
        if(et.getJobId()!=null)
            jobsLog.setJobId(et.getJobId()+"");
        return jobsLog;
    }
}
