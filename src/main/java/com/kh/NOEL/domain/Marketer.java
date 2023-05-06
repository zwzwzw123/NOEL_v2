package com.kh.NOEL.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "marketer", schema = "khfinal_noel", uniqueConstraints = {@UniqueConstraint(columnNames = "marketer_no")})
public class Marketer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marketer_no", unique = true, nullable = false)
    private Long marketerNo;
    @Column(name = "marketer_id", unique = true, nullable = false)
    private String marketerId;
    @Column(name = "marketer_pw", nullable = false)
    private String marketerPw;
    @Column(name = "marketer_name", nullable = false)
    private String marketerName;
    @Column(name = "marketer_tel", nullable = false)
    private String marketerTel;
    @Column(name = "marketer_email")
    private String marketerEmail;
    @Column(name = "marketer_createdat")
    @CreationTimestamp
    private Date marketerCreatedat;
    @Enumerated(EnumType.STRING)
    private MarketerAuth marketerAuth;
    @Column(name = "prd_no")
    private String prdNo;
    @Column(name = "cl_no")
    private String clNo;
    @Column(name = "marketer_addr")
    private String marketerAddr;
}
