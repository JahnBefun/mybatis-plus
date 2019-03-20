package com.demo.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisMsgQueueService implements MessageListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * 接收消息的方法
     * @param message
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        //接收的msg
        String msg = serializer.deserialize(message.getBody());
        //接收的topic
        String topic = serializer.deserialize(message.getChannel());
//        logger.info("接收到来自："+topic+" topic的消息："+msg);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String id,String message){
        String topic = "instanceLog_"+id;
        redisTemplate.convertAndSend(topic,message);
    }

}