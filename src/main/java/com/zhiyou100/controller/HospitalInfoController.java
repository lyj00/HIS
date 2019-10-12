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
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.service.HospitalInforService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

@Controller
@RequestMapping("/hospital")
public class HospitalInfoController {
	@Autowired
	private HospitalInforService service;
	@RequestMapping("/list")
	public String findAllHospitalInfor(Model model,
			@RequestParam(defaultValue="")Map<Object,Object> keywordMap,
			@RequestParam(defaultValue="1")int pageNum) {
		
		int total = service.count(keywordMap);
		System.out.println("=================" + total);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<HospitalInfor> hospitals = service.findAllHospitalInfor(keywordMap);
		PageInfo<HospitalInfor> pageInfo = new PageInfo<>(hospitals);
		model.addAttribute("keywordMap",keywordMap); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("hospitals", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "hospital/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findHospitalInforByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		HospitalInfor hospital = service.findHospitalInforById(id);
		System.out.println(hospital);
		model.addAttribute("hospital", hospital);
		
		return "hospital/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findHospitalInforById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		HospitalInfor hospital = service.findHospitalInforById(id);
		System.out.println(hospital);
		model.addAttribute("hospital", hospital);
		
		return "hospital/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateHospitalInfor(HospitalInfor hospital) {
		Date update_time = new Date();
//			hospital.setUpdate_time(update_time);
		int rowNum = service.updateHospitalInfor(hospital);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/hospital/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertHospitalInfor() {
		
		return "hospital/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertHospitalInfor(HospitalInfor hospital) {
		Date update_time = new Date();
//			hospital.setUpdate_time(update_time);
		int rowNum = service.insertHospitalInfor(hospital);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/hospital/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetHospitalInforById(int id) {
		
		int rowNum = service.deletetHospitalInforById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/hospital/list";
	}
	@RequestMapping("/deleteByIds")
	public String deleteByIds(@RequestParam(defaultValue="")Integer[] check,Model model) {
		System.out.println("==================" + Arrays.toString(check));
		if(check.length > 0 && check != null) {
			//批量删除
			if(check.length > 0 ) {
				for(int i = 0;i < check.length;i++) {
					int rows = service.deletetHospitalInforById(check[i]);//删除的方法
					System.out.println("受影响行数 : " + rows);
				}
			}
			return "forward:/hospital/list";
		}
		return "forward:/hospital/list";
	}
	
}


