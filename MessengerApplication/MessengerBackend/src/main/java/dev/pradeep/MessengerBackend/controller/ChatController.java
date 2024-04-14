package dev.pradeep.MessengerBackend.controller;

import dev.pradeep.MessengerBackend.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ChatController {

    @MessageMapping("chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDto sendMessage(@Payload ChatMessageDto chatMessageDto){
        return chatMessageDto;
    }

    @MessageMapping("chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageDto addUser(@Payload ChatMessageDto chatMessageDto, StompHeaderAccessor accessor){
        Objects.requireNonNull(accessor.getSessionAttributes()).put("username", chatMessageDto.getSender());
        return chatMessageDto;
    }

}
