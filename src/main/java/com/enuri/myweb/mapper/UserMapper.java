package com.enuri.myweb.mapper;

import java.util.List;

import javax.xml.crypto.Data;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.enuri.myweb.vo.UserInfoVo;

@Mapper
public interface UserMapper {
	
	//@Insert("insert into table_name (a, b, c) values (#{a}, #{b}, #{c})")
	//public void setMongoLogData(UserInfoVo userinfo);
  
 
	@Select("select * from USER_INO")
    public UserInfoVo getAllUertInfo();
	//전체 유저정보
	
	@Select("SELECT * FROM USER_INFO WHERE USER_ID = #{userId}")
    public UserInfoVo getUserInfo(@Param("userId") String userId);
	//특정 유저정보
	
}
