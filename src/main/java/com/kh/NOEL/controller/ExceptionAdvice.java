package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionAdvice {
    @ExceptionHandler(IllegalAccessError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> illegalArgumentExceptionAdvice(IllegalArgumentException e){
        return new Response<>("fail",e.getMessage().toString(),null);

    }
}
