package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.disk.service.impl.META_DYNAMICMODELServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import java.util.*;

/**
 * 实体[动态模型] 自定义服务对象
 */
@Slf4j
@Primary
@Service("META_DYNAMICMODELExService")
public class META_DYNAMICMODELExService extends META_DYNAMICMODELServiceImpl {


    /**
     * [Init:初始化副本实例] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public META_DYNAMICMODEL init(META_DYNAMICMODEL et) {
        return super.init(et);
    }
    /**
     * [Publish:发布模型] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public META_DYNAMICMODEL publish(META_DYNAMICMODEL et) {
        return super.publish(et);
    }
}

