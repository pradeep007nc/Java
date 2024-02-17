package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class UnauthorizedUserException extends RuntimeException {
    private final String message = "Unauthorized user token invalid or expired";
}
