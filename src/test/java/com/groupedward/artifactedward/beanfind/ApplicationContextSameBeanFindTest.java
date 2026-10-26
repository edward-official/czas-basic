package com.groupedward.artifactedward.beanfind;

import com.groupedward.artifactedward.member.MemberRepository;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(RedundantTypeConfig.class);

    @Configuration
    static class RedundantTypeConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

    @Test
    @DisplayName("type redundancy")
    void findByTypeRedundant() {
//        ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(MemberRepository.class);
        });
    }

    @Test
    @DisplayName("type redundancy but selecting through the name")
    void findByTypeRedundantUsingName() {
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("find all beans by type")
    void findByTypeAll() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key: beansOfType.keySet()) {
            System.out.println("key = " + key + ", value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size() == 2);
    }
}
