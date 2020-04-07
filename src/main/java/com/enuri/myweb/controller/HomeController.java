package com.enuri.myweb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.vo.userinfo.UserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//@Resource UserInfo userInfoVo;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
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
	public String login() {
		System.out.println("looooooooogin");
		return "/login";
		
	}
	
	@GetMapping("/join")
	public String join() {
		//mapperl.set
		return "/join";
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
