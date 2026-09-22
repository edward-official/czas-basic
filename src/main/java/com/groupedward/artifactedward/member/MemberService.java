package com.groupedward.artifactedward.member;

public interface MemberService {

    void join(Member member);

    Member findMemeber(Long memberId);

}
