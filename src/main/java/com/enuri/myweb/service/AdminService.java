package com.enuri.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;

@Service
public class AdminService {
	
	@Autowired
	private UserInfoDao dao;
	
	public List<UserInfo> getuserList(UserInfo userInfo) {
		
		ModelAndView mv = new ModelAndView();
		
		List<UserInfo> list = dao.getAllUserList(userInfo);
		
		mv.addObject("userList", list);

		return list;
	}
	
	
	
	
	public boolean userGradeCheck(UserInfo userInfo) {
		String grade= userInfo.getUser_code();
		
		if(!grade.equals("admin")) {
			return false;
		}
		return true;
	}
	
	

}
