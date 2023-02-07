package com.example.security1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SecurityController {

    @GetMapping("/all") // 다 가능
    public void exAll() {
        log.info("exAll..");
    }

    @GetMapping("/member") // 로그인한 사람만
    public void exMember() {
        log.info("exMember..");
    }

    @GetMapping("/admin") // 관리자만
    public void exAdmin() {
        log.info("exAdmin...");
    }


}
