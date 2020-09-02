package cn.ibizlab.core.extensions.aspect;


import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.service.IPayTradeService;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * 保存交易记录切面类
 *
 */
@Aspect
@Component
public class PayTradeAspect {

    @Autowired
    IPayTradeService payTradeService;

    @AfterReturning(value = "execution(* cn.ibizlab.core.extensions.service.PayCoreService.pagePay(..)) ||  execution(* cn.ibizlab.core.extensions.service.PayCoreService.preCreate(..))")
    @SneakyThrows
    public void savePayTrade(JoinPoint point){
        Object [] args = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0)
            return;

        Object serviceParam =args[0];
        if(serviceParam instanceof  PayTrade){
            PayTrade entity=(PayTrade)serviceParam;
            entity.setTradeName(entity.getSubject());
            payTradeService.save(entity);
        }
    }
}
