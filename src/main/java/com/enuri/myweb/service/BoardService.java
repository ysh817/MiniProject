package com.enuri.myweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf

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
<<<<<<< HEAD
		boardContentDao.insertBoard(boardcontent);
	}
	
	public List<BoardContent> getBoardList(){

		return boardContentDao.getBoardList();		
		
	}
=======
		
		
		
		boardContentDao.insertBoard(boardcontent);
	}
	
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
	

}
