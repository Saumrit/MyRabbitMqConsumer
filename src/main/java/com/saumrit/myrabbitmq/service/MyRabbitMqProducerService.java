package com.saumrit.myrabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyRabbitMqProducerService {

    private final RabbitTemplate rabbitTemplate;

    public MyRabbitMqProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        rabbitTemplate.convertAndSend("edu","saumrit.edu.student.add",
                "Hello Saumrit !! How was yourTrip ??");
    }
}
