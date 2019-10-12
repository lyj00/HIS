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
import com.zhiyou100.model.CertificateType;
import com.zhiyou100.service.CertificateTypeService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
//@Controller
@RequestMapping("/cert")
public class CertificateTypeController {
	
	@Autowired
	private CertificateTypeService service;
	@RequestMapping("/list")
	public String findAllCertificateType(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
//			map.put("total", total);
		/*
		 * 在查询之前使用pagehelper 
		 */
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<CertificateType> Certs = service.findAllCertificateType(map);
		PageInfo<CertificateType> pageInfo = new PageInfo<>(Certs);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("Certs", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "cert/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findCertificateTypeByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		CertificateType cert = service.findCertificateTypeById(id);
		System.out.println(cert);
		model.addAttribute("cert", cert);
		
		return "cert/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findCertificateTypeById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		CertificateType cert = service.findCertificateTypeById(id);
		System.out.println(cert);
		model.addAttribute("cert", cert);
		
		return "cert/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateCertificateType(CertificateType cert) {
		Date update_time = new Date();
//			cert.setUpdate_time(update_time);
		int rowNum = service.updateCertificateType(cert);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/cert/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertCertificateType() {
		
		return "cert/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertCertificateType(CertificateType cert) {
		Date update_time = new Date();
//			cert.setUpdate_time(update_time);
		int rowNum = service.insertCertificateType(cert);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/cert/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetCertificateTypeById(int id) {
		
		int rowNum = service.deletetCertificateTypeById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/cert/list";
	}
	
	
}

