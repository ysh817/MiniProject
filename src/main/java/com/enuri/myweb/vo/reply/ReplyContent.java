package com.enuri.myweb.vo.reply;


public class ReplyContent {
	private int cnt; //게시글 번호
	private int rno; //댓글번호(순서) cnt-rno
	private String user_name;
	private String user_id;
	private String content;
	private String regdate;
	private String up_regdate;
	
	
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
	
	
}
