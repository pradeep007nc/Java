package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class OtpMaxLimitException extends RuntimeException{
    private final String message = "Otp max limit reached. Login again";
}
