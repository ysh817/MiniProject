package com.enuri.myweb.controller;

import java.util.List;

<<<<<<< HEAD
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
=======
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enuri.myweb.service.BoardService;
<<<<<<< HEAD
import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.board.BoardContent;
import com.enuri.myweb.vo.userinfo.UserInfo;
=======
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf

@Controller
@RequestMapping("/board")
public class BoardController {
	
<<<<<<< HEAD
	@Autowired
	LoginService loginService;
	@Autowired BoardService boardService;
	@Resource(name="loginsession")
	@Lazy
	UserInfo loginsession;
=======
>>>>>>> af431f1ab9f3057a36f88acc2856b7db07db42bf
	
	@GetMapping("/main")
	public String main(Model model,UserInfo userInfo) {
		
		System.out.println("목록  ");
		
		String name=userInfo.getUser_name();
		System.out.println(name);
		List<BoardContent> list = boardService.getBoardList();
		model.addAttribute("contentlist", list);
		//String name=userInfo.getUser_name();
		System.out.println("2"+name);
		model.addAttribute("user_name", name);
		return "/board/main";
	}
	
	@GetMapping("/read")
	public String read(Model model) {
	
		//<UserInfo> list = BoardService.getAllBoardList();
		//리스트로 유저리스트 담음
		//model.addAttribute("list", list);
		return "/board/read";
	}
	
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContent")BoardContent boardContent ) {
		return "/board/write";
	}
	@PostMapping("/write")
	public String writing(@ModelAttribute("writeContent")BoardContent boardContent) {
		//boardService.writeContent(boardContent);
		return "/board/writeSuccess";
	}
	
	
	@GetMapping("/modify")
	public String modify() {
		return "/board/modify";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "/board/delete";
	}
	
	
}
