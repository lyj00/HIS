package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.model.Drug;
import com.zhiyou100.model.Drug;
import com.zhiyou100.service.DrugService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
@Controller
@RequestMapping("/drug")
public class DrugController {

	
	@Autowired
	private DrugService service;
	@RequestMapping("/list")
	public String findAllDrug(Model model,@RequestParam(defaultValue="")String filed,@RequestParam(defaultValue="")String keyword,@RequestParam(defaultValue="1")int pageNum){
		Map<Object, Object> map = new HashMap<>();
		map.put("filed", filed);
		map.put("keyword", keyword);
		int total = service.count(map);
		
		Page<Object> page = PageHelper.startPage(pageNum, 3);
		List<Drug> drugs = service.findAllDrug(map);
		PageInfo<Drug> pageInfo = new PageInfo<>(drugs);
		model.addAttribute("map",map); 
		model.addAttribute("page", pageInfo);
		model.addAttribute("drugs", pageInfo.getList());
		System.out.println(pageInfo);
		System.out.println(pageInfo.getList());
		return "drug/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findDrugByIdd(int id,Model model) {
		
		System.out.println("点击详情 得到的对应的id : " + id);
		Drug drug = service.findDrugById(id);
		model.addAttribute("drug", drug);
		
		return "drug/detail";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String findDrugById(int id,Model model) {
		
		System.out.println("点击更新 得到的对应的id : " + id);
		
		Drug drug = service.findDrugById(id);
		System.out.println(drug);
		model.addAttribute("drug", drug);
		
		return "drug/edit";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String updateDrug(Drug drug,
			@RequestParam("img")MultipartFile img,
			// @RequestParam(defaultValue="")String drug_url,
			HttpServletRequest request) throws IllegalStateException, IOException {
		
		// 1. 获得上传的对象
		// 2. 获得最终上传的目的地路径(上传至服务器中的当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("================================"+realPath);
		// 2.1 将最终目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件夹是否存在
		if(!file.exists()) {
			System.out.println("========================");
			// 不存在则创建出
			file.mkdir();
		}
		// 2.2 获得文件名
		String fileName = img.getOriginalFilename();
		/*
		 * 获得文件后缀名 
		 */
		String[] split = fileName.split("\\.");
		String suffix = split[split.length - 1];
		// 以毫秒值为文件名
		long prefix = new Date().getTime();
		// 组装文件名
		String newFileName = prefix + "." + suffix;
		// 2.3 确定上传路径
		File newFile= new File(file,newFileName);
		// 3 .上传
		try {
			FileUtils.writeByteArrayToFile(newFile, img.getBytes());
		} catch (IOException e) {
			System.out.println("文件上传异常");
			e.printStackTrace();
		}
		// img.transferTo(newFile);
		drug.setDrug_url("/upload/"+ newFileName);

		int rowNum = service.updateDrug(drug);
		
		System.out.println("受影响行数 : " + rowNum);
		if(rowNum > 0) {
			System.out.println("更新成功");
		} 
		
		return "forward:/drug/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String insertDrug() {
		
		return "drug/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insertDrug(Drug drug,
			@RequestParam("img")MultipartFile img,
			// @RequestParam(defaultValue="")String drug_url,
			HttpServletRequest request) throws IllegalStateException, IOException {
		
		// 1. 获得上传的对象
		// 2. 获得最终上传的目的地路径(上传至服务器中的当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("================================"+realPath);
		// 2.1 将最终目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件夹是否存在
		if(!file.exists()) {
			System.out.println("========================");
			// 不存在则创建出
			file.mkdir();
		}
		// 2.2 获得文件名
		String fileName = img.getOriginalFilename();
		/*
		 * 获得文件后缀名 
		 */
		String[] split = fileName.split("\\.");
		String suffix = split[split.length - 1];
		// 以毫秒值为文件名
		long prefix = new Date().getTime();
		// 组装文件名
		String newFileName = prefix + "." + suffix;
		// 2.3 确定上传路径
		File newFile= new File(file,newFileName);
		// 3 .上传
		try {
			FileUtils.writeByteArrayToFile(newFile, img.getBytes());
		} catch (IOException e) {
			System.out.println("文件上传异常");
			e.printStackTrace();
		}
		// img.transferTo(newFile);
		drug.setDrug_url("/upload/"+ newFileName);
		request.setAttribute("path", "/upload/"+newFileName);

		System.out.println("------------"+drug.getDrug_url());
		int rowNum = service.insertDrug(drug);
		if(rowNum > 0) {
			System.out.println("插入成功");
		} 
		return "forward:/drug/list";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletetDrugById(int id) {
		
		int rowNum = service.deletetDrugById(id);
		System.out.println("受影响行数 : " + rowNum);
		
		if(rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		return "forward:/drug/list";
	}
	
	@RequestMapping("/deleteByIds")
	public String deleteByIds(@RequestParam(defaultValue="")Integer[] ids,Model model) {
		System.out.println("==================" + Arrays.toString(ids));
		if(ids.length > 0 && ids != null) {
			//批量删除
			if(ids.length > 0 ) {
				for(int i = 0;i < ids.length;i++) {
					int rows = service.deletetDrugById(ids[i]);//删除的方法
					System.out.println("受影响行数 : " + rows);
				}
			}
			return "forward:/drug/list";
		}
		return "forward:/drug/list";
	}
}

