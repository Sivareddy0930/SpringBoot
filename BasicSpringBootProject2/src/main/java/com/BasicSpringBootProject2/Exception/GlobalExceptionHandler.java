package com.BasicSpringBootProject2.Exception;

import com.BasicSpringBootProject2.Exception.ErrorDetails;
import com.BasicSpringBootProject2.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //used to handle specific and global exceptions.

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlingResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                "USER_NOT_FOUND",
                webRequest.getDescription(false)

        );

        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handlerEmailAlreadyExistException(EmailAlreadyExistException exception, WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                "EMAIL_ALREADY_EXIST",
                webRequest.getDescription(false)

        );

        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handlerGlobalExceptions(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails =new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                "INTERNAL_SERVER_ERROR",
                webRequest.getDescription(false)

        );

        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
