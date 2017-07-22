package com.aerospace.domain.repository;

import com.aerospace.domain.configuration.RootApplicationContextConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by coupang on 2017. 7. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	@Ignore
	@Test
	public void insert() throws Exception {
		Member member = new Member();
		member.setEmail("jjh4698@naver.com");
		member.setPassword("123123123");
		member.setName("정주혁");
		memberRepository.insert(member);

		memberRepository.select(member.getMemberSeq());
	}

}