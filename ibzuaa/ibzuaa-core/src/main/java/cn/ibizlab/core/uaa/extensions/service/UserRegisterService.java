package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.util.errors.BadRequestAlertException;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * 实体[IBZUSER] 用户注册接口实现
 */
@Service
@Slf4j
public class UserRegisterService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserAuthService sysUserAuthService;

    @Value("${ibiz.auth.pwencrymode:0}")
    private int pwencrymode;


    public SysUser toRegister(SysUser account)
    {
        return toRegister(account,null);
    }

    public SysUser toRegister(SysUser account, SysUserAuth sysUserAuth) {

        String domains = account.getDomains();
        String loginname = account.getLoginname();
        String personname = account.getPersonname();
        String password = account.getPassword();
        String phone = account.getPhone();
        String email = account.getEmail();
        if (StringUtils.isEmpty(loginname))
            throw new BadRequestAlertException("用户名为空", "UserRegisterResource", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "UserRegisterResource", "");

        if(sysUserAuth!=null)
        {
            if(StringUtils.isEmpty(sysUserAuth.getIdentityType()))
                throw new BadRequestAlertException("第三方平台类型为空", "UserRegisterResource", "");
            if(StringUtils.isEmpty(sysUserAuth.getIdentifier()))
                throw new BadRequestAlertException("第三方平台用户标识为空", "UserRegisterResource", "");
        }
        else if(StringUtils.isEmpty(personname))
            throw new BadRequestAlertException("用户名称为空", "UserRegisterResource", "");

        String username = loginname+(StringUtils.isEmpty(domains)?"":("|"+domains));

        SysUser existedUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getLoginname,loginname)
                .eq((!StringUtils.isEmpty(domains)),SysUser::getDomains,domains),false);


        if(existedUser!=null)
        {
            if(sysUserAuth==null)
                throw new BadRequestAlertException("该用户名"+(StringUtils.isEmpty(phone)?"":"或手机号")+"已被注册", "UserRegisterResource", "");
            else
            {

                if(pwencrymode==1)
                    password = DigestUtils.md5DigestAsHex(password.getBytes());
                else if(pwencrymode==2)
                    password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", username, password).getBytes());
                if(!password.equals(existedUser.getPassword()))
                    throw new BadRequestAlertException("绑定到已有账号失败，请输入正确的密码", "UserRegisterResource", "");

                account.setPassword(password);
                account.setUserid(existedUser.getUserid());
                account.setUserid(username);
            }
        }
        else
        {
            account.setUsername(username);
            if(pwencrymode==1)
                password = DigestUtils.md5DigestAsHex(password.getBytes());
            else if(pwencrymode==2)
                password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", username, password).getBytes());
            account.setPassword(password);
            account.setUserid(username);
            sysUserService.save(account);
        }

        if(sysUserAuth!=null)
        {
            sysUserAuth.setUserid(account.getUserid());
            sysUserAuthService.save(sysUserAuth);
        }
        return account;
    }

}