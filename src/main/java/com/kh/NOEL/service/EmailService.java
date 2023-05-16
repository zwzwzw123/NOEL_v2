package com.kh.NOEL.service;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.domain.Member;
import com.kh.NOEL.dto.MailDto;
import com.kh.NOEL.dto.MarketerDto;
import com.kh.NOEL.dto.MemberDto;
import com.kh.NOEL.mapper.MarketerMapper;
import com.kh.NOEL.mapper.MemberMapper;
import com.kh.NOEL.repository.MarketerRespository;
import com.kh.NOEL.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    private final MemberRepository memberRepository;

    private final MarketerRespository marketerRespository;

    private final BCryptPasswordEncoder encoder;

    public MemberDto findUserIdAndUserEmail(String userId, String userEmail) {
        Member member = memberRepository.findByUserIdAndUserEmail(userId,userEmail);
        return MemberMapper.convertToDto(member);
    }

    public MarketerDto findByMarketerIdAndMarketerEmail(String id, String email) {
        Marketer marketer = marketerRespository.findByMarketerIdAndMarketerEmail(id, email);
        return MarketerMapper.converToDto(marketer);
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
