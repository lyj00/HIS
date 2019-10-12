package com.zhiyou100.controller;

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
import com.zhiyou100.model.Role;
import com.zhiyou100.service.RoleService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

//@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService service;
	@RequestMapping("/list")
	public String findAllRole(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<Role> users = service.findAllRole(map);
		PageInfo<Role> pageInfo = new PageInfo<>(users);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("users", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "role/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findRoleByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		Role role = service.findRoleById(id);
		System.out.println(role);
		model.addAttribute("role", role);
		
		return "role/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findRoleById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		Role role = service.findRoleById(id);
		System.out.println(role);
		model.addAttribute("role", role);
		
		return "role/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateRole(Role role) {
		Date update_time = new Date();
//			role.setUpdate_time(update_time);
		int rowNum = service.updateRole(role);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/role/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertRole() {
		
		return "role/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertRole(Role role) {
		Date update_time = new Date();
//			role.setUpdate_time(update_time);
		int rowNum = service.insertRole(role);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/role/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetRoleById(int id) {
		
		int rowNum = service.deletetRoleById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/role/list";
	}
	
	
}


