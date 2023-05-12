package com.kh.NOEL.repository;

import com.kh.NOEL.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserId(String userId);
    public Member findByUserId(String userId);

    public Member findByUserNameAndUserTel(String name, String tel);
}
