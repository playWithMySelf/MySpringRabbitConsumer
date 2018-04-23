package com.founder.bussiness.rabbitmq.service;

import com.founder.bussiness.rabbitmq.entity.MessageEntity;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author: inwei
 * @create: ${Date} ${time}
 * @description: directExchange 消费者
 * @param: ${params}
 * @return: ${returns}
 */
public class DirectQueueConsumer implements MessageListener {
    public void onMessage(Message message) {
        MessageEntity messageBean = (MessageEntity) SerializationUtils.deserialize(message.getBody());
        System.out.println("*******rabbitmq****directQueue 收到的消息："
            +messageBean.getFrom() +" to "+ messageBean.getTo() + "："+messageBean.getContent() );
    }
}
