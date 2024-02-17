package dev.pradeep.ReminderAppBackend.Services;

import dev.pradeep.ReminderAppBackend.Dtos.Request.LoginDto;
import dev.pradeep.ReminderAppBackend.Dtos.Request.ValidateOtpDto;
import dev.pradeep.ReminderAppBackend.Dtos.Response.LoginResponseDto;
import dev.pradeep.ReminderAppBackend.Dtos.Response.ValidateOtpResponseDto;
import dev.pradeep.ReminderAppBackend.Enums.OtpStatus;
import dev.pradeep.ReminderAppBackend.Exceptions.OtpMaxLimitException;
import dev.pradeep.ReminderAppBackend.Exceptions.OtpNoFoundException;
import dev.pradeep.ReminderAppBackend.Exceptions.WrongOtpException;
import dev.pradeep.ReminderAppBackend.Mappers.OtpMapper;
import dev.pradeep.ReminderAppBackend.Mappers.TokenMapper;
import dev.pradeep.ReminderAppBackend.Models.LoginOtp;
import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Models.UserToken;
import dev.pradeep.ReminderAppBackend.Repositories.LoginOtpRepository;
import dev.pradeep.ReminderAppBackend.Repositories.TokenRepository;
import dev.pradeep.ReminderAppBackend.Repositories.UserRepository;
import dev.pradeep.ReminderAppBackend.Utils.LoginUtil;
import dev.pradeep.ReminderAppBackend.Utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserRepository userRepository;
    private final LoginOtpRepository loginOtpRepository;
    private final TokenRepository tokenRepository;
    private final OtpMapper otpMapper = new OtpMapper();
    private final TokenMapper tokenMapper = new TokenMapper();

    public LoginResponseDto loginUser(LoginDto loginDto) {
        //check if the mobile number i.e user exists
        User currentUser =
                userRepository.findUserByMobileNumber(loginDto.getMobileNumber());

        //if user exist setup login otp repository and send otp to user mobile number
        String otp = saveLoginOtp(currentUser);

        //send otp
        return new LoginResponseDto().setOtp(otp);
    }

    public ValidateOtpResponseDto validateOtpForLogin(ValidateOtpDto validateOtpDto) {
        //check if the user doesn't have multiple token
        validateOtp(validateOtpDto);

        return sendToken(validateOtpDto);
    }

    private String saveLoginOtp(User user) {
        String otp = LoginUtil.generateOTP();

        //if already exist make it expire and send one more otp
        Optional<LoginOtp> prevOtp = loginOtpRepository.findLoginOtpExists(user.getMobileNumber(), OtpStatus.INITIATED);
        if (prevOtp.isPresent()) {
            prevOtp.get().setStatus(OtpStatus.EXPIRED);
            loginOtpRepository.save(prevOtp.get());
        }

        //map the login otp entity
        LoginOtp loginOtp = otpMapper.mapToLoginOtp(user);
        loginOtp.setOtp(otp);

        //save the entity
        loginOtpRepository.save(loginOtp);

        return otp;
    }

    private void validateOtp(ValidateOtpDto validateOtpDto) {
        LoginOtp loginOtp = loginOtpRepository.findLoginOtpExists(validateOtpDto.getMobileNumber(), OtpStatus.INITIATED).orElseThrow(OtpNoFoundException::new);

        if (loginOtp.getRetryCount() == 0) {
            loginOtp.setStatus(OtpStatus.EXPIRED);
            loginOtpRepository.save(loginOtp);
            throw new OtpMaxLimitException();
        } else if (loginOtp.getOtp().equals(validateOtpDto.getMobileNumber())) {
            loginOtp.setStatus(OtpStatus.VERIFIED);
            loginOtpRepository.save(loginOtp);
        } else {
            loginOtp.setRetryCount(loginOtp.getRetryCount() - 1);
            loginOtpRepository.save(loginOtp);
            throw new WrongOtpException();
        }
    }

    private ValidateOtpResponseDto sendToken(ValidateOtpDto validateOtpDto) {
        User user = userRepository.findUserByMobileNumber(validateOtpDto.getMobileNumber());

        Optional<UserToken> userToken = tokenRepository.findByUserIdAndWipeOffFalse(user.getId());

        if (userToken.isPresent()) {
            userToken.get().setTokenWipeOff(true);
            tokenRepository.save(userToken.get());
        }

        UserToken token = tokenMapper.mapUserToken(user);
        token.setToken(TokenUtil.generateUUID());
        tokenRepository.save(token);

        return new ValidateOtpResponseDto().setToken(token.getToken());
    }

}
