package com.aerospace.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Repository
public class MemberRepository {
	@Autowired
	private MemberDao memberDao;

	public Member select(String memberSeq) {
		return memberDao.select(memberSeq);
	}

	public void insert(Member member) {
		memberDao.insert(member);
	}
}
