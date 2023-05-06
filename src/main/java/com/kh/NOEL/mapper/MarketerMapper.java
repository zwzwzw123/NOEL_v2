package com.kh.NOEL.mapper;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.dto.MarketerDto;

public class MarketerMapper {

    public static MarketerDto converToDto(Marketer marketer){
        MarketerDto marketerDto = new MarketerDto();
        marketerDto.setMarketerId(marketer.getMarketerId());
        marketerDto.setMarketerPw(marketer.getMarketerPw());
        marketerDto.setMarketerName(marketer.getMarketerName());
        marketerDto.setMarketerTel(marketer.getMarketerTel());
        marketerDto.setMarketerEmail(marketer.getMarketerEmail());
        marketerDto.setMarketerCreatedat(marketer.getMarketerCreatedat());
        marketerDto.setMarketerAddr(marketer.getMarketerAddr());
        return marketerDto;
    }

    public static Marketer convertToModel(MarketerDto marketerDto){
        Marketer marketer = new Marketer();
        marketer.setMarketerId(marketerDto.getMarketerId());
        marketer.setMarketerPw(marketerDto.getMarketerPw());
        marketer.setMarketerName(marketerDto.getMarketerName());
        marketer.setMarketerTel(marketerDto.getMarketerTel());
        marketer.setMarketerEmail(marketerDto.getMarketerEmail());
        marketer.setMarketerCreatedat(marketerDto.getMarketerCreatedat());
        marketer.setMarketerAddr(marketerDto.getMarketerAddr());
        return marketer;

    }
}
