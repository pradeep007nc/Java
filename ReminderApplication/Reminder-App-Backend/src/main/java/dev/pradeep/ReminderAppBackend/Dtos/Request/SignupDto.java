package dev.pradeep.ReminderAppBackend.Dtos.Request;

import lombok.Data;

@Data
public class SignupDto {
    private String userName;
    private String mobileNumber;
}
