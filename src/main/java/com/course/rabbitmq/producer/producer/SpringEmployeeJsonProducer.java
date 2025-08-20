package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringEmployeeJsonProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Employee emp) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(emp);

        rabbitTemplate.convertAndSend("x.spring2.work", "", json);
    }

}
