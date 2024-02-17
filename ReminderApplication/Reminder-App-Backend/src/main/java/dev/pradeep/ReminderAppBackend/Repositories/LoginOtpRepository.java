package dev.pradeep.ReminderAppBackend.Repositories;

import dev.pradeep.ReminderAppBackend.Dao.LoginOtpDao;
import dev.pradeep.ReminderAppBackend.Enums.OtpStatus;
import dev.pradeep.ReminderAppBackend.Models.LoginOtp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginOtpRepository {
    private final LoginOtpDao loginOtpDao;

    public void save(LoginOtp loginOtp) {
        loginOtpDao.save(loginOtp);
    }

    public Optional<LoginOtp> findLoginOtpExists(String mobileNumber, OtpStatus otpStatus) {
        return loginOtpDao.findByMobileNumberAndStatus(mobileNumber, otpStatus);
    }
}
