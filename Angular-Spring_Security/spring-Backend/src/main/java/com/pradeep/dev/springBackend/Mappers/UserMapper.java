package com.pradeep.dev.springBackend.Mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.pradeep.dev.springBackend.Dto.UserDto;
import com.pradeep.dev.springBackend.Entities.User;
import org.mapstruct.Mapper;

@Mapper(ComponentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

}
