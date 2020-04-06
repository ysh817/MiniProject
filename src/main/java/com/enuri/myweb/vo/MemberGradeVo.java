package com.enuri.myweb.vo;

public class MemberGradeVo {
	private String id; //임시 id =index
	private String user_code;
	private String member_grade; //1=admin, 2=step, 3=user
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getMember_grade() {
		return member_grade;
	}
	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}
	
	

}
