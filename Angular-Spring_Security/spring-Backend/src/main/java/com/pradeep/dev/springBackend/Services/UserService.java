package com.pradeep.dev.springBackend.Services;

import com.pradeep.dev.springBackend.Dto.CredentialsDto;
import com.pradeep.dev.springBackend.Dto.UserDto;
import com.pradeep.dev.springBackend.Entities.User;
import com.pradeep.dev.springBackend.Mappers.UserMapper;
import com.pradeep.dev.springBackend.Rpositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto){
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password())
        ,user.getPassword())){
            return userMapper.toUserDto(user);
        }
        throw new Exception("Invalid Password", HttpStatus.BAD_REQUEST);
    }
}
