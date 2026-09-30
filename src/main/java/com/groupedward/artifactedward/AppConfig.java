package com.groupedward.artifactedward;

import com.groupedward.artifactedward.discount.DiscountPolicy;
import com.groupedward.artifactedward.discount.FixedDiscountPolicy;
import com.groupedward.artifactedward.discount.RateDiscountPolicy;
import com.groupedward.artifactedward.member.MemberRepository;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;
import com.groupedward.artifactedward.member.MemoryMemberRepository;
import com.groupedward.artifactedward.order.OrderService;
import com.groupedward.artifactedward.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRespository());
    }

    @Bean
    public MemberRepository memberRespository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRespository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
