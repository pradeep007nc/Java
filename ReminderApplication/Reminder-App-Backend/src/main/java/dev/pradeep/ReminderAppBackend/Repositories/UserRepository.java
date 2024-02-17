package dev.pradeep.ReminderAppBackend.Repositories;

import dev.pradeep.ReminderAppBackend.Dao.UserDao;
import dev.pradeep.ReminderAppBackend.Exceptions.UserNotFoundException;
import dev.pradeep.ReminderAppBackend.Models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRepository {
    private final UserDao userDao;

    public User findUserByMobileNumber(String mobileNumber) {
        return userDao.findUserByMobileNumber(mobileNumber).orElseThrow(UserNotFoundException::new);
    }

    public Optional<User> findByMobileNumber(String mobileNumber) {
        return userDao.findUserByMobileNumber(mobileNumber);
    }

    public void save(User user) {
        userDao.save(user);
    }
}
