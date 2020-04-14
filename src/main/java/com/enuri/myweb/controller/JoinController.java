package com.enuri.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.enuri.myweb.service.JoinService;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
public class JoinController {
	@Autowired JoinService joinservice;
	
	
	@GetMapping("/join")
	public String join() {
		System.out.println("회원가입창 이동");	
		return "/join";
	}
	
	@PostMapping("/join")
	public String join( @ModelAttribute("joinform")UserInfo userInfo) {	
		joinservice.userJoin(userInfo);
		//joinservice.joinValidator(userInfo,model);

		System.out.println("회원가입 입구");

		return "/joinSuccess";
		
	}
	
	@GetMapping("/joinFail_Test")
	public String jointest() {
		System.out.println("회원가입창 이동");	
		return "/join";
	}
	
	@PostMapping("/joinFail_Test")
	public String jointest( @ModelAttribute("joinformm")UserInfo userInfo) {	
		System.out.println("회원가입 입구");
		joinservice.userJoin(userInfo);
		//joinservice.joinValidator(userInfo,model);

		System.out.println("회원가입 출구");

		return "/joinSuccess";
		
	}
	
}
