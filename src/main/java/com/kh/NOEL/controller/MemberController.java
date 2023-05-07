package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/join/member")
    public Response<?> joinMember(@RequestBody MemberDto memberDto){
        MemberDto saveMember = memberService.joinMember(memberDto);
        return new Response<>("true", "회원가입 성공",saveMember);
    }

    //아이디 유효성 검사
    @GetMapping("/join/member/{userId}/checkId")
    public ResponseEntity<Boolean> checkMemberId(@PathVariable String userId){
        return ResponseEntity.ok(memberService.checkMemberId(userId));
    }


}
