package com.tushar.whatsappchatbot.whatsapp_chatbot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.tushar.whatsappchatbot.whatsapp_chatbot.payload.MessageRequest;

@Service
public class FirestoreServiceImpl implements FirestoreService{

    @Override
    public void saveMessageDetails(MessageRequest messageRequest) {
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> messageData = new HashMap<>();
        messageData.put("from", messageRequest.getFrom());
        messageData.put("message", messageRequest.getMessage());
        messageData.put("timestamp", messageRequest.getTimestamp().toString());
        String messageId = messageRequest.getFrom() + "-" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 6);
        db.collection("messages").document(messageId).set(messageData);
    }

}
