package com.kh.NOEL.service;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.domain.MarketerAuth;
import com.kh.NOEL.dto.MarketerDto;
import com.kh.NOEL.mapper.MarketerMapper;
import com.kh.NOEL.repository.MarketerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketerService {
    @Autowired
    private MarketerRespository marketerRespository;

    public MarketerDto joinMarketer(MarketerDto marketerDto) {
        Marketer marketer = MarketerMapper.convertToModel(marketerDto);
        marketer.setMarketerAuth(MarketerAuth.승인확인중);
        this.marketerRespository.save(marketer);
        return MarketerMapper.converToDto(marketer);
    }

    public boolean checkMarketerId(String marketerId) {
         boolean check = marketerRespository.existsByMarketerId(marketerId);
        return check;
    }

    public boolean checkMarketerEmail(String marketerEmail) {
        return marketerRespository.existsByMarketerEmail(marketerEmail);
    }
}
