package com.enuri.myweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enuri.myweb.service.AdminService;
import com.enuri.myweb.service.BoardService;
import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.page.PageMaker;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	
	@Resource(name="loginsession")
	@Lazy UserInfo loginsession;
	
	@GetMapping("/userlist")
	public String adminUser_list(Model model, UserInfo userInfo,@RequestParam(value="page", defaultValue="1")int page ) {
		
		System.out.println("C-회원관리");
		List<UserInfo> list=adminService.getAllUser(page);
		model.addAttribute("userlist", list);
		
		PageMaker paging = adminService.getPaging(page);
		
		model.addAttribute("paging", paging);
		return"/admin/userlist";
	}
	@GetMapping("/usermodify")
	public String adminUsermodify(@RequestParam("user_id")String userId
				, UserInfo userInfo, Model model) {
		
		UserInfo usermodify = adminService.getModifyUserInfo(userId);
		System.out.println("수정할 회원id="+usermodify.getUser_id());//0
		
		model.addAttribute("usermodify", usermodify);
		return "/admin/usermodify";
	}
	@PostMapping("/usermodify")
	public String adminUsermodify(
			@ModelAttribute("adminModifyUser")UserInfo userInfo){
		
		System.out.println("C-admin회원수정");
		adminService.updateaAdminUserInfo(userInfo);
		
		return"/admin/usermodifySuccess";
	}
}
