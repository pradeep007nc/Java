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
public class User extends BaseEntity{
    private String userName;
    private String mobileNumber;
    private UserType userType;
    @OneToMany(mappedBy = "reminder", cascade = CascadeType.ALL)
    private List<Reminder> Reminders;
}
