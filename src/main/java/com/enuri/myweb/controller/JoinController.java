package com.enuri.myweb.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.enuri.myweb.service.JoinService;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
public class JoinController {
	@Autowired JoinService joinservice;
	
	
/*	@GetMapping("/join")
	public String join() {
		System.out.println("C-회원가입창 이동");	//

		return "/join";
	}
	*/
	@GetMapping("/join")
	public String join(@ModelAttribute("joinform")UserInfo userInfo) {
		System.out.println("C-회원가입창 이동");	//

		return "/join";
	}
	@PostMapping("/join")
	public String join(@Valid @ModelAttribute("joinform")UserInfo userInfo, Model model, BindingResult result) {	
		//유효성체크
		if(result.hasErrors()) {//true 면 오류있음. 다시 회원가입창으로
			System.out.println("다시 회원가입");
			return "redirect:/join";
		}
		joinservice.userJoin(userInfo);
		//joinservice.joinValidator(userInfo,model);
		System.out.println("ㄻㄴㄹㄴㄹㄹ이");
		return "/joinSuccess";
		
	}
	/*@PostMapping("/join")
	public String join(@Valid @ModelAttribute("joinform")UserInfo userInfo, Model model,BindingResult result) {	
		//유효성체크
		//List list=new ArrayList();
		
		if(result.hasErrors()) {//true 면 오류있음
			
		}
		if(joinservice.joinValidator(userInfo, model)>0) {
			model.addAttribute("error");
			return "/joinFail";
		}
		else {
			joinservice.userJoin(userInfo);
			model.addAttribute("no_error");
			return "/joinSuccess";
		}
		
		//joinservice.joinValidator(userInfo,model);
		
		
		
	}*/
	@ResponseBody
	@PostMapping("/checkUserIdExist")
	public int idCheck(UserInfo userInfo, @RequestParam("user_id")String user_id ) {
		System.out.println("유효성체크를 위한 아이디"+user_id);
		//0이면 아이디중복없음
		return joinservice.checkuserIdExist(user_id);
	}

	//회원가입 시 유효성체크 X
	
	@GetMapping("/joinFail_Test")
	public String jointest() {
		System.out.println("회원가입창 이동2");	

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
