package com.enuri.myweb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enuri.myweb.service.BoardService;
import com.enuri.myweb.service.ReplyService;
import com.enuri.myweb.vo.reply.ReplyContent;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired ReplyService replyService;//댓글
	@Autowired BoardService boardService;
	
	@Resource(name="loginsession")
	@Lazy UserInfo loginsession;
	
	
	@GetMapping("/list")
	public List<ReplyContent> replyList(@RequestParam("content_cnt")int content_cnt ) {
		System.out.println("댓글 작성한 게시글"+content_cnt);
		//ajax에 값을 전달?spring jsp c로 <c:foreach>?
		return replyService.replyAllList(content_cnt);

	}
	
	@RequestMapping(value = "/insert", method = {RequestMethod.POST,RequestMethod.GET})
	public String insert(@Valid @ModelAttribute("writeReply") ReplyContent replyContent,BindingResult result
			,Model model) {
		System.out.println("댓글작성: " +replyContent.getCnt());
		int cnt= replyContent.getCnt();
		if(result.hasErrors()) {//true 면 오류있음. 다시 회원가입창으로
			System.out.println("유효성에서 또걸림1: "+result);
			return "redirect:/board/read?content_cnt="+cnt+"";
		}
		
		replyService.writeReply(replyContent,cnt);
		//board의 게시글 개수(recnt) +1씩 증가
		boardService.updateReplyCnt(cnt);
		System.out.println("ddddddddddddddddddddddddddddd");
		model.addAttribute("cnt", cnt);
		return "/reply/inserSuccess";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("reply_no")int reply_no, 
			@RequestParam("content_cnt")int content_cnt, Model model){
		System.out.println("삭제할 댓글: "+reply_no);
		replyService.deleteReply(reply_no);
		System.out.println("ddddddddddddddddddddddddddddd222");	
		
		boardService.updateReplyCntM(content_cnt);
		System.out.println("cntdkdkdkdkdkd: " +content_cnt);
		model.addAttribute("cnt", content_cnt);
		return "/reply/deleteSuccess";
	}
	
	@ResponseBody
	@GetMapping("/modify")
	public int modify(@RequestParam("reply_no")int reply_no, 
			@RequestParam("content_cnt")int content_cnt,Model model, ReplyContent replyContent) {
		ReplyContent modifyContent = replyService.readReplyContent(reply_no);
		//내용만 변경가능, 1로 셋팅되면 수정폼 열림 //취소하면 다시 0이되어야..
		modifyContent.setUp_no(1);
		System.out.println("수정할 rno :"+modifyContent.getRno());
		System.out.println("수정할 up_no :"+modifyContent.getUp_no());
		
		model.addAttribute("modify", modifyContent);	
		return 1;
	
	}
	@PostMapping("/modify")
	public String modify(@ModelAttribute("modifyReply")ReplyContent replyContent) {
		//c:if로 form 넣음
		System.out.println("이게되나나나나나");
		System.out.println("ttttttttttttttttttt"+replyContent.getContent());
		
		replyService.modifyReply(replyContent);
		System.out.println("ttttttttttttttttttt222"+replyContent.getContent());
		return "/reply/modifySuccess";
	}
	
	@GetMapping("/modifyCancel")
	public String noModify(@RequestParam("reply_no")int reply_no,
			@RequestParam("content_cnt")int content_cnt,Model model) {
		//수정할 DB 가져옴->up_no 0으로 셋팅
		//replyContent.setUp_no(0);
		ReplyContent modifyContent = replyService.readReplyContent(reply_no);
		modifyContent.setUp_no(0);
		model.addAttribute("cnt", content_cnt);
		return "/reply/modifyCancel";
	}
	

}
