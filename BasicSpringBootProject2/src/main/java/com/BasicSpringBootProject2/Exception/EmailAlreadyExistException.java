package com.BasicSpringBootProject2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException{
    private String email;

    public EmailAlreadyExistException(String email){
        super(String.format("Provided Email is already exist:- %s",email));
    }
}
