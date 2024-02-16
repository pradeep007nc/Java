package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class WrongOtpException extends RuntimeException{
    private final String message = "Wrong otp";
}
