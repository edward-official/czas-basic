package com.groupedward.artifactedward.singleton;

import com.groupedward.artifactedward.AppConfig;
import com.groupedward.artifactedward.member.MemberRepository;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;
import com.groupedward.artifactedward.order.OrderService;
import com.groupedward.artifactedward.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRespository", MemberRepository.class);

        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig.getClass() );
    }
}
