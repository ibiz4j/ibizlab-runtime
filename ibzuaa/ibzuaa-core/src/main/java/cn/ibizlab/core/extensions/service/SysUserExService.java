package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.uaa.service.impl.SysUserServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SysUserExService extends SysUserServiceImpl {
    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }
}
