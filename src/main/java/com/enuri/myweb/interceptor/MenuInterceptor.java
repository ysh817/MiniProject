package com.enuri.myweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MenuInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// admin과 user 구분
		// board, 회원수정메뉴 ,로그인 시 메뉴창 구분
		
		//수정 삭제 //admin, user_id같을때만 가능
		
		//System.out.println("menu 인터셉터실행");
		
		
		return true;
	}
}
