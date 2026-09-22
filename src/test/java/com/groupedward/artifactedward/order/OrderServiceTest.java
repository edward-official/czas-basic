package com.groupedward.artifactedward.order;

import com.groupedward.artifactedward.member.Grade;
import com.groupedward.artifactedward.member.Member;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "member a", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "item a", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
