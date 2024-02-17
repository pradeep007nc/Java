package dev.pradeep.ReminderAppBackend.Exceptions;

import lombok.Data;

@Data
public class UserAlreadyExistApplication extends RuntimeException {
    private final String message = "The user already exist use some other mobile number";
}
