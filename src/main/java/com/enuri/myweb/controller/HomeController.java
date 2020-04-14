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
	@Lazy
	private UserInfo loginsession;
	
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
		System.out.println("C-홈 이동");
		if(loginsession!=null) {
		System.out.println(loginsession.getUser_name());
		}
		else System.out.println("loginsession 에 정보 없음");
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
		
		//System.out.println("로그인 여부2"+loginsession.isUserlogin());
		
		if(loginch==false) { //해당 유저 있는지 검사 1
			mv.setViewName("/loginFail");//그냥 해당 뷰 보여줌
		}
		
		
		else { //로그인 정보 DB에 있을때
		
		loginsession=loginService.setloginUser(userInfo,request);
		System.out.println("로그인한 유저이름으로4 :"+loginsession.getUser_name()); //0
		
		UserInfo loginUser =loginService.setloginUser(userInfo,request);
		System.out.println("로그인한 유저이름으로3 :"+loginUser.getUser_name());//0
		
		System.out.println("로그인한 유저이메일로5 :"+loginUser.getUser_email()); //0
		//mv.setViewName("redirect:/board/main"); //url 요청 다시하여 기능 다시 실행
		mv.setViewName("redirect:/board/main");
		}
		
		return mv;
		
	
		
	}
	
	
	@GetMapping("/logout")
	public String logout(UserInfo userInfo,HttpSession session){
		//세션 지움
		loginService.logout(session);
		//session.removeValue("LoginUser"); //특정 세션목록 삭제?
		//loginsession.setUserlogin(true);// 세션영역 로그인여부 false
		
		System.out.println("C-로그아웃 됨");
		System.out.println("로그아웃 후 세션"+session);
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
