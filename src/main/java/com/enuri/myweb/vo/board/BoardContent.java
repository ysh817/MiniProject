package com.enuri.myweb.vo.board;

import javax.validation.constraints.NotEmpty;

public class BoardContent {
	
	@NotEmpty(message="제목을 입력하세요")
	private String title;
	private String user_id;
	
	@NotEmpty(message="내용을 입력하세요")
	private String content;
	private String regdate;
	private int cnt;
	private int hit;
	private int recnt;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	
	
	

}
