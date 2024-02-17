package dev.pradeep.ReminderAppBackend.Repositories;

import dev.pradeep.ReminderAppBackend.Exceptions.UnauthorizedUserException;
import dev.pradeep.ReminderAppBackend.Models.UserToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidateTokenRepository {
    private final TokenRepository tokenRepository;

    public UserToken findByToken(String token) {
        return tokenRepository.findByToken(token).orElseThrow(UnauthorizedUserException::new);
    }

}
