package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import com.kh.NOEL.domain.Member;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/join")
    public Response<?> joinMember(@RequestBody MemberDto memberDto){
        MemberDto saveMember = memberService.joinMember(memberDto);
        return new Response<>("true", "회원가입 성공",saveMember);
    }

    //아이디 유효성 검사
    @GetMapping("/join/checkId/{userId}")
    public Response<?> checkMemberId(@PathVariable String userId){
        boolean check = memberService.checkMemberId(userId);
        return new Response<>("true", "일반 회원 아이디 중복 확인",check);
    }

    //로그인
    @PostMapping("/login")
    public Response<?> loginMember(@RequestBody MemberDto memberDto,HttpSession session){
       MemberDto principal = memberService.loginMember(memberDto.getUserId(),memberDto.getUserPw());
       if(principal !=null){
            session.setAttribute("principal",principal);
       }
       return new Response<>("true","로그인성공",principal.getUserId());
    }
}
