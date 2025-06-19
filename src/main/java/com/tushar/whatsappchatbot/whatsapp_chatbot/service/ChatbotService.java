package com.tushar.whatsappchatbot.whatsapp_chatbot.service;

import com.tushar.whatsappchatbot.whatsapp_chatbot.payload.MessageRequest;

public interface ChatbotService {

    public String processIncomingMessage(MessageRequest messageRequest);
}
