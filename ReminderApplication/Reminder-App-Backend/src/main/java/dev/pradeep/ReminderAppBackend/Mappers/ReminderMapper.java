package dev.pradeep.ReminderAppBackend.Mappers;

import dev.pradeep.ReminderAppBackend.Dtos.Request.ReminderDto;
import dev.pradeep.ReminderAppBackend.Models.Reminder;
import dev.pradeep.ReminderAppBackend.Models.User;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public class ReminderMapper {

    public List<ReminderDto> mapReminderToDto(List<Reminder> reminders) {
        List<ReminderDto> reminderFinal = new ArrayList<>();

        for (Reminder reminder : reminders) {
            ReminderDto reminderDto = new ReminderDto().setReminderName(reminder.getReminderName())
                    .setReminderTime(reminder.getReminderTime())
                    .setReminderMessage(reminder.getReminderMessage())
                    .setUserName(reminder.getUser().getUserName())
                    .setRemindedAtTime(reminder.getRemindedAtTime())
                    .setReminderName(reminder.getReminderName());
            reminderFinal.add(reminderDto);
        }

        return reminderFinal;
    }

    public Reminder dtoToReminder(ReminderDto reminderDto, User user) {
        Reminder reminder = new Reminder();
        reminder.setUser(user);
        reminder.setReminderMessage(reminderDto.getReminderMessage());
        reminder.setReminderName(reminderDto.getReminderName());
        reminder.setReminderTime(reminderDto.getReminderTime());
        reminder.setRemindedAtTime(reminderDto.getRemindedAtTime());
        return reminder;
    }

}
