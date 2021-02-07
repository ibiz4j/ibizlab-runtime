package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.notify.service.impl.MsgBodyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.notify.domain.MsgBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import java.util.*;

/**
 * 实体[消息] 自定义服务对象
 */
@Slf4j
@Primary
@Service("MsgBodyExService")
public class MsgBodyExService extends MsgBodyServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }
}

