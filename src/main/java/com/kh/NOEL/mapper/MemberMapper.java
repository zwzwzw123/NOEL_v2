package com.kh.NOEL.mapper;

import com.kh.NOEL.domain.Member;
import com.kh.NOEL.dto.MemberDto;

public class MemberMapper {
    public static MemberDto convertToDto(Member member){
        MemberDto memberDto = new MemberDto();
        memberDto.setUserId(member.getUserId());
        memberDto.setUserPw(member.getUserPw());
        memberDto.setUserName(member.getUserName());
        memberDto.setUserTel(member.getUserTel());
        memberDto.setCreatedAt(member.getCreatedAt());
        return memberDto;
    }

    public static Member convertToModel(MemberDto memberDto){
        Member member = new Member();
        member.setUserId(memberDto.getUserId());
        member.setUserPw(memberDto.getUserPw());
        member.setUserName(memberDto.getUserName());
        member.setUserTel(memberDto.getUserTel());
        member.setCreatedAt(memberDto.getCreatedAt());
        return member;
    }
}
