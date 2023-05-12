package com.kh.NOEL.controller;

import com.kh.NOEL.Response;
import com.kh.NOEL.dto.MailDto;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


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

    //비밀번호 찾기
    @PostMapping("/findPw")
    public Response<?> findPw(@RequestBody MemberDto memberDto){
        String userId=memberDto.getUserId();
        String userEmail = memberDto.getUserEmail();
        MemberDto memberDto1 = memberService.findUserIdAndUserEmail(userId, userEmail);
        MailDto mail = memberService.findPw(memberDto1.getUserEmail(), memberDto1.getUserId());
        memberService.mailSend(mail);
        return new Response<>("true","일반 회원 임시 비밀번호 이메일 발송 완료 ",userEmail);
    }





}
