package com.groupedward.artifactedward.xml;

import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.order.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppTest {

    @Test
    @DisplayName("string container from xml file")
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderService orderService = ac.getBean("orderService", OrderService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }
}
