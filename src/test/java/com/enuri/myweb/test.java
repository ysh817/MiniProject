package com.enuri.myweb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.enuri.myweb.util.UserInfoDao;
import com.enuri.myweb.vo.userinfo.UserInfo;


public class test extends AbstractApplicationContextTest{
	@Autowired SqlSession session;
	@Autowired UserInfoDao dao;
	/*@Test
	public void tes() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id("test");
		userInfo.setUser_pw("test");
		
		UserInfo user = dao.getUser(userInfo);
		
		System.out.println(user.getUser_id());
		System.out.println(user.getUser_pw());
	}*/
	
	@Override
	protected void test() {
		//UserInfoDao dao = new UserInfoDao();
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id("test");
		userInfo.setUser_pw("test");
		try {
		UserInfo user = dao.getUser(userInfo);
		//UserInfo user = session.selectOne("UserInfo.getUser", userInfo);
		System.out.println(user.getUser_id());
		System.out.println(user.getUser_pw());
		}catch(Exception e){
			System.out.println("Dd");
		}
		
	}
}
