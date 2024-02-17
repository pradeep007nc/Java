package dev.pradeep.ReminderAppBackend.Models;

import dev.pradeep.ReminderAppBackend.Enums.OtpStatus;
import dev.pradeep.ReminderAppBackend.Enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "login_otp")
public class LoginOtp extends BaseEntity{
    private Long userId;
    private String mobileNumber;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String otp;
    private int retryCount;
    private OtpStatus status;
}
