package com.enuri.myweb.vo;

public class MemberLogVo {
	//admin용 유저의 사용기록을 보기 위함 
	
	private String user_id;
	private String access_ip;
	
	
	//날짜 
	private String login_date;
	private String logout_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAccess_ip() {
		return access_ip;
	}
	public void setAccess_ip(String access_ip) {
		this.access_ip = access_ip;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	public String getLogout_date() {
		return logout_date;
	}
	public void setLogout_date(String logout_date) {
		this.logout_date = logout_date;
	}
	
	

}
