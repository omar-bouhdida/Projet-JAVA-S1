package com.library.service;

import com.library.model.Member;
import com.library.repository.MemberRepository;
import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public void save(Member member) {
        memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}
