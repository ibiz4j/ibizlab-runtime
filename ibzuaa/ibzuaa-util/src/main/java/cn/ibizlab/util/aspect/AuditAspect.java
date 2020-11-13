package cn.ibizlab.util.aspect;

import lombok.SneakyThrows;
import cn.ibizlab.util.annotation.Audit;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import cn.ibizlab.util.service.IBZDataAuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 实体数据审计切面类
 */
@Aspect
@Component
public class AuditAspect
{
    private final ExpressionParser parser = new SpelExpressionParser();

    @Autowired
    IBZDataAuditService dataAuditService;

    /**
     * 实体数据建立切面，在成功创建数据后将新增数据内容记录审计日志内（审计明细【AuditInfo】中只记录审计属性变化情况，审计属性在平台属性中配置）
     * @param point
     */
    @AfterReturning(value = "execution(* cn.ibizlab.core.*.service.*.create(..))")
    @SneakyThrows
    public void create(JoinPoint point) {
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            request = ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        Object [] args = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return;
        }
        Object serviceParam = args[0];
        if(serviceParam instanceof EntityBase) {
            EntityBase entity = (EntityBase)serviceParam;
            Map<String, Audit> auditFields = DEFieldCacheMap.getAuditFields(entity.getClass());
            //是否有审计属性
            if(auditFields.size()==0) {
                return;
            }
            String idField = DEFieldCacheMap.getDEKeyField(entity.getClass());
            Object idValue = "";
            if(!StringUtils.isEmpty(idField)) {
                idValue=entity.get(idField);
            }
            //记录审计日志
            dataAuditService.createAudit(request, entity, idValue, auditFields);
        }
    }

    /**
     * 实体数据更新切面，在成功更新数据后将新增数据内容记录审计日志内（审计明细【AuditInfo】中只记录审计属性变化情况，审计属性在平台属性中配置）
     * 使用环切【@Around】获取到更新前后的实体数据并进行差异比较，并将差异内容记入审计日志内
     * @param point
     */
    @Around("execution(* cn.ibizlab.core.*.service.*.update(..))")
    public Object update(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            request=((ServletRequestAttributes)requestAttributes).getRequest();
        }
        Object serviceObj = point.getTarget();
        Object args[] = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return point.proceed();
        }
        Object arg = args[0];
        if(arg instanceof EntityBase) {
            EntityBase entity = (EntityBase) arg;
            Map<String, Audit> auditFields = DEFieldCacheMap.getAuditFields(entity.getClass());
            //是否有审计属性
            if(auditFields.size()==0) {
                return point.proceed();
            }
            String idField = DEFieldCacheMap.getDEKeyField(entity.getClass());
            Object idValue = "";
            if(!StringUtils.isEmpty(idField)){
                idValue = entity.get(idField);
            }
            if(ObjectUtils.isEmpty(idValue)) {
                return point.proceed();
            }
            //获取更新前实体
            EntityBase beforeEntity = getEntity(serviceObj, idValue);
            //执行更新操作
            point.proceed();
            //记录审计日志
            dataAuditService.updateAudit(request, beforeEntity, serviceObj, idValue, auditFields);
            return true;
        }
        return point.proceed();
    }

    /**
     * 实体数据更新切面，在成功更新数据后将新增数据内容记录审计日志内（审计明细【AuditInfo】中只记录审计属性变化情况，审计属性在平台属性中配置）
     * 使用环切【@Around】获取要删除的完整数据，并将审计属性相关信息记录到审计日志中
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* cn.ibizlab.core.*.service.*.remove(..))")
    public Object remove(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes!= null) {
            request = ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        Object serviceObj = point.getTarget();
        Object args[] = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return point.proceed();
        }
        Object idValue = args[0];
        EntityBase entity = getEntity(serviceObj, idValue);
        Map<String, Audit> auditFields = DEFieldCacheMap.getAuditFields(entity.getClass());
        if(auditFields.size()==0) {
            return point.proceed();
        }
        else{
            //执行删除操作
            point.proceed();
            //记录审计日志
            dataAuditService.removeAudit(request, entity, idValue, auditFields);
            return true;
        }
    }

    /**
     * 获取实体
     * @param service
     * @param id
     * @return
     */
    @SneakyThrows
    private EntityBase getEntity(Object service, Object id) {
        EntityBase entity = null;
        if(!ObjectUtils.isEmpty(service)) {
            EvaluationContext oldContext = new StandardEvaluationContext();
            oldContext.setVariable("service", service);
            oldContext.setVariable("id", id);
            Expression oldExp = parser.parseExpression("#service.get(#id)");
            return oldExp.getValue(oldContext, EntityBase.class);
        }
        return entity;
    }
}