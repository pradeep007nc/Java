package dev.pradeep.ReminderAppBackend.Controllers;

import dev.pradeep.ReminderAppBackend.Dtos.Request.LoginDto;
import dev.pradeep.ReminderAppBackend.Dtos.Request.SignupDto;
import dev.pradeep.ReminderAppBackend.Dtos.Request.ValidateOtpDto;
import dev.pradeep.ReminderAppBackend.Dtos.Response.LoginResponseDto;
import dev.pradeep.ReminderAppBackend.Dtos.Response.ValidateOtpResponseDto;
import dev.pradeep.ReminderAppBackend.Services.UserAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/auth")
public class AuthController {

    private final UserAuthService userAuthService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginDto loginDto
    ) {
        return userAuthService.loginUser(loginDto);
    }

    @PostMapping("/validate-otp")
    public ValidateOtpResponseDto validateOtp(@RequestBody ValidateOtpDto validateOtpDto) {
        return userAuthService.validateOtpForLogin(validateOtpDto);
    }

    @PostMapping("/signup")
    public void signup(
            @RequestBody SignupDto signupDto
    ) {
        userAuthService.signupUser(signupDto);
    }

}
