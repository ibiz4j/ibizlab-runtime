package cn.ibizlab.core.util.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

@Slf4j
@Configuration
@ConditionalOnExpression("'${rocketmq.producer.isOnOff:off}'.equals('on')")
public class RocketMQProducer {

    @Value("${rocketmq.producer.groupName:default}")
    private String groupName;

    @Value("${rocketmq.producer.namesrvAddr:127.0.0.1:9876}")
    private String namesrvAddr;

    // 消息最大值
    @Value("${rocketmq.producer.maxMessageSize:409600}")
    private Integer maxMessageSize;

    // 消息发送超时时间
    @Value("${rocketmq.producer.sendMsgTimeOut:3000}")
    private Integer sendMsgTimeOut;

    // 失败重试次数
    @Value("${rocketmq.producer.retryTimesWhenSendFailed:2}")
    private Integer retryTimesWhenSendFailed;

    /**
     * mq 生成者配置
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer defaultProducer() throws MQClientException {
        log.info("rocketmq defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMsgTimeOut);
        producer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendFailed);
        producer.start();
        log.info("rocketmq producer server 开启成功----------------------------------");
        return producer;
    }
}

