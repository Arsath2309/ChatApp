package com.example.chatapp.controller;

import com.example.chatapp.model.Message;
import com.example.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Message sendMessage(@RequestBody Message message) {
        return chatService.saveMessage(message);
    }
}
