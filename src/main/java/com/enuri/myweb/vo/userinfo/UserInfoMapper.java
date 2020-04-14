package com.enuri.myweb.vo.userinfo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface UserInfoMapper {

	
	public List<UserInfo> getAllUserInfo();
	public UserInfo getUserInfo(UserInfo userInfo); //2
	public UserInfo getUser(UserInfo userInfo);
	public UserInfo login(UserInfo userInfo);
	//public List<UserInfo> getUser(HashMap<String, Object> paramMap);
	public void joinUser(UserInfo userinfo);
	//회원가입(insert)
	
	/*public int updateUser(UserInfo userinfo);
	//회원가입 수정,
*/	
	//public int deleteUser(UserInfo userinfo);
	//회원탈퇴
	
	
	
}
