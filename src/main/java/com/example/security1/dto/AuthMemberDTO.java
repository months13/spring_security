package com.example.security1.dto;


import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
public class AuthMemberDTO extends User {

    private String email;
    private String name;
    private boolean fromSocial;

    public AuthMemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
