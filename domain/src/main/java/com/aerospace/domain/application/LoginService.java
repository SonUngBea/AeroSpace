package com.aerospace.domain.application;

import com.aerospace.domain.repository.Member;
import com.aerospace.domain.repository.MemberRepository;
import com.aerospace.domain.util.EncryptManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coupang on 2017. 8. 27..
 */
@Service
public class LoginService {

	private static final String PASSWORD_KEY = "C^%$&&^&SC(";

	@Autowired
	private MemberRepository memberRepository;

	public boolean isLoginSuccess(String email, String password) {
		Member member = memberRepository.findByEmail(email);
		if (member == null) {
			return false;
		}
		System.out.println(EncryptManager.encryptWithSalt(password, PASSWORD_KEY)+" : " + member.getPassword());
		return StringUtils.equalsIgnoreCase(EncryptManager.encryptWithSalt(password, PASSWORD_KEY), member.getPassword());
	}
}
