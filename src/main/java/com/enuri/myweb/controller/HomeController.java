package com.enuri.myweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
public class HomeController {
	
	//@Resource UserInfo userInfoVo;
	@Autowired LoginService loginService;
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}*/
	
	@GetMapping("/")
	public String home() {
		System.out.println("hommmmmmmm");
		return "/index";
	}
	
	@GetMapping("/login")
	public String login( ) {
		System.out.println("looooooooogin");	
		return "/login";
		
	}
	
	@PostMapping("/login")
	public ModelAndView login (UserInfo userinfo, HttpServletRequest request){ 
		ModelAndView mv = new ModelAndView();
		mv.setViewName(loginService.loginCheck(userinfo, request));
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		//세션 지움
		
		return "redirect:/";
	}
	
	
	/*@GetMapping("/join")
	public String join(UserInfo userInfo) {
		
		return "/join";
	}
	*/
	@PostMapping("/join")
	public int join(UserInfo userinfo) {
		
		return 0;
	}
	
	
	@GetMapping("/board")
	public String board_main() {
		return "/board/main";
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/welcome";
	}
	
	
}
