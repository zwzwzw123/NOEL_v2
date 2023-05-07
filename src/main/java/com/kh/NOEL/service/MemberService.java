package com.kh.NOEL.service;

import com.kh.NOEL.domain.Member;
import com.kh.NOEL.domain.MemberLevel;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.mapper.MemberMapper;
import com.kh.NOEL.repository.MemberRepository;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //일반 회원 가입
    public MemberDto joinMember(MemberDto memberDto) {
        Member member = MemberMapper.convertToModel(memberDto);
        String rawPW = memberDto.getUserPw();
        member.setUserLevel(MemberLevel.USER);
        this.memberRepository.save(member);
        return MemberMapper.convertToDto(member);
    }

    public boolean checkMemberId(String userId) {
        return memberRepository.existsByUserId(userId);
    }

    public MemberDto loginMember(String userId, String userPw) {
        Optional<Member> res =memberRepository.findByUserIdAndUserPw(userId, userPw);
        if(res.isPresent()){
            MemberDto memberDto = MemberMapper.convertToDto(res.get());
            return memberDto;
        }else {
            throw new EntityNotFoundException(String.format("아이디 및 비밀번호가 일치하지 않습니다."));
        }

    }
}
