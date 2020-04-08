package com.enuri.myweb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enuri.myweb.vo.userinfo.UserInfo;


@Repository
public class UserInfoDao {
	@Autowired SqlSession sqlSessionFactory;
	
	/*
	@Autowired
	SqlSessionTemplate sqlsesiontemplate;*/

/*	public String idCheck() {
		UserInfo info = session.sels
		return "";
		
	}*/
	private static String namespace = "UserInfo";
	/*
	public List<UserInfo> getUserInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return sqlsesiontemplate.selectOne(namespace+"."+"getUserInfo", userinfo);
		
		*/
	
	public List<UserInfo> getAllUserInfo() {
		
		return null;
	}

	public UserInfo getUserInfo(UserInfo userInfo) {

		return null;
	}

	public UserInfo getUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		System.out.println("dd");
		
		return sqlSessionFactory.selectOne("UserInfo.getUser", userInfo);
	}

	public void joinUser(UserInfo userinfo) {
		
		
	}
	
	
	

}
