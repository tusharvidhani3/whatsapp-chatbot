package com.tushar.whatsappchatbot.whatsapp_chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.whatsappchatbot.whatsapp_chatbot.payload.MessageRequest;

@Service
public class ChatBotServiceImpl implements ChatbotService {

    @Autowired
    FirestoreService firestoreService;

    @Override
    public String processIncomingMessage(MessageRequest messageRequest) {

        firestoreService.saveMessageDetails(messageRequest);
        String msg = messageRequest.getMessage();
        // Generate response based on request
        if (msg.contains("hi") || msg.contains("hello")) {
            return "Hello! 👋 How can I assist you today?";
        } else if (msg.contains("help")) {
            return "You can ask me about location, hours, or anything else.";
        } else {
            return "I'm sorry, I didn't understand that. Please type 'help'.";
        }

    }
}
