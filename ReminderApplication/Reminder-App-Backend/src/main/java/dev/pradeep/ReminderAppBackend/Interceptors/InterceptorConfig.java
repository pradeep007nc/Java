package dev.pradeep.ReminderAppBackend.Interceptors;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeUserPatterns = List.of(
                "/api/user/auth/login",
                "/api/user/auth/signup",
                "/api/user/auth/validate-otp"
        );
        List<String> userPathPatterns = List.of(
                "/api/user/**"
        );

        registry.addInterceptor(userInterceptor)
                .addPathPatterns(userPathPatterns)
                .excludePathPatterns(excludeUserPatterns)
                .order(1);
    }
}
