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
<<<<<<< HEAD
		System.out.println("C-회원가입창 이동");	//
=======
		System.out.println("회원가입창 이동");	
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
		return "/join";
	}
	
	@PostMapping("/join")
	public String join( @ModelAttribute("joinform")UserInfo userInfo) {	
		joinservice.userJoin(userInfo);
		//joinservice.joinValidator(userInfo,model);

<<<<<<< HEAD
=======
		System.out.println("회원가입 입구");

>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
		return "/joinSuccess";
		
	}
	
<<<<<<< HEAD
	//회원가입 시 유효성체크 X
	
	@GetMapping("/joinFail_Test")
	public String jointest() {
		System.out.println("회원가입창 이동2");	
=======
	@GetMapping("/joinFail_Test")
	public String jointest() {
		System.out.println("회원가입창 이동");	
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
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
