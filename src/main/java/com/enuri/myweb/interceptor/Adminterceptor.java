package com.enuri.myweb.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.enuri.myweb.vo.userinfo.UserInfo;

public class Adminterceptor implements HandlerInterceptor{
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(!loginsession.getUser_code().equals("admin") ) {
			response.sendRedirect(request.getContextPath()+"/error/error_noAccess");
			return false;
		}
		
		return true;
	}

}
