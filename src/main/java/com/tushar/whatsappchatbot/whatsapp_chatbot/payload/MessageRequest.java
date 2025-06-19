package com.tushar.whatsappchatbot.whatsapp_chatbot.payload;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageRequest {

    private String from;
    private String message;
    private LocalDateTime timestamp;
}
