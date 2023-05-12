package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(IllegalAccessError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> illegalArgumentExceptionAdvice(IllegalArgumentException e){
        return new Response<>("fail",e.getMessage().toString(),null);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?>NOtFoundExceptionAdvice(EntityNotFoundException e){
        return new Response<>("fail",e.getMessage().toString(),null);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?>UsernameNotFoundException(UsernameNotFoundException e){
        return new Response<>("fail",e.getMessage(),null);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> NullPointerException(NullPointerException e){
        return new Response<>("fail",e.getMessage(),"NullPointerException");
    }

}
