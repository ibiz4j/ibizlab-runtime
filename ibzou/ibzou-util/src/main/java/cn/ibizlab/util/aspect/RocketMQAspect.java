package cn.ibizlab.util.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.util.domain.EntityBase;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Lazy;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * rocketMQ消息切面
 */
@Slf4j
@Aspect
@Component
@ConditionalOnExpression("'${rocketmq.producer.isOnOff:off}'.equals('on')")
public class RocketMQAspect
{
    private final ExpressionParser parser = new SpelExpressionParser();

    @Autowired
    @Lazy
    DefaultMQProducer defaultMQProducer;

    @Value("${rocketmq.producer.topic:default}")
    private String topic;

    @Around(value = "(execution(* cn.ibizlab.core.*.service.ISysEmployeeService.remove*(..)))")
    public Object sysEmployeedeleteSysUser(ProceedingJoinPoint point) throws Throwable{
        Object entity = getEntity(point);
        Object result = point.proceed();
        sendMsg(topic, "deletesysuser", entity);
        return result;
    }
    @Around(value = "(execution(* cn.ibizlab.core.*.service.ISysEmployeeService.create*(..))||execution(* cn.ibizlab.core.*.service.ISysEmployeeService.update*(..)))")
    public Object sysEmployeesaveSysUser(ProceedingJoinPoint point) throws Throwable{
        Object entity = getEntity(point);
        Object result = point.proceed();
        sendMsg(topic, "savesysuser", entity);
        return result;
    }

    /**
     * 输出过滤行为
     * @param point
     * @param actionName
     * @param entity
     */
    private void outputAction(JoinPoint point, String actionName, Object entity) {
        Object[] args = point.getArgs();
        if (ObjectUtils.isEmpty(args) || args.length == 0 || ObjectUtils.isEmpty(entity)) {
            return;
        }
        Object service = point.getTarget();
        EvaluationContext serviceCtx = new StandardEvaluationContext();
        serviceCtx.setVariable("service", service);
        serviceCtx.setVariable("arg", entity);
        Expression serviceExp = parser.parseExpression(String.format("#service.%s(#arg)", actionName));
        serviceExp.getValue(serviceCtx);
    }

    /**
     * 获取实体对象
     *
     * @param point
     * @return
     */
    private Object getEntity(ProceedingJoinPoint point) {
        Object entity = null;
        try {
            String action = point.getSignature().getName();
            Object[] args = point.getArgs();
            Object serviceObj = point.getTarget();
            if (ObjectUtils.isEmpty(args) || args.length == 0 || StringUtils.isEmpty(action)) {
                return entity;
            }
            if ("remove".equalsIgnoreCase(action)) {
                Object idValue = args[0];
                if (!ObjectUtils.isEmpty(serviceObj)) {
                    EvaluationContext oldContext = new StandardEvaluationContext();
                    oldContext.setVariable("service", serviceObj);
                    oldContext.setVariable("id", idValue);
                    Expression oldExp = parser.parseExpression("#service.get(#id)");
                    entity = oldExp.getValue(oldContext, EntityBase.class);
                }
            } else {
                entity = args[0];
            }
        } catch (Exception e) {
            log.error("发送消息失败，无法获取实体对象" + e);
        }
        return entity;
    }

    /**
     * 发送消息
     *
     * @param topic
     * @param tag
     * @param body
     */
    private void sendMsg(String topic, String tag, Object body) {
        if (ObjectUtils.isEmpty(body)) {
            log.error("消息内容为空，[{}]消息将被忽略！", tag);
            return;
        }
        try {
            Message message = new Message(topic, tag, JSON.toJSONString(body).getBytes());
            SendResult sendResult = defaultMQProducer.send(message);
            log.info("消息发送响应：" + sendResult.toString());
        } catch (Exception e) {
            log.error("消息发送异常，" + e);
        }
    }
}

