package dev.pradeep.ReminderAppBackend.Repositories;

import dev.pradeep.ReminderAppBackend.Dao.UserDao;
import dev.pradeep.ReminderAppBackend.Dtos.Request.ReminderDto;
import dev.pradeep.ReminderAppBackend.Exceptions.UserNotFoundException;
import dev.pradeep.ReminderAppBackend.Mappers.ReminderMapper;
import dev.pradeep.ReminderAppBackend.Models.Reminder;
import dev.pradeep.ReminderAppBackend.Models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReminderRepository {

    private final ReminderMapper reminderMapper = new ReminderMapper();
    private final UserDao userDao;


    public List<ReminderDto> listReminders(Long userId) {
        //check if user exist
        User user = userDao.findById(userId).orElseThrow(UserNotFoundException::new);

        //fetch list of reminders
        List<Reminder> reminders = user.getReminders();

        //map reminders to dto
        return reminderMapper.mapReminderToDto(reminders);
    }
}
