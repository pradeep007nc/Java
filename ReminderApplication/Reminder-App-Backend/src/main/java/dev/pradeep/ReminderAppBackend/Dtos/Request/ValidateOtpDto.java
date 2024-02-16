package dev.pradeep.ReminderAppBackend.Dtos.Request;

import lombok.Data;

@Data
public class ValidateOtpDto {

    private String mobileNumber;
    private String otp;

}
