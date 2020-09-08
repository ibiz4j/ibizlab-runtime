package cn.ibizlab.core.extensions.aspect;


import cn.ibizlab.core.extensions.service.NotifyCoreService;
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.service.IMsgOpenAccessService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 新建或更新时刷新token
 */
@Aspect
@Order(0)
@Component
public class RefreshTokenAspect {

    @Autowired
    @Lazy
    IMsgOpenAccessService smsConfigService;

    @Autowired
    @Lazy
    NotifyCoreService notifyCoreService;

    @Before(value = "execution(* cn.ibizlab.core.notify.service.IMsgOpenAccessService.create*(..))")
    public void afterCreate(JoinPoint point) throws Exception {
        refreshToken(point);
    }

    @Before(value = "execution(* cn.ibizlab.core.notify.service.IMsgOpenAccessService.update*(..))")
    public void afterUpdate(JoinPoint point) throws Exception {
        refreshToken(point);
    }

    /**
     * 刷新token
     * @param point
     */
    private void refreshToken(JoinPoint point){
        Object[] args = point.getArgs();
        if (args.length > 0 && args[0] instanceof MsgOpenAccess) {
            MsgOpenAccess msgOpenAccess = (MsgOpenAccess) args[0];
            if(msgOpenAccess.getOpenType().equals("wechat") || msgOpenAccess.getOpenType().equals("dingtalk")){
                notifyCoreService.refreshToken(msgOpenAccess);
            }
        }
    }

}
