package com.groupedward.artifactedward.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memeberId);

}
