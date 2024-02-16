package dev.pradeep.ReminderAppBackend.Mappers;

import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Models.UserToken;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TokenMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "tokenWipeOff", constant = "false")
    UserToken mapUserToken(User user);

}
