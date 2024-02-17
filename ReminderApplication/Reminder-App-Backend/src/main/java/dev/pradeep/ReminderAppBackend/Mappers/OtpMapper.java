package dev.pradeep.ReminderAppBackend.Mappers;

import dev.pradeep.ReminderAppBackend.Enums.OtpStatus;
import dev.pradeep.ReminderAppBackend.Models.LoginOtp;
import dev.pradeep.ReminderAppBackend.Models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper
public class OtpMapper {

    public LoginOtp mapToLoginOtp(User user) {
        LoginOtp loginOtp = new LoginOtp();
        loginOtp.setUserId(user.getId());
        loginOtp.setRetryCount(3);
        loginOtp.setStatus(OtpStatus.INITIATED);
        loginOtp.setUserType(user.getUserType());
        loginOtp.setMobileNumber(user.getMobileNumber());
        loginOtp.setUserType(user.getUserType());
        return loginOtp;
    }

}
