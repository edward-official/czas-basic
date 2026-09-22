package com.groupedward.artifactedward.discount;

import com.groupedward.artifactedward.member.Grade;
import com.groupedward.artifactedward.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {

    private int discountFixedAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        } else {
            return 0;
        }
    }
}
