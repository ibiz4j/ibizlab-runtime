package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.disk.service.impl.MetaDynamicModelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import java.util.*;

/**
 * 实体[动态模型] 自定义服务对象
 */
@Slf4j
@Primary
@Service("MetaDynamicModelExService")
public class MetaDynamicModelExService extends MetaDynamicModelServiceImpl {


    /**
     * [Init:初始化副本实例] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public MetaDynamicModel init(MetaDynamicModel et) {
        return super.init(et);
    }
    /**
     * [Publish:发布模型] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public MetaDynamicModel publish(MetaDynamicModel et) {
        return super.publish(et);
    }
}

