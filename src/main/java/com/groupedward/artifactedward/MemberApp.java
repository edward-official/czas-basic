package com.groupedward.artifactedward;

import com.groupedward.artifactedward.member.Grade;
import com.groupedward.artifactedward.member.Member;
import com.groupedward.artifactedward.member.MemberService;
import com.groupedward.artifactedward.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "member a", Grade.VIP);
        memberService.join(memberA);

        Member foundMember = memberService.findMemeber(1L);

        System.out.println("new member: " + memberA.getName());
        System.out.println("found member: " + foundMember.getName());
    }
}
