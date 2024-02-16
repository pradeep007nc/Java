package dev.pradeep.ReminderAppBackend.Utils;

import java.util.UUID;

public class TokenUtil {
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
