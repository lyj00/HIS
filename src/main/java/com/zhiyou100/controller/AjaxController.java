package com.zhiyou100.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.model.ResponseObject;
import com.zhiyou100.service.AjaxService;
import com.zhiyou100.util.FastDFSUtil;

/**
 * @author Liyajun
 * @date 2019年9月18日
 * @desc 
 * 
 */
@Controller
public class AjaxController {
	@Autowired
	AjaxService as;
	/*
	 * 演示 : 异步验证用户是否注册
	 */
	@RequestMapping("/checkUser.do")
	public void checkUser(String usernameJsonkey,HttpServletResponse resp) throws IOException {
		System.out.println("获得ajax 发送的数据 : " + usernameJsonkey);
		String code = as.checkUser(usernameJsonkey);
		resp.getWriter().write(code);
	}
	@RequestMapping("/findUserById.do")
	@ResponseBody
	public ResponseObject findUserById(String id) {  
		ResponseObject obj = as.findUserById(id);
		return obj;
	}
	@RequestMapping("/findDoctorBySectionID.do")
	@ResponseBody
	public ResponseObject findDoctorBySectionID(String sectionId) {
		ResponseObject obj = as.findDoctorBySectionID(sectionId);
		return obj;
	}
	
	// 跳转echarts页面
	@RequestMapping("/toEchartsUI.do")
	public String toEchartsUI() {
		return "test/echarts"; // 不常用
	}
	@RequestMapping("/showEcharts.do")
	@ResponseBody
	public double[] showEcharts() {
		double[] mouth = {100.0,85.0,88.0,94.0,75.5,65.5};
		return mouth;
	}
	
	
	
	@RequestMapping("/showEcharts2.do")
	@ResponseBody
	public ArrayList<double[]> showEcharts2() {
		ArrayList<double[]> lists = new ArrayList<>();
		double[] k1 = {100.0,90.0,80.0,70.0,60.0,50.0,40.0};
		double[] k2 = {90.0,80.0,90.0,80.0,70.0,60.0,30.0};
		double[] k3 = {80.0,60.0,70.0,90.0,40.0,30.0,100.0};
		double[] k4 = {40.0,50.0,60.0,60.0,80.0,90.0,65.0};
		lists.add(k1);
		lists.add(k2);
		lists.add(k3);
		lists.add(k4);
		return lists;
	}
	
	
	@RequestMapping("/upload.do")
	@ResponseBody
	public ResponseObject ajaxUpload(@RequestParam("img")MultipartFile img,
			// @RequestParam(defaultValue="")String drug_url,
			HttpServletRequest request) throws IOException {
		
		// 1. 获得上传的对象
		// 2. 获得最终上传的目的地路径(上传至服务器中的当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("================================"+realPath);
		// 2.1 将最终目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件夹是否存在
		if(!file.exists()) {
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
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());
			String path="/upload/"+newFileName;
			return new ResponseObject("200","成功",path);
		}
		
		@RequestMapping("/uploadFastDFS.do")
		@ResponseBody
		public ResponseObject ajaxUploadFastDFS(MultipartFile img) throws IOException, MyException {
			ResponseObject obj = FastDFSUtil.upload(img);
			System.out.println(obj);
			return obj;
		}
		
		@RequestMapping("/download.do")
		public void ajaxdownloadFastDFS(String fid,HttpServletResponse resp) throws IOException, MyException {
			System.out.println("========= == download.do == ============"+fid);
			byte[] bytes = FastDFSUtil.download(fid);
			// 浏览器响应下载弹框
			resp.setHeader("Content-disposition", "attachment;filename="+new Date().getTime()+".png");
			resp.setContentType("image/png");
			ServletOutputStream outputStream = resp.getOutputStream();
			outputStream.write(bytes);
			outputStream.flush();
			outputStream.close();
		}
		
		@RequestMapping("/deleteFastDFS.do")
		@ResponseBody
		public String ajaxdeleteFastDFS(String srcVal) {
			System.out.println(srcVal);
			String[] split = srcVal.split("java21/");
			String suffix = split[split.length - 1];
			System.out.println(suffix);
			int num = FastDFSUtil.delete_file(suffix);
			System.out.println("删除结果：" +(num == 0?"删除成功":"删除失败"));
			// return "forward:ajaximg_fastDFS.html";
			return "forward:/WEB-INF/view/test/ajaximg_fastDFS.html"; // 不常用
		}


	
	
	
	
	
	
	
	
	
	
	
	

}
