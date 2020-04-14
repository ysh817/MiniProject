package com.enuri.myweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enuri.myweb.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@GetMapping("/main")
	public String main() {
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
	public String write() {
		return "/board/write";
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
