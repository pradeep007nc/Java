package dev.pradeep.ReminderAppBackend.Dao;

import dev.pradeep.ReminderAppBackend.Enums.OtpStatus;
import dev.pradeep.ReminderAppBackend.Models.LoginOtp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginOtpDao extends CrudRepository<LoginOtp, Long> {

    @Query("select l from LoginOtp l where l.mobileNumber = :mobileNumber and l.status = :otpStatus")
    Optional<LoginOtp> findByMobileNumberAndStatus(String mobileNumber, OtpStatus otpStatus);
}
