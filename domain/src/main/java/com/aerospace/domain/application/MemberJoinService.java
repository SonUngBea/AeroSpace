package com.aerospace.domain.application;

import com.aerospace.domain.common.Common;
import com.aerospace.domain.repository.Member;
import com.aerospace.domain.repository.MemberRepository;
import com.aerospace.domain.util.EncryptManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Service
public class MemberJoinService {
	@Autowired
	private MemberRepository memberRepository;

	public void join(String email, String password, String name) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(EncryptManager.encryptWithSalt(password, Common.CONSTANT.PASSWORD_KEY));
		member.setName(name);

		memberRepository.save(member);
	}
}
