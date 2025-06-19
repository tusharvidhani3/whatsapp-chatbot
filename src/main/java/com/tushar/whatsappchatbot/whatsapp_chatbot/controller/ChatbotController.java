package com.tushar.whatsappchatbot.whatsapp_chatbot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tushar.whatsappchatbot.whatsapp_chatbot.payload.MessageRequest;
import com.tushar.whatsappchatbot.whatsapp_chatbot.service.ChatbotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class ChatbotController {

    @Autowired
    ChatbotService chatbotService;

    @PostMapping("/webhook")
    public ResponseEntity<String> handleIncomingMessage(@RequestBody MessageRequest messageRequest) {
        String reply = chatbotService.processIncomingMessage(messageRequest);
        return ResponseEntity.ok(reply);
    }
    
}
