package dev.pradeep.ReminderAppBackend.Repositories;

import dev.pradeep.ReminderAppBackend.Dao.UserTokenDao;
import dev.pradeep.ReminderAppBackend.Exceptions.UserNotFoundException;
import dev.pradeep.ReminderAppBackend.Models.UserToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenRepository {

    private final UserTokenDao userTokenDao;

    public UserToken findByUserId(Long id) {
        return userTokenDao.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Optional<UserToken> findByUserIdAndWipeOffFalse(Long id) {
        return userTokenDao.findByUserIdAndWipeOffFalse(id);
    }

    public void save(UserToken userToken) {
        userTokenDao.save(userToken);
    }
}
