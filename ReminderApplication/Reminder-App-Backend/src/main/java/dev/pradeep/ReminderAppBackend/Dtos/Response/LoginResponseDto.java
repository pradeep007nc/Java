package dev.pradeep.ReminderAppBackend.Dtos.Response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginResponseDto {
    private String otp;
}
