package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPictureProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Picture p) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(p);

        rabbitTemplate.convertAndSend("x.mypicture", p.getType(), json);
    }

}
