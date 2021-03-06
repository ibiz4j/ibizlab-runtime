package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.task.service.impl.JobsInfoServiceImpl;
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


    /**
     * [Execute:执行] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public JobsInfo execute(JobsInfo et) {
        return super.execute(et);
    }
}

