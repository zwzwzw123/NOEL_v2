package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.domain.MarketerAuth;
import com.kh.NOEL.dto.MarketerDto;
import com.kh.NOEL.service.MarketerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketerController {

    @Autowired
    private MarketerService marketerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/join/marketer")
    public Response<?> joinMarketer(@RequestBody MarketerDto marketerDto){
        MarketerDto saveMarketer = marketerService.joinMarketer(marketerDto);
        return new Response<>("tree","판매자 회원가입 성공",saveMarketer);
    }
}
