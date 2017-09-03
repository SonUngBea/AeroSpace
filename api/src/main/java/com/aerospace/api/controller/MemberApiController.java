package com.aerospace.api.controller;

import com.aerospace.api.annotations.ApiPermission;
import com.aerospace.domain.repository.Member;
import com.aerospace.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by coupang on 2017. 7. 19..
 */
@Controller
@RequestMapping({"v1/member"})
public class MemberApiController {
	@Autowired
	private MemberRepository memberRepository;

	public MemberApiController() {
	}

	@ApiPermission
	@RequestMapping({"/{memberSeq}"})
	@ResponseBody
	public Member findMemberDto(@PathVariable("memberSeq") Integer memberSeq) {
		return this.memberRepository.findByMemberSeq(memberSeq);
	}
}
