package com.kh.NOEL.service;

import com.kh.NOEL.domain.Member;
import com.kh.NOEL.domain.MemberLevel;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.mapper.MemberMapper;
import com.kh.NOEL.repository.MemberRepository;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public MemberDto joinMemeber(MemberDto memberDto){
        Member member = MemberMapper.convertToModel(memberDto);
        String rawPW = memberDto.getUserPw();
        //String encPW =
        member.setUserLevel(MemberLevel.USER);
        this.memberRepository.save(member);
        return MemberMapper.convertToDto(member);
    }

}
