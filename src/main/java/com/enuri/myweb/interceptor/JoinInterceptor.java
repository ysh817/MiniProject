package com.enuri.myweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class JoinInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		/*System.out.println("join 인터셉터실행");
		//로그인된 아이디 있으면 회원가입 불가
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			System.out.println("이미 로그인된 아이디 존재");
			response.sendRedirect(request.getContextPath()+"/user/loginError");
			return false;
		}*/
		return true;
	}

}
