package com.aerospace.domain.repository;

import com.aerospace.domain.configuration.RootApplicationContextConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by coupang on 2017. 7. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@TransactionConfiguration
@Transactional(readOnly = false)
public class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;
	private static final String EMAIL = "arnoldmail@naver.com";

	@Before
	public void setUp() {
		memberRepository.deleteByEmail(EMAIL);
	}

	@After
	public void tearDown() {
		memberRepository.deleteByEmail(EMAIL);
	}

	@Test
	public void insert() throws Exception {
		Member member = new Member();
		member.setEmail(EMAIL);
		member.setPassword("123123123");
		member.setName("정주혁");
		memberRepository.save(member);
		Member expect = memberRepository.findByMemberSeq(member.getMemberSeq());
		assertEquals(expect.getEmail(), member.getEmail());
		assertEquals(expect.getPassword(), member.getPassword());
		assertEquals(expect.getName(), member.getName());
	}

}