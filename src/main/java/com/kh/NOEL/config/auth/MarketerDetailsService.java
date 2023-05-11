package com.kh.NOEL.config.auth;

import com.kh.NOEL.domain.Marketer;
import com.kh.NOEL.domain.Member;
import com.kh.NOEL.repository.MarketerRespository;
import com.kh.NOEL.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MarketerDetailsService implements UserDetailsService {

    @Autowired
    private MarketerRespository marketerRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Marketer marketer = marketerRespository.findByMarketerId(username);

        if(marketer!=null){
            return new MarketerDetails(marketer);
        }
        return null;
    }
}
