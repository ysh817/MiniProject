package com.enuri.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.service.AdminService;
import com.enuri.myweb.service.JoinService;
import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserValidator;

//import test4.UserValidator;

@Controller
public class HomeController {
	
	//@Resource UserInfo userInfoVo;
	@Autowired LoginService loginService;
	@Autowired JoinService joinService;
	@Autowired AdminService adminServicce;
	
	//@Autowired UserValidator uservalidator;
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}*/
	
	@GetMapping("/")
	public String home() {
		System.out.println("홈 이동");
		return "/index";
	}
	
	@GetMapping("/login")
	public String login( ) {
		System.out.println("로그인창 이동");	
		return "/login";
		
	}
	
	@PostMapping("/login")
	public ModelAndView login (UserInfo userInfo, HttpServletRequest request){ 
		ModelAndView mv = new ModelAndView();
		mv.setViewName(loginService.loginCheck(userInfo, request));
				
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		//세션 지움
		loginService.logout(session);
		System.out.println("로그아웃 됨");	
		return "redirect:/";
	}

	@GetMapping("/board")
	public String board_main() {
		System.out.println("게시판창 이동");	
		return "/board/main";
	}
	
	@GetMapping("/user")
	public String user() {
		
		return "/user";
	}
	@GetMapping("/user/user_list")
	public ModelAndView user_list(UserInfo userInfo, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		if(!adminServicce.userGradeCheck(userInfo)) {
			mv.setViewName("redirect:/");
			//일반유저 접근 못하도록 두번 
			//1. 홈 창에서 뜨지 않게
			//2. 리다이렉트 or 오류 alert
		}
		
		//List<UserInfo> list = dao.getAllUserList(userInfo);
		
		//mv.addObject("userList", list);
		else mv.setViewName("user_list");
		
		return mv;
	}
	
	//test
/*	@GetMapping("/joinTest")
	public String test() {
		System.out.println("회원가입 테스트");
		return "/joinTest";
	}*/
	
	/*@GetMapping("/joinTest")
	public String test(@ModelAttribute("joinformm") UserInfo joinformm) {
		System.out.println("회원가입 테스트");
		return "/joinTest";
	}
	
	@PostMapping("/joinTest")
	public String test2(@Valid @RequestParam("joinformm") UserInfo joinformm, BindingResult result ) {
		System.out.println(joinformm.getUser_id());
		
		if(result.hasErrors()) {
			//true면 오류있음
			return "/joinTest";
		}
		
		
		System.out.println("가입?");
		return "/joinSuccess";
	}*/
	
	//
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/welcome";
	}
	
	
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator = new UserValidator();
		// binder.setValidator(validator1);
		binder.addValidators(validator);
	}*/
	
	
}
