package cn.ibizlab.util.aspect;

import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.util.domain.EntityBase;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.util.List;

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

    @AfterReturning(value = "(execution(* cn.ibizlab.core.*.service.*SysEmployee*.remove*(..)))")
    @Async
    public void sysEmployeedeleteSysUser(JoinPoint point) {
        sendMsg(topic, "deletesysuser", getEntity(point));
    }
    @AfterReturning(value = "(execution(* cn.ibizlab.core.*.service.*SysEmployee*.create*(..))||execution(* cn.ibizlab.core.*.service.*SysEmployee*.update*(..)))")
    @Async
    public void sysEmployeesaveSysUser(JoinPoint point) {
        sendMsg(topic, "savesysuser", getEntity(point));
    }

    /**
     * 输出过滤行为
     * @param point
     * @param actionName
     */
    private void outputAction(JoinPoint point,String actionName) {
        Object [] args = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0) {
            return;
        }
        Object arg = args[0];
        Object service = point.getTarget();
        EvaluationContext serviceCtx = new StandardEvaluationContext();
        serviceCtx.setVariable("service", service);
        serviceCtx.setVariable("arg", arg);
        Expression serviceExp = parser.parseExpression(String.format("#service.%s(#arg)", actionName));
        serviceExp.getValue(serviceCtx);
    }

    /**
     * 获取实体对象
     * @param point
     * @return
     */
    private Object getEntity(JoinPoint point) {
        Object entity=null;
        String action=point.getSignature().getName();
        Object [] args = point.getArgs();
        if(ObjectUtils.isEmpty(args) || args.length==0 || StringUtils.isEmpty(action)) {
            return entity;
        }
        Object arg=args[0];
        if(arg instanceof EntityBase  || arg instanceof List) {
            return arg;
        }
        else {
            return null;
        }
    }

    /**
     * 发送消息
     * @param topic
     * @param tag
     * @param body
     */
    private void sendMsg(String topic, String tag, Object body) {
        if(ObjectUtils.isEmpty(body)) {
            log.error("消息内容为空，[{}]消息将被忽略！",tag);
            return;
        }
        try {
            Message message = new Message(topic, tag, JSON.toJSONString(body).getBytes());
            SendResult sendResult = defaultMQProducer.send(message);
            log.info("消息发送响应：" + sendResult.toString());
        } catch (Exception e) {
            log.error("消息发送异常，"+e);
        }
    }
}

