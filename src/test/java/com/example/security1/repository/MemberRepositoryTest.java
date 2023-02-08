package com.example.security1.repository;

import com.example.security1.entity.Member;
import com.example.security1.entity.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@naver.com")
                    .name("사용자" +i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1234"))
                    .build();
            member.addMemberRole(MemberRole.USER);

            if(i > 50) member.addMemberRole(MemberRole.ADMIN);

            memberRepository.save(member);
        });
    }

    @Test
    public void testRead() {
        Optional<Member> res = memberRepository.findByEmail("user23@naver.com", false);

        Member member = res.get();

        System.out.println(member);
    }

}