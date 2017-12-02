package controller;

import com.aerospace.domain.application.DBConnectTestService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

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

	@RequestMapping(value = "/songree")
	public ModelAndView songree() {
		ModelAndView mnv =  new ModelAndView();
		mnv.setViewName("main");

		Calendar today = Calendar.getInstance(); //현재 오늘 날짜
		Calendar dday = Calendar.getInstance();


		dday.set(2014, 1,9);// D-day의 날짜를 입력합니다.


		long day = dday.getTimeInMillis()/86400000;
		// 각각 날의 시간 값을 얻어온 다음
		//( 1일의 값(86400000 = 24시간 * 60분 * 60초 * 1000(1초값) ) )

		long tday = today.getTimeInMillis()/86400000;
		long count = tday - day; // 오늘 날짜에서 dday 날짜를 빼주게 됩니다.
		long result = count + 1;
		mnv.addObject("day", Long.toString(result));
		return mnv;
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
