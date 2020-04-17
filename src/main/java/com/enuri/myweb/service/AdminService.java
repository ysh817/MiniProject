package com.enuri.myweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;

@Service
public class AdminService {
	
	@Autowired
	private UserInfoDao dao;
	@Resource(name="loginsession")
	@Lazy UserInfo loginsession;
	/*
	public List<UserInfo> getuserList(UserInfo userInfo) {
		
		ModelAndView mv = new ModelAndView();
		
		List<UserInfo> list = dao.getAllUserList(userInfo);
		
		mv.addObject("userList", list);

		return list;
	}*/
	
	public List<UserInfo> getAllUser(){		
		return dao.getAllUserList();
	}
	
	
	public boolean userGradeCheck(UserInfo userInfo) {
		String grade= userInfo.getUser_code();
		
		if(!grade.equals("admin")) {
			return false;
		}
		return true;
	}
	public void updateaAdminUserInfo(UserInfo userInfo) {
		dao.updateaAminUserInfo(userInfo);
	}
	public UserInfo getModifyUserInfo(String userId) {
		return dao.getAdminModifyUserInfo(userId);
	}

}
