package dev.pradeep.ReminderAppBackend.Interceptors;

import dev.pradeep.ReminderAppBackend.Constants.InterceptorConstants;
import dev.pradeep.ReminderAppBackend.Exceptions.TokenNotFoundException;
import dev.pradeep.ReminderAppBackend.Models.UserToken;
import dev.pradeep.ReminderAppBackend.Repositories.ValidateTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserInterceptor implements HandlerInterceptor {

    private final ValidateTokenRepository validateTokenRepository;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            return true;
        } // This is added to PREVENT CORS issue

        String token = request.getHeader(InterceptorConstants.AUTHORIZATION);

        if (ObjectUtils.isEmpty(token)) {
            throw new TokenNotFoundException();
        }

        log.info("token found - {}", token);
        UserToken userToken = validateTokenRepository.findByToken(token);
        request.setAttribute(InterceptorConstants.USER, userToken.getUser());
        return true;
    }

}
