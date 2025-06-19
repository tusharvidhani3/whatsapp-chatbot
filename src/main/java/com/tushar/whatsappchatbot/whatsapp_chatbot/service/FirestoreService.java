package com.tushar.whatsappchatbot.whatsapp_chatbot.service;

import com.tushar.whatsappchatbot.whatsapp_chatbot.payload.MessageRequest;

public interface FirestoreService {

    public void saveMessageDetails(MessageRequest messageRequest);
}
