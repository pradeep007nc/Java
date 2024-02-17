package dev.pradeep.ReminderAppBackend.Controllers;


import dev.pradeep.ReminderAppBackend.Constants.InterceptorConstants;
import dev.pradeep.ReminderAppBackend.Dtos.Request.ReminderDto;
import dev.pradeep.ReminderAppBackend.Models.User;
import dev.pradeep.ReminderAppBackend.Repositories.ReminderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/reminder")
public class ReminderController {

    private final ReminderRepository reminderRepository;

    @GetMapping("/list-reminders")
    public List<ReminderDto> listReminders(
            @RequestAttribute(InterceptorConstants.USER) User user
    ) {
        return reminderRepository.listReminders(user.getId());
    }
}
