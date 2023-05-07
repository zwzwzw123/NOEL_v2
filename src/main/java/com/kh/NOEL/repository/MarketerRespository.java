package com.kh.NOEL.repository;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.dto.MarketerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketerRespository extends JpaRepository<Marketer, Long> {
    boolean existsByMarketerId(String marketerId);

    boolean existsByMarketerEmail(String marketerEmail);

    Optional<Marketer> findByMarketerIdAndMarketerPw(String marketerId, String marketerPw);
}
