package com.example.JpaTest;

import com.example.JpaTest.entity.Member;
import com.example.JpaTest.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class JpaTestApplicationTests {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Order(1)
    void save(){
        Member member = new Member();
        member.setUsername("kim ori");
        memberRepository.save(member);

        member = new Member();
        member.setUsername("lee ori");
        memberRepository.save(member);

        member = new Member();
        member.setUsername("kim ental");
        memberRepository.save(member);

        member = new Member();
        member.setUsername("lee ental");
        memberRepository.save(member);

        member = new Member();
        member.setUsername("kim samuel");
        memberRepository.save(member);
    }

    @Test
    @Order(2)
    void select(){
        List<Member> memberList = memberRepository.findAll();
        for(Member member : memberList)
            log.debug("[FindAll]: " + member.getID() + " | " + member.getUsername());
    }

    @Test
    @Order(3)
    void selectFilter(){
        List<Member> memberList = memberRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
        for(Member member : memberList)
            log.debug("[FindSome]: " + member.getID() + " | " + member.getUsername());
    }
}
