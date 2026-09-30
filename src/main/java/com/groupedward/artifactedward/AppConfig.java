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

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRespository());
    }

    private MemberRepository memberRespository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRespository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
