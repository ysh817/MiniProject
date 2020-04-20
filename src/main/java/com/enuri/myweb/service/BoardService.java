package com.enuri.myweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enuri.myweb.vo.board.BoardContent;
import com.enuri.myweb.vo.board.BoardContentDao;
import com.enuri.myweb.vo.page.PageMaker;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Service
public class BoardService {
	
	@Autowired
	private BoardContentDao boardContentDao;
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	static int pageCnt =10; //페이지당 10게시물
	static int pageRange = 10; //뜨는 페이지번호갯수
	
	public void writeBoard(BoardContent boardcontent) {
		//글쓰기
		//날짜, 작성자, cnt는 서버에서 set
		
		//for(int i=0; i<100; i++) {
		boardcontent.setRegdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		boardcontent.setUser_id(loginsession.getUser_id());
		boardcontent.setCnt(maxCntPlus());//cnt 0부터
		boardcontent.setHit(0);//조회수 0부터
		boardcontent.setRecnt(0);//댓글 수
		
		//System.out.println(boardcontent.getCnt());

		boardContentDao.insertBoard(boardcontent);
		//}
	}
	
	public int setCnt() {
		return boardContentDao.getBoardCount()+1;
	}
	
	public List<BoardContent> getBoardList(int page){
		
		int start = (page-1)*pageCnt;
		RowBounds rowBounds = new RowBounds(start, pageCnt);
		
		return boardContentDao.getBoardList(rowBounds);		
		
	}
	/*public List<BoardContent> getBoardList(){

		return boardContentDao.getBoardList();		
		
	}*/
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
	
	//페이징
	public PageMaker getPaging(int currentPage) {
		int contentCnt = boardContentDao.getMaxCnt();
		PageMaker page = new PageMaker(contentCnt, currentPage, pageCnt, pageRange);
		return page;
	}


	

}
