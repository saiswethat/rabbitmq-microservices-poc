package com.example.messageproducer.service;

import com.example.messageproducer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ResponseListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void onMessage(String msg) {
        if (!"hello".equals(msg)) {
            System.out.println("Received back: " + msg);
        }
    }
}
