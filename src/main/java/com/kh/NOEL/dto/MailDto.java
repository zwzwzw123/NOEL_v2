package com.kh.NOEL.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {
    private  String address;
    private String title;
    private String message;
}
