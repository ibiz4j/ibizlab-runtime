package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.task.service.impl.JobsInfoServiceImpl;
import cn.ibizlab.util.errors.BadRequestAlertException;
import com.baomidou.jobs.service.JobsHelper;
import com.baomidou.jobs.trigger.JobsTrigger;
import com.baomidou.jobs.trigger.TriggerTypeEnum;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.task.domain.JobsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import java.util.*;

/**
 * 实体[任务信息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("JobsInfoExService")
public class JobsInfoExService extends JobsInfoServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[Execute]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public JobsInfo execute(JobsInfo et) {
        if(et.getId()==null)
            throw new BadRequestAlertException("未找到任务","JobsInfo","");
        JobsInfo dbJobInfo = getById(et.getId());
        if (null == dbJobInfo) {
            throw new BadRequestAlertException("未找到任务","JobsInfo","");
        }
        JobsTrigger.trigger(Long.parseLong(et.getId()), TriggerTypeEnum.MANUAL, -1, dbJobInfo.getParam());
        return super.execute(et);
    }

    @Override
    public JobsInfo start(JobsInfo et) {
        JobsInfo dbJobInfo = getById(et.getId());
        if (null == dbJobInfo) {
            throw new BadRequestAlertException("未找到任务","JobsInfo","");
        }

        et.setStatus(0);
        et.setLastTime(0L);
        if(!JobsHelper.cronValidate(dbJobInfo.getCron()))
            throw new BadRequestAlertException("CRON 表达式不可用","JobsInfo",dbJobInfo.getCron());

        // next trigger time (10s后生效，避开预读周期)
        et.setNextTime(JobsHelper.cronNextTime(dbJobInfo.getCron()) + 10000);
        this.update(et);
        return  et;
    }
}
