package com.enuri.myweb.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;

@Service
public class JoinService {
	@Autowired
	UserInfoDao userInfoDao;
	

	public void userJoin(UserInfo userInfo) {
		userInfo.setCrt_dt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		// 현재시간 셋팅
		
		userInfoDao.joinUser(userInfo);
	}
	
	
	public String joinValidator(UserInfo userInfo,Model model) {
		//오류갯수 반환
		int error=0;
		if(userInfo.getUser_id().contains("")) {
			model.addAttribute("error_user_id", "아이디를 입력하세요");
			error++;	
		}
		if(userInfo.getUser_pw().contains("")) {
			model.addAttribute("error_user_pw","비밀번호를 입력하세요");
			error++;	
		}
		if(userInfo.getUser_pw2().contains("")) {
			model.addAttribute("error_user_pw2","비밀번호를 입력하세요");
			error++;	
		}
		if(userInfo.getUser_id().contains("")) {
			model.addAttribute("error_user_id","이름을 입력하세요");
			error++;	
		}
		if(userInfo.getUser_email().contains("")) {
			model.addAttribute("error_user_email","이메일을 입력하세요");
			error++;	
		}
		if(userInfo.getUser_pw().equals(userInfo.getUser_pw2())) {
			model.addAttribute("error_user_pw_match","비밀번호가 일치하지 않습니다");
			error++;
		}
		
		
		if(error>0) {
			return "/joinFail_Test";
		}	
		return "/joinSuccess";
	}
	
	public ModelAndView chk(UserInfo userInfo) {
		ModelAndView mv = new ModelAndView(); 
		if(vali(userInfo).isEmpty())
			userInfoDao.joinUser(userInfo);
			
		return mv;
	}
	
	public ModelAndView vali(UserInfo userInfo) {
		ModelAndView mv = new ModelAndView();
		
		int error=0;
		if(userInfo.getUser_id().contains("")) {
			//model.addAttribute("error_user_id", "아이디를 입력하세요");
			mv.addObject("error_user_id", "아이디를 입력하세요");
			
			error++;
		
		}
		if(userInfo.getUser_pw().contains("")) {
			//model.addAttribute("error_user_pw","비밀번호를 입력하세요");
			mv.addObject("error_user_pw", "비밀번호를 입력하세요");
			error++;

		}
		if(userInfo.getUser_pw2().contains("")) {
			//model.addAttribute("error_user_pw2","비밀번호를 입력하세요");
			mv.addObject("error_user_pw2", "비밀번호를 입력하세요");
			error++;	
			
		}
		if(userInfo.getUser_id().contains("")) {
			//model.addAttribute("error_user_id","이름을 입력하세요");
			error++;
		
		}
		if(userInfo.getUser_email().contains("")) {
			//model.addAttribute("error_user_email","이메일을 입력하세요");
			error++;
		
		}
		if(userInfo.getUser_pw().equals(userInfo.getUser_pw2())) {
			//model.addAttribute("error_user_pw_match","비밀번호가 일치하지 않습니다");
			error++;
			
		}
		
		return mv;
	}

}
