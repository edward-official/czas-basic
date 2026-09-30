package com.groupedward.artifactedward.discount;

import com.groupedward.artifactedward.member.Grade;
import com.groupedward.artifactedward.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP must get 10% discount")
    void vip_o() {
        //given
        Member vipMemeber = new Member(1L, "vip memeber", Grade.VIP);
        //when
        int discounted = discountPolicy.discount(vipMemeber, 10000);
        //then
        assertThat(discounted).isEqualTo(1000);
    }

    @Test
    @DisplayName("no discount unless they're VIP")
    void vip_x() {
        //given
        Member member = new Member(1L, "non-VIP member", Grade.BASIC);
        //when
        int discounted = discountPolicy.discount(member, 10000);
        //then
        assertThat(discounted).isEqualTo(0);
    }

}