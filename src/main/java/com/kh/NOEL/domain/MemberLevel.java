package com.kh.NOEL.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberLevel {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    String level;

    MemberLevel(String level){
        this.level =level;
    }

    public String value(){
        return level;
    }

}
