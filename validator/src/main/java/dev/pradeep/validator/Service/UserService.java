package dev.pradeep.validator.Service;

import dev.pradeep.validator.Entity.User;
import dev.pradeep.validator.Entity.UserDto;

import java.util.List;

public interface UserService{

    User findUserById(Long Id);

    void saveUser(UserDto User);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    User save(User user);

    void deleteUser(User user);
}
