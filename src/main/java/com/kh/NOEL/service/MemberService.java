package com.kh.NOEL.service;

import com.kh.NOEL.domain.Member;
import com.kh.NOEL.domain.MemberLevel;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.mapper.MemberMapper;
import com.kh.NOEL.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public MemberDto join(MemberDto memberDto){
        Member member = MemberMapper.convertToModel(memberDto);
        member.setUserLevel(MemberLevel.USER);
        this.memberRepository.save(member);
        return MemberMapper.convertToDto(member);
    }

}
