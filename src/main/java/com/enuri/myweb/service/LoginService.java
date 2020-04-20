package com.enuri.myweb.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;

@Service
public class LoginService {
	// 로그인 검사
	// 중복 id, email 검사

	// setLogin
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	@Autowired
	UserInfoDao userInfoDao;


	// 로그인 검사는 jsp에서
	// 세션 저장 및 mapper
	
	public boolean loginCheck(UserInfo userInfo, HttpServletRequest request) {
		// 1. loginid, loginpw -> where 절에 넣어서 조회가 되는지 안되는 확인 //setLogin
		// 2. 조회가 된다 -> 그 사용자 정보를 session 사용
		// 3. 조회가 안된다 -> loginfail 페이지
		
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("id=" + id + " pw=" + pw + "로 로그인을 시도하였습니다.");
//---------------------------------------------------
		// 로그인 성공여부를 위해 유저 조회
		UserInfo ch = userInfoDao.login(userInfo); //ch가 null이면 아이디 없음
		
		if (ch==null) {	
			System.out.println("로그인 실패");
			return false;
		}
		System.out.println("유저아이디 존재");		
		return true;

	}
	
	public UserInfo setloginUser(UserInfo userInfo, HttpServletRequest request)
	{
		//유저정보 서버에서 사용할 수 있도록 DB->object로 
		//세션 등록

		UserInfo loginuser=userInfoDao.getUserInfo(userInfo);
		
		HttpSession session = request.getSession(); 
		session.setAttribute("LoginUser", loginuser);
		
		loginuser.setUserlogin(true);//로그인 여부 0
		
		System.out.println("set에서의 유저??: "+loginuser.getUser_name());
		
		return loginuser;
	
	}
	
	public void setloginUsersession(UserInfo userInfo) {
		//세션영역에 로그인 유저정보 저장
		UserInfo loginuser=userInfoDao.getUserInfo(userInfo);
		if(loginuser!=null) {
			loginsession.setUser_id(loginuser.getUser_id());
			loginsession.setUser_name(loginuser.getUser_name());
			loginsession.setUser_code(loginuser.getUser_code());
			loginsession.setUser_pw(loginuser.getUser_pw());
			loginsession.setUser_pw2(loginuser.getUser_pw2());
			loginsession.setCrt_dt(loginuser.getCrt_dt());
			loginsession.setUser_email(loginuser.getUser_email());
			loginsession.setUser_gender(loginuser.getUser_gender());
			loginsession.setIdx(loginuser.getIdx());
			loginsession.setUserlogin(true);
			System.out.println("로그인세션에 정보저장완료");
			
			//HttpSession session = request.getSession(); 
			//session.setAttribute("LoginUser", loginsession);
			//or
			//session.setAttribute("LoginUser", loginuser);
		}
			
	}
	
	/*public void ModifyUserIfo(UserInfo userInfo) {
		//유저정보 수정하기 위해 해당 유저조히
		userInfo.setUser_id(loginsession.getUser_id());
		
		//dao
	}*/
	public void modifyUserInfo(UserInfo userInfo) {
		userInfoDao.updateUserInfo(userInfo);
	}
	

	
	public void logout(HttpSession session) {
		System.out.println("세션정보:"+session);
		session.invalidate();
		
		//session.setAttribute("LoginUser", null);
	}

}

