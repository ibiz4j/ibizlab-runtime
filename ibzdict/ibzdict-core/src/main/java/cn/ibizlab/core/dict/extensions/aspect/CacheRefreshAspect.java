package cn.ibizlab.core.dict.extensions.aspect;

import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.extensions.service.DictCoreService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



@Aspect
@Order(0)
@Component
public class CacheRefreshAspect
{
    @Autowired
    @Lazy
    private DictCoreService dictCoreService;

    @Before(value = "execution(* cn.ibizlab.core.dict.service.IDictCatalogService.update(..))")
    public void BeforeUpdateEmp(JoinPoint point) throws Exception {
        refreshDictCache(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.dict.service.IDictCatalogService.save(..))")
    public void BeforeSaveEmp(JoinPoint point) throws Exception {
        refreshDictCache(point);
    }


    private void refreshDictCache(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if(obj instanceof DictCatalog)
            {
                String code=((DictCatalog) obj).getCode();
                if(!StringUtils.isEmpty(code)) {
                    dictCoreService.resetDictCatalog(code);
                    dictCoreService.resetCodeListCatalog(code);
                }
            }

        }
    }

}
