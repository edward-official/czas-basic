package com.groupedward.artifactedward.discount;

import com.groupedward.artifactedward.member.Member;

public interface DiscountPolicy {

    /**
     * @return amount of discount
     */
    int discount(Member member, int price);
}
