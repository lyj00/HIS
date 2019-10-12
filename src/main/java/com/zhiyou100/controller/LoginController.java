package com.zhiyou100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
@Controller
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
//	@RequestMapping("/login")
	
	@RequestMapping("/login")
	public String login(String user_name,String password,Model model) {
		// 调用业务层方法,查询
		User user = loginService.findUserByLogin(user_name,password);
		// 判断
		if(user != null) {
			model.addAttribute("user", user);
			return "admin";
		}
		return "redirect:index.jsp";
		
	}

}
