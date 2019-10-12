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
import com.zhiyou100.model.HospitalClear;
import com.zhiyou100.service.HospitalClearService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

//@Controller
@RequestMapping("/clear")
public class HospitalClearController {
	@Autowired
	private HospitalClearService service;
	@RequestMapping("/list")
	public String findAllHospitalClear(Model model,
			@RequestParam(defaultValue="")Map<Object,Object> keywordMap,
			@RequestParam(defaultValue="1")int pageNum) {
		int total = service.count(keywordMap);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<HospitalClear> clears = service.findAllHospitalClear(keywordMap);
		PageInfo<HospitalClear> pageInfo = new PageInfo<>(clears);
		model.addAttribute("keywordMap",keywordMap); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("clears", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "clear/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findHospitalClearByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		HospitalClear clear = service.findHospitalClearById(id);
		System.out.println(clear);
		model.addAttribute("clear", clear);
		
		return "clear/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findHospitalClearById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		HospitalClear clear = service.findHospitalClearById(id);
		System.out.println(clear);
		model.addAttribute("clear", clear);
		
		return "clear/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateHospitalClear(HospitalClear clear) {
		Date update_time = new Date();
//			clear.setUpdate_time(update_time);
		int rowNum = service.updateHospitalClear(clear);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/clear/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertHospitalClear() {
		
		return "clear/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertHospitalClear(HospitalClear clear) {
		Date update_time = new Date();
//			clear.setUpdate_time(update_time);
		int rowNum = service.insertHospitalClear(clear);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/clear/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetHospitalClearById(int id) {
		
		int rowNum = service.deletetHospitalClearById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/clear/list";
	}
	
	
}

