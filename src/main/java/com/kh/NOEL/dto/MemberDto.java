package com.kh.NOEL.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userTel;
    private String userEmail;
    private Date createdAt;

}
