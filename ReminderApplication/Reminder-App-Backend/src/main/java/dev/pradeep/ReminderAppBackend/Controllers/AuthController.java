package dev.pradeep.ReminderAppBackend.Controllers;

import dev.pradeep.ReminderAppBackend.Dtos.Request.LoginDto;
import dev.pradeep.ReminderAppBackend.Dtos.Request.ValidateOtpDto;
import dev.pradeep.ReminderAppBackend.Dtos.Response.LoginResponseDto;
import dev.pradeep.ReminderAppBackend.Dtos.Response.ValidateOtpResponseDto;
import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Services.UserAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static dev.pradeep.ReminderAppBackend.Constants.InterceptorConstants.USER;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class AuthController {

    private final UserAuthService userAuthService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginDto loginDto
            ){
        return userAuthService.loginUser(loginDto);
    }

    @PostMapping("/validate-otp")
    public ValidateOtpResponseDto validateOtp(@RequestBody ValidateOtpDto validateOtpDto){
        return userAuthService.validateOtpForLogin(validateOtpDto);
    }

}
