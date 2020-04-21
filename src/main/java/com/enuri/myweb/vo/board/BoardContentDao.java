package com.enuri.myweb.vo.board;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BoardContentDao {
	
	@Autowired SqlSession sqlSessionFactory;
		
	/*public List<BoardContent> getBoardList(){
		List<BoardContent> List = sqlSessionFactory.selectList("BoardContent.getBoardList");
		return List;
	}*/
	public List<BoardContent> getBoardList(RowBounds rowBounds){
		List<BoardContent> List = sqlSessionFactory.selectList("BoardContent.getBoardList",null,rowBounds);
		return List;
	}
	
	public void insertBoard(BoardContent boardContent) {
		//글 쓰기	
		sqlSessionFactory.insert("BoardContent.insertBoard", boardContent);	
		System.out.println("DB에 글쓰기 저장 완료");
		
	}


	public int getBoardCount() {

		System.out.println("getBoardCOunt()");

		//return sqlSessionFactory.selectOne("BoardContent.getBoardCount");
		int c = sqlSessionFactory.selectOne("BoardContent.getBoardCount");
		System.out.println(c);
		return c;
		
	}

	public String getBoardWrier() {
		//user용 - 글작성 유저의 정보 조회	
		return "";
	}
	public BoardContent readContent(int cnt){
		//작성한 게시글 보기 - 한 행
		return sqlSessionFactory.selectOne("BoardContent.readBoard", cnt);
		
	}
	
	public void updateContent(BoardContent boardcontet) {
		//게시글 수정		
		sqlSessionFactory.update("BoardContent.updateBoard",boardcontet);
	}
	public void deleteContent(int cnt) {
		//게시글 삭제
		sqlSessionFactory.delete("BoardContent.deleteBoard", cnt);
		System.out.println("게시글 DB삭제 완료");
	}
	public Integer getMaxCnt() {
		return sqlSessionFactory.selectOne("BoardContent.getMaxCnt");
	}
	public int checkEqualCnt(int cnt) {
		return sqlSessionFactory.selectOne("BoardContent.checkEqualCnt",cnt);
	}
	public void updateHits(int cnt) {
		//조회수 증가
		sqlSessionFactory.update("BoardContent.updateHits", cnt);
	}
	public void updateReplyCnts(int cnt) {
		sqlSessionFactory.update("BoardContent.updateReplyCnts", cnt);
	}
	public void updateReplyCntM(int cnt) {
		sqlSessionFactory.update("BoardContent.updateReplyCntM", cnt);
	}

	

}
