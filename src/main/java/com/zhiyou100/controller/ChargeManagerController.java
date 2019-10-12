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
import com.zhiyou100.model.ChargeManager;
import com.zhiyou100.service.ChargeManagerService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

@Controller
@RequestMapping("/charge")
public class ChargeManagerController {
	@Autowired
	private ChargeManagerService service;
	@RequestMapping("/list")
	public String findAllChargeManager(Model model,
			@RequestParam(defaultValue="")Map<Object,Object> keywordMap,
			@RequestParam(defaultValue="1")int pageNum) {
		
		int total = service.count(keywordMap);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<ChargeManager> charges = service.findAllChargeManager(keywordMap);
		PageInfo<ChargeManager> pageInfo = new PageInfo<>(charges);
		model.addAttribute("keywordMap",keywordMap); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("charges", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "charge/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findChargeManagerByIdd(String medical_record,Model model) {
		
		System.out.println("点击详情 得到的对应的病历号 : " + medical_record);
		ChargeManager charge = service.findChargeManagerById(medical_record);
		
		System.out.println(charge);
		model.addAttribute("charge", charge);
		
		return "charge/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findChargeManagerById(String medical_record,Model model) {
		
		System.out.println("点击更新 得到的对应的病历号 : " + medical_record);
		
		ChargeManager charge = service.findChargeManagerById(medical_record);
		System.out.println(charge);
		model.addAttribute("charge", charge);
		
		return "charge/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateChargeManager(ChargeManager charge) {
		Date update_time = new Date();
//			charge.setUpdate_time(update_time);
		int rowNum = service.updateChargeManager(charge);
		int num = service.updateReg(charge);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/charge/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertChargeManager() {
		
		return "charge/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertChargeManager(ChargeManager charge) {
		Date update_time = new Date();
//			charge.setUpdate_time(update_time);
		int rowNum = service.insertChargeManager(charge);
		int insertReg = service.insertReg(charge);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/charge/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetChargeManagerById(int id) {
		
		int rowNum = service.deleteChargeManagerById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/charge/list";
	}
	@RequestMapping("/deleteByIds")
	public String deleteByIds(@RequestParam(defaultValue="")Integer[] ids,Model model) {
		System.out.println("==================" + Arrays.toString(ids));
		if(ids.length > 0 && ids != null) {
			//批量删除
			if(ids.length > 0 ) {
				for(int i = 0;i < ids.length;i++) {
					int rows = service.deleteChargeManagerById(ids[i]);//删除的方法
					System.out.println("受影响行数 : " + rows);
				}
			}
			return "forward:/charge/list";
		}
		return "forward:/charge/list";
	}
	
	
}

