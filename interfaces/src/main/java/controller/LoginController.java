package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by coupang on 2017. 7. 15..
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/showLoginFrm")
	public ModelAndView showLoginFrm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/login");
		mav.addObject("id", "arnold");

		return mav;
	}
}
