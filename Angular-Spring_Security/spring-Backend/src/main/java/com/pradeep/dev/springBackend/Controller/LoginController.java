package com.pradeep.dev.springBackend.Controller;

import com.pradeep.dev.springBackend.Dto.CredentialsDto;
import com.pradeep.dev.springBackend.Dto.UserDto;
import com.pradeep.dev.springBackend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentials){
        UserDto user = userService.login(credentials);
        return ResponseEntity.ok(user);
    }

}
