package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class OtpNoFoundException extends RuntimeException {
    private String message = "otp not found for user";
}
