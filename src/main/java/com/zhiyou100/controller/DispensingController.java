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
import com.zhiyou100.model.Dispensing;
import com.zhiyou100.service.DispensingService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

//@Controller
@RequestMapping("/dispensing")
public class DispensingController {
	@Autowired
	private DispensingService service;
	@RequestMapping("/list")
	public String findAllDispensing(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<Dispensing> dispensings = service.findAllDispensing(map);
		PageInfo<Dispensing> pageInfo = new PageInfo<>(dispensings);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("dispensings", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "dispensing/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findDispensingByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		Dispensing dispensing = service.findDispensingById(id);
		System.out.println(dispensing);
		model.addAttribute("dispensing", dispensing);
		
		return "dispensing/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findDispensingById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		Dispensing dispensing = service.findDispensingById(id);
		System.out.println(dispensing);
		model.addAttribute("dispensing", dispensing);
		
		return "dispensing/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateDispensing(Dispensing dispensing) {
		Date update_time = new Date();
//			dispensing.setUpdate_time(update_time);
		int rowNum = service.updateDispensing(dispensing);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/dispensing/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertDispensing() {
		
		return "dispensing/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertDispensing(Dispensing dispensing) {
		Date update_time = new Date();
//			dispensing.setUpdate_time(update_time);
		int rowNum = service.insertDispensing(dispensing);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/dispensing/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetDispensingById(int id) {
		
		int rowNum = service.deletetDispensingById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/dispensing/list";
	}
	
	
}

