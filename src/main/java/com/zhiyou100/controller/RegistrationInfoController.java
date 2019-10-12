package com.zhiyou100.controller;


import java.util.Arrays;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */


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
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.model.ResponseObject;
import com.zhiyou100.model.Section;
import com.zhiyou100.service.RegService;

@Controller
@RequestMapping("/reg")
public class RegistrationInfoController {
	@Autowired
	private RegService service;
	@RequestMapping("/list")
	public String findAllReg(Model model,
			@RequestParam Map<Object,Object> keywordMap,
			@RequestParam(defaultValue="1")int pageNum) {
		System.out.println(keywordMap);
		int total = service.count(keywordMap);
////		map.put("total", total);
//		/*
//		 * 在查询之前使用pagehelper 
//		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<RegistrationInfor> regs = service.findAllReg(keywordMap);
		for(RegistrationInfor reg : regs) {
			
			System.out.println("==========" + reg);
		}
		PageInfo<RegistrationInfor> pageInfo = new PageInfo<>(regs);
		model.addAttribute("keywordMap",keywordMap); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("regs", pageInfo.getList());
		return "reg/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findRegByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		RegistrationInfor reg = service.findRegById(id);
		System.out.println(reg);
		model.addAttribute("reg", reg);
		
		return "reg/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findRegById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		RegistrationInfor reg = service.findRegById(id);
		System.out.println(reg);
		model.addAttribute("reg", reg);
		
		return "reg/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateReg(RegistrationInfor reg) {
		Date time = new Date();
		reg.setTime(time);
		int rowNum = service.updateReg(reg);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/reg/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertReg(Model model) {
		List<Section> sections = service.findSection();
		System.out.println(sections);
		model.addAttribute("sections", sections);
		return "reg/add";
	}
	
	@RequestMapping("/findDoctorBySectionID.do")
	@ResponseBody
	public ResponseObject findDoctorBySectionID(String sectionId) {
		ResponseObject obj = service.findDoctorBySectionID(sectionId);
		return obj;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertReg(RegistrationInfor reg) {
		System.out.println("----------------------------------------------------");
		Date time = new Date();
		reg.setTime(time);
		System.out.println(reg);
		int rowNum = service.insertReg(reg);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/reg/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetRegById(int id) {
		
		int rowNum = service.deletetRegById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/reg/list";
	}
	@RequestMapping("/deleteByIds")
	public String deleteByIds(@RequestParam(defaultValue="")Integer[] ids,Model model) {
		System.out.println("==================" + Arrays.toString(ids));
		if(ids.length > 0 && ids != null) {
			//批量删除
			if(ids.length > 0 ) {
				for(int i = 0;i < ids.length;i++) {
					int rows = service.deletetRegById(ids[i]);//删除的方法
					System.out.println("受影响行数 : " + rows);
				}
			}
			return "forward:/reg/list";
		}
		return "forward:/reg/list";
	}
	
	
}
