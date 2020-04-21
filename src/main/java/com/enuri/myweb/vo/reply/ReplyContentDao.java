package com.enuri.myweb.vo.reply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyContentDao {
	@Autowired SqlSession sqlSessionFactory;
	
	public List<ReplyContent> getAllReply(int cnt){
		return sqlSessionFactory.selectList("ReplyContent.getAllReply");
	}
	
	public int getReplyCnt(int cnt) {
		return sqlSessionFactory.selectOne("ReplyContent.getReplyCnt", cnt);
	}
	
	public void insertReply(ReplyContent replyContent) {
		sqlSessionFactory.insert("ReplyContent.insertReply", replyContent);
	}
	
	public void updateReply(ReplyContent replyContent) {
		sqlSessionFactory.update("ReplyContent.updateReply", replyContent);
	}
	public void deleteReply(int rno) {
		sqlSessionFactory.delete("ReplyContent.deleteReply", rno);
	}
	public Integer getMaxReplyCnt(int cnt) {
		return sqlSessionFactory.selectOne("ReplyContent.getMaxReplyCnt",cnt);
	}
	public void deleteReplyOnBoad(int cnt) {
		sqlSessionFactory.delete("ReplyContent.deleteReplyOnBoad", cnt);
	}
	public ReplyContent readReply(int rno){
		
		return sqlSessionFactory.selectOne("ReplyContent.readReply", rno);
	}
}
