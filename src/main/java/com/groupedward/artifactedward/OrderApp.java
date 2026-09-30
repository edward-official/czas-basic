package com.groupedward.artifactedward;

import com.groupedward.artifactedward.member.Grade;
import com.groupedward.artifactedward.member.Member;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;
import com.groupedward.artifactedward.order.Order;
import com.groupedward.artifactedward.order.OrderService;
import com.groupedward.artifactedward.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "member a", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item a", 1000);
        System.out.println(order);

    }
}
