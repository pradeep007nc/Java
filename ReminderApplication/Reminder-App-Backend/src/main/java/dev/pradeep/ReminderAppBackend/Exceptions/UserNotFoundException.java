package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException {
    private final String message = "User not found";
}
