package com.enuri.myweb.vo.userinfo;


import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



public class UserInfo {
	
	//@Size(max=20, message="아이디는 20자 미만")
	@Pattern(regexp = "[a-zA-Z0-9]*", message="알파벳과 숫자만 허용")
	@NotEmpty(message="아이디를 입력하세요")
	private String user_id;
	
	@NotEmpty(message="패스워드를 입력하세요")
	private String user_pw;
	
	@NotEmpty(message="패스워드 다시 입력해 주세요")
	private String user_pw2;
	
	//@Pattern(regexp = "[가-힣]*")
	@NotEmpty(message="이름을 입력하세요")
	private String user_name;
	
	@Pattern(regexp="^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$"
			,message="이메일의 형식이 아닙니다" )
	@NotEmpty(message="이메일을 입력하세요")
	private String user_email;
	
	private String user_gender;
	
	
	private String crt_dt;
	private String user_code;
	private int idx;

	private boolean userlogin;
	//private boolean dulcheck;



	public UserInfo() {
		
		this.setUserlogin(false);
		//this.setDulcheck(false);

	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getCrt_dt() {
		return crt_dt;
	}
	public void setCrt_dt(String crt_dt) {
		
		this.crt_dt = crt_dt;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}


	public boolean isUserlogin() {
		return userlogin;
	}

	public void setUserlogin(boolean userlogin) {
		this.userlogin = userlogin;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}
	

	

	






}
