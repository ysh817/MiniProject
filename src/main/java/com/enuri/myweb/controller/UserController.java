package com.enuri.myweb.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	LoginService loginService;
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
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
	@GetMapping("/modify_enter")
	public String userModify_ent(){
		return "/user/modify_enter";
	}
	@PostMapping("/modify_enter")
	public String userModify_ent(@ModelAttribute("modifyUser_ent")UserInfo userInfo){
		//비밀번호 입력- 비밀번호 틀리면 정보수정페이지 접근불가
		if(!loginsession.getUser_pw().equals(userInfo.getUser_pw())){
			return "/error/error_notEqual";
		}
		
		return "redirect:/user/modify";
	}
	
	@GetMapping("/modify")
	
	public String usermodify(Model model) {
		System.out.println("C-회워정보수정입구");
		model.addAttribute("modify", loginsession);			
		System.out.println(loginsession.getCrt_dt());
		return "/user/modify";
	}
	
	@PostMapping("/modify")
	public String usermodify(@ModelAttribute("modifyUser") UserInfo userInfo) {
		System.out.println("C-회원정보 수정");
		//비밀번호 입력 - 틀리면 수정안됨
		
		
		

		System.out.println(userInfo.getUser_email());
		loginService.modifyUserInfo(userInfo);
		System.out.println(userInfo.getUser_name());
		System.out.println("테스트아이디:"+userInfo.getUser_id());
		loginService.setloginUsersession(userInfo);	
		//다시 세션에 셋팅
		System.out.println("테스트아이디2:"+userInfo.getUser_id());
		
		return "/user/modifySuccess";
	}

}
