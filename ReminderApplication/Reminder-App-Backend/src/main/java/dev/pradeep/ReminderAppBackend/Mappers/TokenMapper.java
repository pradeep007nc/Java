package dev.pradeep.ReminderAppBackend.Mappers;

import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Models.UserToken;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public class TokenMapper {
    public UserToken mapUserToken(User user) {
        UserToken userToken = new UserToken();
        userToken.setUserId(user.getId());
        userToken.setTokenWipeOff(false);
        userToken.setUserType(user.getUserType());
        return userToken;
    }

}
