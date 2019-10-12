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
import com.zhiyou100.model.PayItems;
import com.zhiyou100.service.PayItemsService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
//@Controller
@RequestMapping("/pay")
public class PayItemsController {
	@Autowired
	private PayItemsService service;
	@RequestMapping("/list")
	public String findAllPayItems(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<PayItems> pays = service.findAllPayItems(map);
		PageInfo<PayItems> pageInfo = new PageInfo<>(pays);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("pays", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "pay/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findPayItemsByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		PayItems pay = service.findPayItemsById(id);
		System.out.println(pay);
		model.addAttribute("pay", pay);
		
		return "pay/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findPayItemsById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		PayItems pay = service.findPayItemsById(id);
		System.out.println(pay);
		model.addAttribute("pay", pay);
		
		return "pay/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updatePayItems(PayItems pay) {
		Date update_time = new Date();
//			pay.setUpdate_time(update_time);
		int rowNum = service.updatePayItems(pay);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/pay/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertPayItems() {
		
		return "pay/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertPayItems(PayItems pay) {
		Date update_time = new Date();
//			pay.setUpdate_time(update_time);
		int rowNum = service.insertPayItems(pay);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/pay/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetPayItemsById(int id) {
		
		int rowNum = service.deletetPayItemsById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/pay/list";
	}
	
	
}


