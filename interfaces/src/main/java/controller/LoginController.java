package controller;

import com.aerospace.domain.application.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by coupang on 2017. 7. 15..
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/showLoginFrm")
	public ModelAndView showLoginFrm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/login");
		mav.addObject("id", "arnold");

		return mav;
	}

	@RequestMapping("/loginProcess")
	@ResponseBody
	public String loginProcess(@RequestParam String email, @RequestParam String password) {
		if (!loginService.isLoginSuccess(email, password)) {
			return "fail";
		}

		return "success";
	}
}
