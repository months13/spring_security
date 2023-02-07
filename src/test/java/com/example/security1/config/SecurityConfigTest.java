package com.example.security1.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String password = "1234";

        String enPw = passwordEncoder.encode(password);

        System.out.println("enpW : " + enPw);

        boolean res = passwordEncoder.matches(password, enPw);

        System.out.println("res : " + res);
    }

}