package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class OtpNoFoundException extends RuntimeException{
    private final String message = "otp not found for user";
}
