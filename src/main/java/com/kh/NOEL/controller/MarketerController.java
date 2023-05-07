package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.domain.MarketerAuth;
import com.kh.NOEL.dto.MarketerDto;
import com.kh.NOEL.service.MarketerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarketerController {

    @Autowired
    private MarketerService marketerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/join/marketer")
    public Response<?> joinMarketer(@RequestBody MarketerDto marketerDto){
        MarketerDto saveMarketer = marketerService.joinMarketer(marketerDto);
        return new Response<>("true","판매자 회원가입 성공",saveMarketer);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/join/marketer/{marketerId}/checkId")
    public Response<?> checkMarketerId(@PathVariable String marketerId){
        boolean check = marketerService.checkMarketerId(marketerId);
        return new Response<>("true","판매자 아이디 중복 확인",check);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value="/join/marketer/{marketerEmail}/checkEmail")
    public Response<?> checkMarketerEmail(@PathVariable String marketerEmail){
        boolean check = marketerService.checkMarketerEmail(marketerEmail);
        return new Response<>("true","판매자 이메일 중복 확인",check);

    }
}
