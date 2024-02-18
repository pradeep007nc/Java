package dev.pradeep.ReminderAppBackend.Controllers;


import dev.pradeep.ReminderAppBackend.Dtos.Request.ReminderDto;
import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Services.ReminderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.pradeep.ReminderAppBackend.Constants.InterceptorConstants.USER;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/reminder")
public class ReminderController {

    private final ReminderService reminderService;

    @GetMapping("/list-reminders")
    public List<ReminderDto> listReminders(
            @RequestAttribute(USER) User user
    ) {
        return reminderService.listReminders(user.getId());
    }

    @PostMapping("/add-reminder")
    public void addReminder(
            @RequestAttribute(USER) User user,
            @RequestBody ReminderDto reminderDto
    ) {
        reminderService.addReminder(user, reminderDto);
    }
}
