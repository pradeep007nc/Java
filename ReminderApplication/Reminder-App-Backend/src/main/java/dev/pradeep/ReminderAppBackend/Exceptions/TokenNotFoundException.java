package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class TokenNotFoundException extends RuntimeException {
    private final String message = "Token not found";
}
