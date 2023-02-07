package com.example.security1.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").hasRole("USER");

        http.formLogin(); // 인증에 문제 발생 시 로그인 폼을 보여줌
        http.csrf().disable(); // csrf를 사용하지 않을 때 사용함...
        http.logout(); //
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1")
                .password("$2a$10$0r.4m0dMC8w5AIT9lYGNZuN6ChyxMVG9dd5VIfFfuPvP/eM/NkK.y")
                .roles("USER"); // roles는 사용자가 가지는 권한. 이 부분을 지우면 패스워드 생성된다..
                // 여기서 user는 role_user와 같은 역할.. user를 상수처럼 사용하는게 포인트..
    }
}
