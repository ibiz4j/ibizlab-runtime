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
@ConditionalOnExpression("'${rocketmq.consumer.isOnOff:off}'.equals('on')")
public class RocketMQConsumer {

    @Value("${rocketmq.consumer.groupName:default}")
    private String groupName;

    @Value("${rocketmq.consumer.topic:default}")
    private String topic;

    @Value("${rocketmq.consumer.namesrvAddr:127.0.0.1:9876}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.consumeThreadMin:1}")
    private Integer consumeThreadMin;

    @Value("${rocketmq.consumer.consumeThreadMax:1}")
    private Integer consumeThreadMax;

    @Value("${rocketmq.consumer.consumeMessageBatchMaxSize:1}")
    private Integer consumeMessageBatchMaxSize;

    @Autowired
    @Lazy
    private RocketMQListenerProcessor listenerProcessor;

    /**
     * mq 消费者配置
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQPushConsumer defaultConsumer() {
        log.info("defaultConsumer 正在创建---------------------------------------");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
        // 设置监听
        consumer.registerMessageListener(listenerProcessor);
        /**
         * 设置consumer第一次启动是从队列头部开始还是队列尾部开始
         * 如果不是第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        /**
         * 设置消费模型，集群还是广播，默认为集群
         */
//        consumer.setMessageModel(MessageModel.CLUSTERING);
        try {
            consumer.subscribe(topic, "deletesysuser || savesysuser");
            consumer.start();
            log.info("rocketmq consumer 创建成功 groupName={}, topics={}, namesrvAddr={}", groupName, topic, namesrvAddr);
        } catch (MQClientException e) {
            log.error("rocketmq consumer 创建失败!" + e);
        }
        return consumer;
    }
}

