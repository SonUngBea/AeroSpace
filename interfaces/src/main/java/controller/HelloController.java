package controller;

import com.aerospace.domain.application.DBConnectTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by woongs on 2017. 7. 15..
 */
@Controller
public class HelloController {
//	@Autowired
	private DBConnectTestService dbConnectTestService;

	@RequestMapping(value = "/hello")
	public String hello() {
		return "index";
	}

	@RequestMapping("/db-connect-test")
	public ModelAndView showLoginFrm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/login");
		String id="";
		try {
			id = dbConnectTestService.getId(2);
		} catch (Exception e) {
			System.out.println(e);
		}
		mav.addObject("id", id);

		return mav;
	}
}
