package com.enuri.myweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		
	public void writeReply(ReplyContent replyContent,int cnt) {
		//수정 날짜 셋팅 -
		//로그인한 유저 id, name 셋팅
		//현재날짜셋팅,글번호,댓글번호
		//게시글번호(jsp에서)
		replyContent.setRegdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		replyContent.setUp_regdate("-");
		replyContent.setUser_id(loginsession.getUser_id());
		replyContent.setUser_name(loginsession.getUser_name());
		replyContent.setCnt(cnt);
		replyContent.setRno(setReplyNo(cnt));
		replyContent.setUp_no(0);
		//0이면 수정중 X
		
		
		
		replyContentDao.insertReply(replyContent);
		
	}
	public void modifyReply(ReplyContent replyContent) {
		//수정 날짜 셋팅(현재)
		replyContent.setUp_regdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		replyContent.setUp_no(0);//다시 0으로
		replyContentDao.updateReply(replyContent);
	}
	
	public void deleteReply(int rno) {
		//param:게시글번호,댓글번호
		//댓글번호로만 delete	
		replyContentDao.deleteReply(rno);	
	}
	
	public int setReplyNo(int cnt) {
		//댓글 번호 셋팅- 게시글번호로 검색
		return replyContentDao.getMaxReplyCnt(cnt)+1;
	}
	
	public void deleteReplyBoad(int cnt) {
		//해당 게시글이 삭제되면 그 글에 있던 댓글들도 사라지게
		replyContentDao.deleteReplyOnBoad(cnt);
	}
	public ReplyContent readReplyContent(int rno) {
		return replyContentDao.readReply(rno);
	}
	

}
