package com.groupedward.artifactedward.beanfind;

import com.groupedward.artifactedward.AppConfig;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("search by name")
    void findByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("search by type")
    void findByType() {
        MemberServiceImpl bean = ac.getBean(MemberServiceImpl.class);
        assertThat(bean).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("search by name fail")
    void findByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            ac.getBean("xxx", MemberService.class);
        });
    }

}
