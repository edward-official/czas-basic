package com.groupedward.artifactedward.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // givne
        Member member = new Member(1L, "member a", Grade.VIP);

        // when
        memberService.join(member);
        Member foundMember = memberService.findMemeber(1L);

        // then
        Assertions.assertThat(member).isEqualTo(foundMember);
    }
}

