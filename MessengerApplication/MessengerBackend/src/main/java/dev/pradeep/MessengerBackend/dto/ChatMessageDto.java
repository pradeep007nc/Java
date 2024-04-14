package dev.pradeep.MessengerBackend.dto;

import dev.pradeep.MessengerBackend.enums.MessageType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChatMessageDto {
    private String content;
    private String sender;
    private MessageType messageType;
}
