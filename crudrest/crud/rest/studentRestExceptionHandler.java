package crudrest.crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class studentRestExceptionHandler {

    //add exception handling
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(studentNotFoundException exception){

        //create a studentErrorResponse
        studentErrorResponse error = new studentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler to handle all the exceptions
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(Exception exception){
        //create a studentErrorResponse
        studentErrorResponse error = new studentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
