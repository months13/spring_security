package com.example.security1.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberUserDetailsService implements UserDetailsService {

    /**
     * 이게 빈으로 등록되면 앞으로 데이터베이스에 있는 정보로 로그인 가능...
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
