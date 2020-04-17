package com.enuri.myweb.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.enuri.myweb.vo.userinfo.UserInfo;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인 안했을때
		//board, user, admin, logout 접근 불가
		//로그인 후 사용하세요
		
		if(loginsession.isUserlogin()==false) {
			response.sendRedirect(request.getContextPath()+"/error/error_nologin");
			return false;
		}
		
		
	/*	System.out.println("login 인터셉터실행");
		//로그인 안되있을시 게시판,admin/**,user/** 못들감 
		//--login서비스에서 세션 등록
		//HttpSession session = request.getSession(false);
		HttpSession session = (HttpSession) request.getSession().getAttribute("LoginUser");
		
		if(session==null) {
			System.out.println("login 인터셉터실행: 세션정보없음");
			//response.sendRedirect(request.getContextPath()+"/");
			response.sendRedirect(request.getContextPath()+"/error/error_nologin");
			return false;
		}
		System.out.println("login 인터셉터실행 :");
		//UserInfo loginUser=(UserInfo)session.getAttribute("LoginUser");
		//System.out.println(userInfo.isUserlogin());
		
		
		//request.setAttribute("loginUser", loginUser);
		*/
		return true;
	}
}
