package com.groupedward.artifactedward.order;

import com.groupedward.artifactedward.discount.DiscountPolicy;
import com.groupedward.artifactedward.discount.FixedDiscountPolicy;
import com.groupedward.artifactedward.member.Member;
import com.groupedward.artifactedward.member.MemberRepository;
import com.groupedward.artifactedward.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
