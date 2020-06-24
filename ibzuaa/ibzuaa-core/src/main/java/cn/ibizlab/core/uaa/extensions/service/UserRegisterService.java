package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.service.IBZUSERService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实体[IBZUSER] 用户注册接口实现
 */
@Service
@Slf4j
public class UserRegisterService {

    @Autowired
    private IBZUSERService ibzuserService;


    /**
     * 注册
     *
     * @param ibzuser
     * @return
     */
    public IBZUSER toRegister(IBZUSER ibzuser) {
        // 创建ibzuser
        boolean flag = ibzuserService.save(ibzuser);
        if (!flag) {
            return null;
        }
        return ibzuser;
    }

}