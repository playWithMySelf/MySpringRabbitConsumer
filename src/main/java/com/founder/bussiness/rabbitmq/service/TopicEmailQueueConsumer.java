package com.founder.bussiness.rabbitmq.service;

import com.founder.bussiness.rabbitmq.entity.MessageEntity;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author: inwei
 * @create: ${Date} ${time}
 * @description:
 * @param: ${params}
 * @return: ${returns}
 */
public class TopicEmailQueueConsumer implements MessageListener {
    public void onMessage(Message message) {
        MessageEntity messageBean = (MessageEntity) SerializationUtils.deserialize(message.getBody());
        System.out.println("*******rabbitmq****topicMessageQueue 收到的消息："
            +messageBean.getFrom() +" to "+ messageBean.getTo() + "："+messageBean.getContent() );
    }
}
