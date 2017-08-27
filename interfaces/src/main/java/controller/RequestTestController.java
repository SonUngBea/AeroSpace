package controller;

import dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

/**
 * Created by coupang on 2017. 8. 21..
 */
@Controller
@Slf4j
@RequestMapping("/test")
public class RequestTestController {

	// ============== test

	@RequestMapping("/model")
	public ModelAndView modelAttributeTest(@ModelAttribute("test") TestDto testDto) {
		ModelAndView mav = new ModelAndView("bindingTest");

		mav.addObject("result", "modelAttr");
		return mav;
	}

	@RequestMapping("/requestBody")
	@ResponseBody
	public String requestBodyTest(@RequestBody TestDto testDto) {
		return "success";
	}

	@RequestMapping("async")
	@ResponseBody
	public Callable<String> asyncTest(@RequestParam String memberSeq) {
		return new Callable<String>() {
			public String call() throws Exception {
				try {
					Thread.currentThread().sleep(2000L);
				} catch (InterruptedException e) {
					log.info("thread Exception");
				}
				throw new RuntimeException();

				//				return "success";
			}
		};
	}
}
