package dev.pradeep.ReminderAppBackend.Models;

import dev.pradeep.ReminderAppBackend.Enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String userName;
    private String mobileNumber;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reminder> reminders;
}
