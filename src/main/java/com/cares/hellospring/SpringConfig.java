package com.cares.hellospring;

import com.cares.hellospring.repository.MemberRepository;
import com.cares.hellospring.repository.MemoryMemberRepository;
import com.cares.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return  new MemoryMemberRepository();
    }
}
