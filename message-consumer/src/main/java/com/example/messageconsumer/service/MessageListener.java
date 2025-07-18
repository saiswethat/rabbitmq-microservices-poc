package com.example.messageconsumer.service;
import com.example.messageconsumer.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private final RabbitTemplate rabbitTemplate;

    public MessageListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(String msg) {
        if ("hello".equals(msg)) {
            System.out.println("Received: " +msg);
            String response = msg + " World";
            System.out.println("Replying: " + response);
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE, response);
        }
    }
}
