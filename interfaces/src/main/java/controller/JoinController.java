package controller;

import com.aerospace.domain.application.MemberJoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by coupang on 2017. 7. 16..
 */
@Controller
@Slf4j
public class JoinController {

	@Autowired
	private MemberJoinService memberJoinService;

	@RequestMapping("/showJoinFrm")
	public String showLoginFrm() {
		return "/join/joinFrm";
	}

	@RequestMapping("/join")
	@ResponseBody
	public String join(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password,
		@RequestParam(value = "name") String name) {
		memberJoinService.join(email, password, name);

		return "success";
	}
}
