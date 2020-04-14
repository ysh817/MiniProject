package com.enuri.myweb.vo.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BoardContentDao {
	
	@Autowired SqlSession sqlSessionFactory;
		
	public List<BoardContent> getBoardList(){
		List<BoardContent> List = sqlSessionFactory.selectList("BoardContent.getBoardList");
		return List;
	}
	
	public void insertBoard(BoardContent boardContent) {
		//글 쓰기
		sqlSessionFactory.insert("BoardContent.insertBoard", boardContent);
		System.out.println("글쓰기");
		
	}

	public int updateBoard(BoardContent boardcontet) {
		return 0;
	}
	
	public int getBoardCount() {
		System.out.println("getBoardCOunt()");
		//return sqlSessionFactory.selectOne("BoardContent.getBoardCount");
		int c = sqlSessionFactory.selectOne("BoardContent.getBoardCount");
		System.out.println(c);
		return c;
		
	}

}
