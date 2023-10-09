package com.pradeep.dev.springBackend.Mappers;

import com.pradeep.dev.springBackend.Dto.UserDto;
import com.pradeep.dev.springBackend.Entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

}
