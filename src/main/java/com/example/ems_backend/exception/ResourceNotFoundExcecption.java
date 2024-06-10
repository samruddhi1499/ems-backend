package com.example.ems_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcecption extends RuntimeException{

    public ResourceNotFoundExcecption(String message){
        super(message);
    }
}
