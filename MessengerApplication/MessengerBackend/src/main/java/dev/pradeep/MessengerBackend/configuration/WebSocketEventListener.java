package dev.pradeep.MessengerBackend.configuration;

import dev.pradeep.MessengerBackend.dto.ChatMessageDto;
import dev.pradeep.MessengerBackend.enums.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.awt.*;
import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Component
public class WebSocketEventListener {

    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) Objects.requireNonNull(accessor.getSessionAttributes()).get("username");
        if(username != null) {
            log.info("User Disconnected : " + username);
            var chatMessage = new ChatMessageDto()
                    .setMessageType(MessageType.LEAVE)
                    .setSender(username);

            simpMessageSendingOperations.convertAndSend("/topic/public", chatMessage);
        }
    }

}
