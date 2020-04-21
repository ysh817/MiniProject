package com.enuri.myweb.vo.reply;

import javax.validation.constraints.NotEmpty;

public class ReplyContent {
	private int cnt; //게시글 번호
	private int rno; //댓글번호(순서, id) cnt-rno : 고유번호
	private String user_name;
	private String user_id;
	
	@NotEmpty(message="댓글 내용을 입력하세요")
	private String content;
	private String regdate;
	private String up_regdate;
	private int up_no;
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUp_regdate() {
		return up_regdate;
	}
	public void setUp_regdate(String up_regdate) {
		this.up_regdate = up_regdate;
	}
	public int getUp_no() {
		return up_no;
	}
	public void setUp_no(int up_no) {
		this.up_no = up_no;
	}
	
	
	
}
