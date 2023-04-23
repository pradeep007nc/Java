package dev.pradeep.validator.Dao;

import dev.pradeep.validator.Entity.User;
import dev.pradeep.validator.Entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Locale;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}