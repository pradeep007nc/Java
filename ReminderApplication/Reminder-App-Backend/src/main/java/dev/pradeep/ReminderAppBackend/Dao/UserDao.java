package dev.pradeep.ReminderAppBackend.Dao;

import dev.pradeep.ReminderAppBackend.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {

    @Query("select u from user u where u.mobileNumber = :mobileNumber")
    Optional<User> findUserByMobileNumber(String mobileNumber);
}
