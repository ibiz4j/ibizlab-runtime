package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.ou.service.impl.SysEmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.ou.domain.SysEmployee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import java.util.*;

/**
 * 实体[人员] 自定义服务对象
 */
@Slf4j
@Primary
@Service("SysEmployeeExService")
public class SysEmployeeExService extends SysEmployeeServiceImpl {


    /**
     * 自定义行为[InitPwd]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public SysEmployee initPwd(SysEmployee et) {
        return super.initPwd(et);
    }
}

