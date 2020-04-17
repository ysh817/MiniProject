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

		System.out.println("DB에 회원정보 저장완료");//
		
	}
	public List<UserInfo> getAllUserList() {
		//admin이 회원정보를 관리하기 위해 유저목록 페이지에 갖고 올 리스트
		return sqlSessionFactory.selectList("UserInfo.getAllUserList");		
	}
	public void updateUserInfo(UserInfo userinfo) {
		//user/user_modify
		sqlSessionFactory.update("UserInfo.modifyUser", userinfo);
		System.out.println("DB에 회원정보 수정완료");
	}
	public void updateaAminUserInfo(UserInfo userinfo) {
		sqlSessionFactory.update("UserInfo.adminModifyUser", userinfo);
		System.out.println("DAOOOO"+userinfo.getUser_id());
		System.out.println("DB에 admin회원정보 수정완료");
	}
	public UserInfo getAdminModifyUserInfo(String userId) {
		//admin 사용자관리 페이지 -특정 유저 조회/수정
		System.out.println("DB에 admin회원정보 수정을 위한 유저read");
		return sqlSessionFactory.selectOne("UserInfo.getAdminModifyUserInfo",userId);
		
	}
	public int getIDExist(String user_id) {
		return sqlSessionFactory.selectOne("UserInfo.getIDExist",user_id);
	}

	
	
	

}
