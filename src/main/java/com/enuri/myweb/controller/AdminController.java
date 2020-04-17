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
import com.enuri.myweb.service.LoginService;
import com.enuri.myweb.vo.userinfo.UserInfo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Resource(name="loginsession")
	@Lazy UserInfo loginsession;
	
	@GetMapping("/user_list")
	public String adminUser_list(Model model, UserInfo userInfo) {
		
		System.out.println("C-회원관리");
		List<UserInfo> list=adminService.getAllUser();
		model.addAttribute("userlist", list);
		
		return"/admin/user_list";
	}
	@GetMapping("/user_modify")
	public String adminUser_modify(@RequestParam("user_id")String userId
				, UserInfo userInfo, Model model) {
		
		UserInfo usermodify = adminService.getModifyUserInfo(userId);
		System.out.println("수정할 회원id="+usermodify.getUser_id());//0
		
		model.addAttribute("usermodify", usermodify);
		return "/admin/user_modify";
	}
	@PostMapping("/user_modify")
	public String adminUser_modify(
			@ModelAttribute("adminModifyUser")UserInfo userInfo){
		
		System.out.println("C-admin회원수정");
		adminService.updateaAdminUserInfo(userInfo);
		
		return"/admin/user_modifySuccess";
	}
}
