package dev.pradeep.SirmaAssignment.Advisor;

import dev.pradeep.SirmaAssignment.Dto.ErrorResponseDto;
import dev.pradeep.SirmaAssignment.Exceptions.ProjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvisor {

    @ExceptionHandler(
            value = {IllegalArgumentException.class,
                    MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(Exception exception) {
        log.error("handleBadRequestException", exception);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(
            value = {
                    ProjectNotFoundException.class
            })
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(Exception exception) {
        log.error("handleNotFoundException", exception);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
