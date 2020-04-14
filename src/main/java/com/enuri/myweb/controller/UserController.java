package com.enuri.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/logoutSuccess")
	public String logoutSuccess() {
		System.out.println("로그아웃됨");	
		return "/user/logoutSuccess";
	}
	
	
	@GetMapping("/loginError")
	public String loginError() {
		System.out.println("이미 로그인함");	
		return "/user/loginError";
	}

}
