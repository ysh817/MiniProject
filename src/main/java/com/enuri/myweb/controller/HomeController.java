package com.enuri.myweb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.service.AdminService;
import com.enuri.myweb.service.JoinService;
import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.userinfo.UserInfo;


//import test4.UserValidator;

@Controller
public class HomeController {
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	@Autowired LoginService loginService;
	@Autowired JoinService joinService;
	@Autowired AdminService adminServicce;
	
	//@Autowired UserValidator uservalidator;
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}*/
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("C-홈 이동");
		
		/**/
		if(loginsession!=null) { //항상 null이 아님
		System.out.println(loginsession.getUser_name());
		}
		else System.out.println("loginsession");
		/**/
		model.addAttribute("loginUser", loginsession);
		
		return "/index";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("LoginUserInfo")UserInfo userInfo ) {
		System.out.println("C-로그인창 이동");
		return "/login";
		
	}
	
	@PostMapping("/login")
	public ModelAndView login_pro(@ModelAttribute("LoginUserInfo")UserInfo userInfo, HttpServletRequest request){ 
		
		ModelAndView mv = new ModelAndView();
		
		
		boolean loginch=loginService.loginCheck(userInfo, request);
		System.out.println("로그인한 유저아이디로2"+userInfo.getUser_id());
		
		if(loginch==false) { //해당 유저 있는지 검사 1
			mv.setViewName("/loginFail");//그냥 해당 뷰 보여줌
		}
		
		else { //로그인 정보 DB에 있을때	
		loginService.setloginUsersession(userInfo);	
		System.out.println("C-로그인한 유저이름으로 :"+loginsession.getUser_name()); //0
		System.out.println("C-로그인 여부 :"+loginsession.isUserlogin());
		
		mv.setViewName("redirect:/board/main");
		}
		
		return mv;
		
		
	}
	
	
	@GetMapping("/logout")
	public String logout(UserInfo userInfo,HttpSession session){
		//세션 지움
		loginService.logout(session);
		//session.removeValue("LoginUser"); //특정 세션목록 삭제?
		
		loginsession.setUserlogin(false);
		System.out.println("false면 로그아웃됨:"+loginsession.isUserlogin());
		System.out.println("C-로그아웃 됨");
		return "redirect:/login";
	}
	
	

	@GetMapping("/board")
	public String board(Model model,UserInfo userInfo) {
		System.out.println("C-게시판창 이동");	
		//String name=loginsession.getUser_name();
		//System.out.println(name);
		//userInfo.getUser_name()은 nll
		return "/board";
	}
	
	@GetMapping("/home")
	public String home() {
		
		return "/home";
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/welcome";
	}
	@GetMapping("/about")
	public String about() {
		
		
		return "/about";
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator = new UserValidator();
		// binder.setValidator(validator1);
		binder.addValidators(validator);
	}*/
	
	
}
