package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by coupang on 2017. 7. 15..
 */
@Controller
public class HelloController {
	@RequestMapping(value = "/hello")
	public String hello() {
		return "index";
	}
}
