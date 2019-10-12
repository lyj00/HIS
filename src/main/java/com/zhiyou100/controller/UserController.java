package com.zhiyou100.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@RequestMapping("/list")
	public String findAllUser(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//		map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 5);
		List<User> users = service.findAllUser(map);
		PageInfo<User> pageInfo = new PageInfo<>(users);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("users", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "user/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findUserByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		User user = service.findUserById(id);
		System.out.println(user);
		model.addAttribute("user", user);
		
		return "user/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findUserById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		User user = service.findUserById(id);
		System.out.println(user);
		model.addAttribute("user", user);
		
		return "user/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateUser(User user) {
		Date update_time = new Date();
		user.setUpdate_time(update_time);
		int rowNum = service.updateUser(user);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertUser() {
		
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertUser(User user) {
		Date update_time = new Date();
		user.setUpdate_time(update_time);
		int rowNum = service.insertUser(user);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/user/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetUserById(int id) {
		
		int rowNum = service.deletetUserById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/user/list";
	}
	@RequestMapping("/deleteByIds")
	public String deleteByIds(@RequestParam(defaultValue="")Integer[] ids,Model model) {
		System.out.println("==================" + Arrays.toString(ids));
		if(ids.length > 0 && ids != null) {
			//批量删除
			if(ids.length > 0 ) {
				for(int i = 0;i < ids.length;i++) {
					int rows = service.deletetUserById(ids[i]);//删除的方法
					System.out.println("受影响行数 : " + rows);
				}
			}
			return "forward:/user/list";
		}
		return "forward:/user/list";
	}
	
	
}
