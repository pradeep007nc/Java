package dev.pradeep.ReminderAppBackend.Mappers;

import dev.pradeep.ReminderAppBackend.Models.LoginOtp;
import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Utils.LoginUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OtpMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "retryCount", constant = "3")
    @Mapping(target = "status", constant = "INITIATED")
    LoginOtp toLoginOtp(User user);

}
