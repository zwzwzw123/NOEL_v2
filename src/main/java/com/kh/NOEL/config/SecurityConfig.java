package com.kh.NOEL.config;

import com.kh.NOEL.config.auth.MarketerDetails;
import com.kh.NOEL.config.auth.MarketerDetailsService;
import com.kh.NOEL.config.auth.MemberDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encodePw(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private MemberDetailsService memberDetailsService;

    @Autowired
    private MarketerDetailsService marketerDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberDetailsService).passwordEncoder(encodePw());
        auth.userDetailsService(marketerDetailsService).passwordEncoder(encodePw());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                .antMatchers("/product/**").authenticated()
                .antMatchers("/class/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/member/login")
                .loginProcessingUrl("/member/loginForm")
                .loginPage("/marketer/login")
                .loginProcessingUrl("/marketer/loginForm")
                .and()
                .httpBasic();
    }
}
