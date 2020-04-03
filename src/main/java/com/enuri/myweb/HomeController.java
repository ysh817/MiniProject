package com.enuri.myweb;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.service.LoginService;
import com.enuri.vo.UserInfoVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource UserInfoVo userInfoVo;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "home";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		//로그인 성공 시 board
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:" + LoginService.doGet(request, response));
		return mv;
		
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	
}
