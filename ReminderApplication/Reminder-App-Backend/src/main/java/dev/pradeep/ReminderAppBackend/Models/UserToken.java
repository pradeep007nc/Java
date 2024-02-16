package dev.pradeep.ReminderAppBackend.Models;

import dev.pradeep.ReminderAppBackend.Enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_token")
public class    UserToken extends BaseEntity{

    private Long userId;

    private String token;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(columnDefinition = "boolean default false")
    private boolean tokenWipeOff;
}
