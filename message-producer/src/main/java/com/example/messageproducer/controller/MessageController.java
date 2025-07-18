package com.example.messageproducer.controller;

import com.example.messageproducer.service.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        messageProducer.sendMessage(message);
    }
}
