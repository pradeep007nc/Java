package dev.pradeep.ReminderAppBackend.Dao;

import dev.pradeep.ReminderAppBackend.Models.Reminder;
import org.springframework.data.repository.CrudRepository;

public interface ReminderDao extends CrudRepository<Reminder, Long> {
}
