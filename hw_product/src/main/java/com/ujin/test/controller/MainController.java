package com.ujin.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	// index로 보내주는 컨트롤러
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
