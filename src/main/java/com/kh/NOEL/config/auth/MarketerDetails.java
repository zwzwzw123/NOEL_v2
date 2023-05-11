package com.kh.NOEL.config.auth;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MarketerDetails implements UserDetails {

    private Marketer marketer;

    public MarketerDetails(Marketer marketer){
        this.marketer = marketer;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return marketer.getMarketerAuth().toString();
            }
        });
        return null;
    }

    @Override
    public String getPassword() {
        return marketer.getMarketerPw();
    }

    @Override
    public String getUsername() {
        return marketer.getMarketerId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
