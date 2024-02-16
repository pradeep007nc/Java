package dev.pradeep.ReminderAppBackend.Advise;

import dev.pradeep.ReminderAppBackend.Dtos.ErrorResponseDto;
import dev.pradeep.ReminderAppBackend.Exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvisor {

    @ExceptionHandler(
            value = {
                    UserNotFoundException.class,
                    OtpNoFoundException.class,
                    TokenNotFoundException.class
            })
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(Exception exception) {
        log.error("handleNotFoundException", exception);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {OtpMaxLimitException.class, WrongOtpException.class})
    public ResponseEntity<ErrorResponseDto> handleNotAcceptableUserException(Exception exception) {
        log.error("handleNotAcceptableUserException", exception);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_ACCEPTABLE);
    }

}
