package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import com.kh.NOEL.domain.Member;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
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
        return new Response<>("true", "회원가입 성공",saveMember.getUserId());
    }

    //아이디 유효성 검사
    @GetMapping("/join/checkId/{userId}")
    public Response<?> checkMemberId(@PathVariable String userId){
        boolean check = memberService.checkMemberId(userId);
        return new Response<>("true", "일반 회원 아이디 중복 확인",check);
    }

    //로그인
    @GetMapping("/login")
    public Response<?> loginMember(){
       return new Response<>("true","일반 회원 로그인 완료",null);
    }

    //아이디 찾기
    @GetMapping("/findID")
    public Response<?> findID(@RequestParam(required = true, value = "userName")String userName,
                              @RequestParam(required = true, value = "userTel")String userTel){
        String id = memberService.findID(userName, userTel);
        return new Response<>("true","일반 회원 아이디 찾기 완료",id);
    }



}
