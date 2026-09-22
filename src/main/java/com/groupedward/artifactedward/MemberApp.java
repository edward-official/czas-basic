package com.groupedward.artifactedward;

import com.groupedward.artifactedward.member.Grade;
import com.groupedward.artifactedward.member.Member;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "member a", Grade.VIP);
        memberService.join(memberA);

        Member foundMember = memberService.findMemeber(1L);

        System.out.println("new member: " + memberA.getName());
        System.out.println("found member: " + foundMember.getName());
    }
}
