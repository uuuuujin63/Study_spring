package com.ujin.test.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.ujin.test.model.MemberDto;
import com.ujin.test.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
		return "redirect:/";
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) throws Exception  {
		System.out.println("============="+map.get("userId"));
		logger.debug("map : {}", map.get("userId"));
		MemberDto memberDto = memberService.login(map);
		if(memberDto != null) {
			session.setAttribute("userinfo", memberDto);
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
