package dev.pradeep.ReminderAppBackend.Dao;

import dev.pradeep.ReminderAppBackend.Models.UserToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserTokenDao extends CrudRepository<UserToken, Long> {
    @Query("select u from UserToken u where u.userId = :userId and u.tokenWipeOff = false")
    Optional<UserToken> findByUserIdAndWipeOffFalse(Long userId);
}
