package com.enuri.myweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enuri.myweb.vo.page.PageMaker;
import com.enuri.myweb.vo.userinfo.UserInfo;
import com.enuri.myweb.vo.userinfo.UserInfoDao;

@Service
public class AdminService {
	
	@Autowired
	private UserInfoDao dao;
	@Resource(name="loginsession")
	@Lazy UserInfo loginsession;
	
	static int pageCnt =10; //페이지당 10게시물
	static int pageRange = 10; //뜨는 페이지번호갯수
	
	/*
	public List<UserInfo> getuserList(UserInfo userInfo) {
		
		ModelAndView mv = new ModelAndView();
		
		List<UserInfo> list = dao.getAllUserList(userInfo);
		
		mv.addObject("userList", list);

		return list;
	}*/
	
	public List<UserInfo> getAllUser(int page){	
		int start = (page-1)*pageCnt;
		RowBounds rowBounds = new RowBounds(start, pageCnt);
		return dao.getAllUserList(rowBounds);
	}
	
	//페이징
		public PageMaker getPaging(int currentPage) {
			int contentCnt = dao.getCntUser();
			PageMaker page = new PageMaker(contentCnt, currentPage, pageCnt, pageRange);
			return page;
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
