package dev.pradeep.ReminderAppBackend.Utils;

import java.util.Random;

public class LoginUtil {

    private static final Random random = new Random();

    public static String generateOTP() {
        int otpLength = 6;
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < otpLength; i++) {
            int digit = random.nextInt(10);
            otp.append(digit);
        }

        return otp.toString();
    }
}
