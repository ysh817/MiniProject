package com.enuri.myweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuri.myweb.vo.board.BoardContent;
import com.enuri.myweb.vo.board.BoardContentDao;

@Service
public class BoardService {
	
	@Autowired
	private BoardContentDao boardContentDao;
	
	public void writeBoard(BoardContent boardcontent) {
		//글쓰기
		boardcontent.setRegdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		
		
		boardContentDao.insertBoard(boardcontent);
	}
	
	

}
