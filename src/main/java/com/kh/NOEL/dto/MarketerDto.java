package com.kh.NOEL.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketerDto {
    private String marketerPw;
    private String marketerId;
    private String marketerName;
    private String marketerTel;
    private String marketerEmail;
    private Date marketerCreatedat;
    private String marketerAddr;

}
