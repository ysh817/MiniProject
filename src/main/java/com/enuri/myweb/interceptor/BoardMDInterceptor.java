package com.enuri.myweb.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.enuri.myweb.vo.userinfo.UserInfo;

public class BoardMDInterceptor implements HandlerInterceptor{
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//수정 삭제 //admin, user_id같을때만 가능
		
		
		return true;
	}

}
