package com.groupedward.artifactedward.member;

import com.groupedward.artifactedward.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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

