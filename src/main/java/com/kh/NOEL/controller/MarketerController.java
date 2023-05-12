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
@RequestMapping("/marketer")
public class MarketerController {

    @Autowired
    private MarketerService marketerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/join")
    public Response<?> joinMarketer(@RequestBody MarketerDto marketerDto){
        MarketerDto saveMarketer = marketerService.joinMarketer(marketerDto);
        return new Response<>("true","판매자 회원가입 성공",saveMarketer);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "/join/checkId/{marketerId}")
    public Response<?> checkMarketerId(@PathVariable String marketerId){
        boolean check = marketerService.checkMarketerId(marketerId);
        return new Response<>("true","판매자 아이디 중복 확인",check);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value="/join/checkEmail/{marketerEmail}")
    public Response<?> checkMarketerEmail(@PathVariable String marketerEmail){
        boolean check = marketerService.checkMarketerEmail(marketerEmail);
        return new Response<>("true","판매자 이메일 중복 확인",check);
    }

    //로그인
    @GetMapping("/login")
    public Response<?> loginMarketer(){
        return new Response<>("true", "판매자 로그인 완료", null);
    }

    @GetMapping("/findID")
    public Response<?> findID(@RequestParam(required = true, value = "marketerName")String marketerName,
                              @RequestParam(required = true, value = "marketerTel")String marketerTel){
        String id = marketerService.findID(marketerName, marketerTel);
        return new Response<>("true","판매자 아이디 찾기 완료",id);
    }
}
