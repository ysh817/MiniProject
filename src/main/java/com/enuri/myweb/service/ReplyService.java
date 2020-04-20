package com.enuri.myweb.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enuri.myweb.vo.reply.ReplyContent;
import com.enuri.myweb.vo.reply.ReplyContentDao;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Service
public class ReplyService {
	
	@Resource(name = "loginsession")
	@Lazy UserInfo loginsession;
	
	@Autowired
	private ReplyContentDao replyContentDao;
	
	
	public List<ReplyContent> replyAllList(int cnt){
		//해당 게시글의  댓글 리스트
		return replyContentDao.getAllReply(cnt);
	}
	
	public int ReplyCnt(int cnt) {
		//해당 게시물의 댓글 갯수
			return replyContentDao.getReplyCnt(cnt);
	}
		
	public void writeReply(ReplyContent replyContent) {
		//수정 날짜 셋팅 0
		//로그인한 유저 id, name 셋팅
		//현재날짜셋팅
		//게시글번호(jsp에서)
		
		
		replyContentDao.insertReply(replyContent);
		
	}
	public void modifyReply(ReplyContent replyContent) {
		//수정 날짜 셋팅(현재)
		replyContentDao.updateReply(replyContent);
	}
	
	public void deleteReply(ReplyContent replyContent) {
		//param:게시글번호,댓글번호
		replyContentDao.deleteReply(replyContent);	
	}
	
	public int setReplyNo(int cnt) {
		//댓글 번호 셋팅- 게시글번호로 검색
		return replyContentDao.getMaxReplyCnt(cnt)+1;
	}
	

}
