package com.enuri.myweb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enuri.myweb.service.BoardService;

import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.service.ReplyService;
import com.enuri.myweb.vo.board.BoardContent;
import com.enuri.myweb.vo.page.PageMaker;
import com.enuri.myweb.vo.userinfo.UserInfo;


@Controller
@RequestMapping("/board")
public class BoardController {
	

	@Autowired BoardService boardService;
	@Autowired ReplyService replyService;//댓글
	
	@Resource(name="loginsession")
	@Lazy UserInfo loginsession;

	
/*	@GetMapping("/main")
	public String main(Model model,UserInfo userInfo) {
				
		String name=loginsession.getUser_name();
		System.out.println("C-board에서 유저 이름:"+name); //0
		model.addAttribute("user_name", name); // ~님 안녕하세요 메시지
		
		List<BoardContent> list = boardService.getBoardList();
		model.addAttribute("contentlist", list);
		//글 List 전달


		return "/board/main";
	}
	*/
	@GetMapping("/main")
	public String main(Model model,UserInfo userInfo, @RequestParam(value="page", defaultValue="1")int page) {
				
		String name=loginsession.getUser_name();
		System.out.println("C-board에서 유저 이름:"+name); //0
		model.addAttribute("user_name", name); // ~님 안녕하세요 메시지
		
		List<BoardContent> list = boardService.getBoardList(page);
		model.addAttribute("contentlist", list);
		//글 List 전달
		
		PageMaker paging = boardService.getPaging(page);
		model.addAttribute("paging", paging);
		//해당게시물번호의 댓글수 DB에추가


		return "/board/main";
	}
	
	@GetMapping("/read")
	public String read(@RequestParam("content_cnt")int content_cnt,Model model,BoardContent boardcontent) {
		
		BoardContent readContent = boardService.readBoardContent(content_cnt);
		boardService.updateHit(content_cnt);
		model.addAttribute("read", readContent);

		return "/board/read";
	}
	
	@GetMapping("/write")
	public String write() {
		System.out.println("C-게시글작성 페이지 이동");
		return "/board/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute("writeContent")BoardContent boardContent ,Model model) {
		System.out.println("C-게시글 작성");
		System.out.println(boardContent.getTitle());
		System.out.println(boardService.maxCntPlus());
		
		boardService.writeBoard(boardContent);
		model.addAttribute("cnt", boardContent.getCnt());

		return "/board/writeSuccess";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("content_cnt")int content_cnt
						,Model model, BoardContent boardContent) {
		BoardContent modifyContent = boardService.readBoardContent(content_cnt);
		model.addAttribute("modify", modifyContent);
		
		System.out.println("새로 작성한 제목:"+modifyContent.getTitle());
		
		return "/board/modify";
	}
	@PostMapping("/modify")
	public String modify(@ModelAttribute("modifyContent")BoardContent boardContent) {
		System.out.println("C-게시글 수정");
		System.out.println(boardContent.getTitle());

		boardService.modifyBoardContent(boardContent);
		//return "/board/modifySuccess;
		return "redirect:/board/read?content_cnt="+boardContent.getCnt();

	}
		

	
	@GetMapping("/delete")
	public String delete(@RequestParam("content_cnt")int content_cnt) {
		
		boardService.deleteBoardContent(content_cnt);	
		return "/board/delete";
	}
	
	
	
	
	
}
