package dev.pradeep.ReminderAppBackend.Services;

import dev.pradeep.ReminderAppBackend.Dtos.Request.ReminderDto;
import dev.pradeep.ReminderAppBackend.Mappers.ReminderMapper;
import dev.pradeep.ReminderAppBackend.Models.Reminder;
import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Repositories.ReminderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository reminderRepository;
    private final ReminderMapper reminderMapper = new ReminderMapper();

    public List<ReminderDto> listReminders(Long id) {
        return reminderRepository.listReminders(id);
    }


    public void addReminder(User user, ReminderDto reminderDto) {
        Reminder reminder = reminderMapper.dtoToReminder(reminderDto, user);
        reminderRepository.save(reminder);
    }
}
