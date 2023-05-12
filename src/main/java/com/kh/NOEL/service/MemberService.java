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

    public MemberDto findUserIdAndUserEmail(String userId, String userEmail) {
        Member member = memberRepository.findByUserIdAndUserEmail(userId,userEmail);
        return MemberMapper.convertToDto(member);
    }

    public MailDto findPw(String userEmail, String userId) {
        Member member = memberRepository.findByUserIdAndUserEmail(userId,userEmail);
        String str = getTempPw();
        MailDto mail = new MailDto();
        mail.setAddress(userEmail);
        mail.setTitle("NOEL 임시비밀번호 안내 이메일 입니다.");
        mail.setMessage("안녕하세요. NOEL 임시비밀번호 관련 이메일입니다."+userId+" 님의 임시 비밀번호는 "+str+" 입니다."+"로그인 후에는 비밀번호를 변경해주세요.");
        String encPw = encoder.encode(str);
        member.setUserPw(encPw);
        memberRepository.save(member);
        return mail;

    }
    public String getTempPw(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

    public void mailSend(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        message.setReplyTo("zwzwzw12333@gmail.com");
        message.setFrom("zwzwzw12333@gmail.com");
        mailSender.send(message);
    }


}
