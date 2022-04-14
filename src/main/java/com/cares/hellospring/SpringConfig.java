package com.cares.hellospring;

import com.cares.hellospring.repository.JdbcMemberRepository;
import com.cares.hellospring.repository.MemberRepository;
import com.cares.hellospring.repository.MemoryMemberRepository;
import com.cares.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return  new JdbcMemberRepository(dataSource);
    }
}
