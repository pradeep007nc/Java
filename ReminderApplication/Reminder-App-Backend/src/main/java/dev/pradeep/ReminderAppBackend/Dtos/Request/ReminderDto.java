package dev.pradeep.ReminderAppBackend.Dtos.Request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ReminderDto {
    private String userName;
    private LocalDateTime reminderTime;
    private LocalDateTime remindedAtTime;
    private String reminderMessage;
    private String reminderName;
}
