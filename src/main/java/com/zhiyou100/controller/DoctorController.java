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
import com.zhiyou100.model.Doctor;
import com.zhiyou100.service.DoctorService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService service;
	@RequestMapping("/list")
	public String findAllDoctor(Model model,@RequestParam(defaultValue="")Map<Object,Object> keywordMap,@RequestParam(defaultValue="1")int pageNum) {
		int total = service.count(keywordMap);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 4);
		List<Doctor> doctors = service.findAllDoctor(keywordMap);
		PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
		model.addAttribute("keywordMap",keywordMap); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("doctors", pageInfo.getList());
		return "doctor/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findDoctorByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		Doctor doctor = service.findDoctorById(id);
		System.out.println(doctor);
		model.addAttribute("doctor", doctor);
		
		return "doctor/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findDoctorById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		Doctor doctor = service.findDoctorById(id);
		System.out.println(doctor);
		model.addAttribute("doctor", doctor);
		
		return "doctor/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateDoctor(Doctor doctor) {
		Date time = new Date();
		doctor.setTime(time);
		int rowNum = service.updateDoctor(doctor);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/doctor/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertDoctor() {
		
		return "doctor/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertDoctor(Doctor doctor) {
		Date time = new Date();
		doctor.setTime(time);
		int rowNum = service.insertDoctor(doctor);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/doctor/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetDoctorById(int id) {
		
		int rowNum = service.deleteDoctorById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/doctor/list";
	}
	@RequestMapping("/deleteByIds")
	public String deleteByIds(@RequestParam(defaultValue="")Integer[] ids,Model model) {
		System.out.println("==================" + Arrays.toString(ids));
		if(ids.length > 0 && ids != null) {
			//批量删除
			if(ids.length > 0 ) {
				for(int i = 0;i < ids.length;i++) {
					int rows = service.deleteDoctorById(ids[i]);//删除的方法
					System.out.println("受影响行数 : " + rows);
				}
			}
			return "forward:/doctor/list";
		}
		return "forward:/doctor/list";
	}
	
}

