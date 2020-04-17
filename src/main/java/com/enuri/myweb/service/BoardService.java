package com.enuri.myweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enuri.myweb.vo.board.BoardContent;
import com.enuri.myweb.vo.board.BoardContentDao;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Service
public class BoardService {
	
	@Autowired
	private BoardContentDao boardContentDao;
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	public void writeBoard(BoardContent boardcontent) {
		//글쓰기
		//날짜, 작성자, cnt는 서버에서 set
		boardcontent.setRegdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		boardcontent.setUser_id(loginsession.getUser_id());
		boardcontent.setCnt(maxCntPlus());//cnt 0부터
		boardcontent.setHit(0);//조회수 0부터
		
		System.out.println(boardcontent.getCnt());

		boardContentDao.insertBoard(boardcontent);
	}
	
	public int setCnt() {
		return boardContentDao.getBoardCount()+1;
	}
	
	public List<BoardContent> getBoardList(){

		return boardContentDao.getBoardList();		
		
	}
	//수정, 삭제
	
	
	public BoardContent readBoardContent(int cnt){
		//작성한 게시글 조회
		return boardContentDao.readContent(cnt);
	}
	
	public void modifyBoardContent(BoardContent boardcontet) {
		//게시글 수정
		boardContentDao.updateContent(boardcontet);
	}
	public void deleteBoardContent(int cnt) {
		//게시글 삭제
		boardContentDao.deleteContent(cnt);
		
	}
	public Integer maxCntPlus() {
		return boardContentDao.getMaxCnt()+1;
	}
	public int EqualCnt(int cnt) {
		return boardContentDao.checkEqualCnt(cnt);
	}
	
	public void updateHit(int cnt) {
		boardContentDao.updateHits(cnt);
	}
	


	

}
