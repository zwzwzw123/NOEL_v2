package com.kh.NOEL.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "member", schema = "khfinal_noel", uniqueConstraints = {@UniqueConstraint(columnNames = "user_no")})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", unique = true, nullable = false)
    private Long userNo;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @JsonIgnore
    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_tel", nullable = false)
    private String userTel;

    @Column(name = "created_at", unique = false, nullable = true)
    @CreationTimestamp
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private MemberLevel userLevel;
}
