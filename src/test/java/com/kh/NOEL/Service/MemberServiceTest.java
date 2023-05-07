package com.kh.NOEL.Service;

import com.kh.NOEL.domain.Member;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.repository.MemberRepository;
import com.kh.NOEL.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    void joinTest(){
        MemberDto memberDto = new MemberDto();
        memberDto.setUserId("testId");
        memberDto.setUserName("testName");
        memberDto.setUserPw("testPw");
        memberDto.setUserTel("testTel");
        MemberDto memberDto1 = memberService.joinMember(memberDto);

        assertEquals("testId",memberDto1.getUserId());
        assertEquals("testName",memberDto1.getUserName());
        assertEquals("testTel",memberDto1.getUserTel());
    }
}
