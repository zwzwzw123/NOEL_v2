package com.kh.NOEL.service;

import com.kh.NOEL.Response;
import com.kh.NOEL.domain.Member;
import com.kh.NOEL.domain.MemberLevel;
import com.kh.NOEL.dto.MailDto;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.mapper.MemberMapper;
import com.kh.NOEL.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JavaMailSender mailSender;

    //일반 회원 가입
    public MemberDto joinMember(MemberDto memberDto) {
        Member member = MemberMapper.convertToModel(memberDto);
        String rawPW = memberDto.getUserPw();
        String encPw = encoder.encode(rawPW);
        member.setUserPw(encPw);
        member.setUserLevel(MemberLevel.ROLE_USER);
        this.memberRepository.save(member);
        return MemberMapper.convertToDto(member);
    }

    public boolean checkMemberId(String userId) {
        return memberRepository.existsByUserId(userId);
    }


    public String findID(String userName, String userTel) {
        Member member = memberRepository.findByUserNameAndUserTel(userName,userTel);
        String id = member.getUserId();
        return id;
    }

}
