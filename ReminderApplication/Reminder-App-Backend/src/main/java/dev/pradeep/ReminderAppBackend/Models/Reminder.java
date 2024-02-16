package dev.pradeep.ReminderAppBackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reminder")
public class Reminder extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "users_id")
    @ToString.Exclude
    private User user;

    private LocalDateTime reminderTime;

    private LocalDateTime currentDate;
    private String reminderMessage;
    private String reminderName;
}
