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
import com.zhiyou100.model.Section;
import com.zhiyou100.service.SectionService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

//@Controller
@RequestMapping("/section")
public class SectionController {
	@Autowired
	private SectionService service;
	@RequestMapping("/list")
	public String findAllSection(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<Section> sections = service.findAllSection(map);
		PageInfo<Section> pageInfo = new PageInfo<>(sections);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("sections", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "section/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findSectionByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		Section section = service.findSectionById(id);
		System.out.println(section);
		model.addAttribute("section", section);
		
		return "section/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findSectionById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		Section section = service.findSectionById(id);
		System.out.println(section);
		model.addAttribute("section", section);
		
		return "section/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateSection(Section section) {
		Date update_time = new Date();
//			section.setUpdate_time(update_time);
		int rowNum = service.updateSection(section);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/section/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertSection() {
		
		return "section/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertSection(Section section) {
		Date update_time = new Date();
//			section.setUpdate_time(update_time);
		int rowNum = service.insertSection(section);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/section/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetSectionById(int id) {
		
		int rowNum = service.deletetSectionById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/section/list";
		}
		
		
	}


