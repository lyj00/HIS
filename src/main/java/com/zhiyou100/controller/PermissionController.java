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
import com.zhiyou100.model.Permission;
import com.zhiyou100.service.PermissionService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

//@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService service;
	@RequestMapping("/list")
	public String findAllPermission(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<Permission> permissions = service.findAllPermission(map);
		PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("permissions", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "permission/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findPermissionByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		Permission permission = service.findPermissionById(id);
		System.out.println(permission);
		model.addAttribute("permission", permission);
		
		return "permission/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findPermissionById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		Permission permission = service.findPermissionById(id);
		System.out.println(permission);
		model.addAttribute("permission", permission);
		
		return "permission/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updatePermission(Permission permission) {
		Date update_time = new Date();
//			permission.setUpdate_time(update_time);
		int rowNum = service.updatePermission(permission);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/permission/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertPermission() {
		
		return "permission/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertPermission(Permission permission) {
		Date update_time = new Date();
//			permission.setUpdate_time(update_time);
		int rowNum = service.insertPermission(permission);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/permission/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetPermissionById(int id) {
		
		int rowNum = service.deletetPermissionById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/permission/list";
	}
	
	
}


