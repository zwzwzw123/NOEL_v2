package com.kh.NOEL.repository;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.dto.MarketerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketerRespository extends JpaRepository<Marketer, Long> {
    boolean existsByMarketerId(String marketerId);

    boolean existsByMarketerEmail(String marketerEmail);
}
