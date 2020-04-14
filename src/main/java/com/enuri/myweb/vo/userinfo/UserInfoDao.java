package com.enuri.myweb.vo.userinfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		return sqlSessionFactory.selectList("UserInfo.getAllUserInfo");
	}

	public UserInfo getUserInfo(UserInfo userInfo) {
		//로그인 후에 id,pw일치한 회원의 DB에 있는 회원정보를 userInfo에 넣어줌

		return sqlSessionFactory.selectOne("UserInfo.getUserInfo",userInfo);
	}

	public UserInfo getUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
	
		return sqlSessionFactory.selectOne("UserInfo.getUser", userInfo);
	}

	public UserInfo login(UserInfo userInfo) {
		// TODO Auto-generated method stub
	
		return sqlSessionFactory.selectOne("UserInfo.login", userInfo);
	}

	public void joinUser(UserInfo userinfo) {
		sqlSessionFactory.insert("UserInfo.joinUser", userinfo);
<<<<<<< HEAD:src/main/java/com/enuri/myweb/vo/userinfo/UserInfoDao.java
		System.out.println("DB에 회원정보 저장완료");//
=======
		System.out.println("join");
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf:src/main/java/com/enuri/myweb/vo/userinfo/UserInfoDao.java
		
	}
	public List<UserInfo> getAllUserList(UserInfo userinfo) {
		//admin이 회원정보를 관리하기 위해 유저목록 페이지에 갖고 올 리스트
		return sqlSessionFactory.selectList("UserInfo.getAllUserList");		
	}

	
	
	

}
