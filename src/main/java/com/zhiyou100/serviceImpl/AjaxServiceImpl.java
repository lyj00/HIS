package com.zhiyou100.serviceImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zhiyou100.model.Doctor;
import com.zhiyou100.model.ResponseObject;
import com.zhiyou100.model.User;
import com.zhiyou100.service.AjaxService;

/**
 * @author Liyajun
 * @date 2019年9月18日
 * @desc 
 * 
 */
@Service
public class AjaxServiceImpl implements AjaxService{
	/* 
	 * 
	 */
	public String checkUser(String usernameJsonkey) {
		String code = null;
		if(usernameJsonkey == null || usernameJsonkey == "" || usernameJsonkey.equals("admin")) {
			code="{\"code\":\"404\"}";
		}else {
			code="{\"code\":\"200\"}";
		}
		System.out.println("业务层 输入返回的结果 : " + code);
		return code;
	}
	
	public ResponseObject findUserById(String id) {
		User user = new User();
		user.setReal_name("张三");
		user.setPassword("188188");
		user.setEmail("52154556@qq.com");
		ResponseObject obj = new ResponseObject("200","成功",user);
		return obj;
	}  

	/* 
	 * 
	 */
	@Override
	public ResponseObject findDoctorBySectionID(String sectionId) {
		ArrayList<Doctor> doctors = new ArrayList<>();
		if(sectionId != null && sectionId != "") {
			if(sectionId.equals("1")) {
				doctors.add(new Doctor("k1张三"));
				doctors.add(new Doctor("k1李四"));
				doctors.add(new Doctor("k1王五"));
			}else if(sectionId.equals("2")) {
				doctors.add(new Doctor("k2张三"));
				doctors.add(new Doctor("k2李四"));
				doctors.add(new Doctor("k2王五"));
			}else if(sectionId.equals("3")) {
				doctors.add(new Doctor("k3张三"));
				doctors.add(new Doctor("k3李四"));
				doctors.add(new Doctor("k3王五"));
			}
		}else {
			System.out.println("id 不正确");
		}
	
		return new ResponseObject("200","成功",doctors);
	}
	
}

	
