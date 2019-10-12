package com.zhiyou100.service;

import com.zhiyou100.model.ResponseObject;

/**
 * @author Liyajun
 * @date 2019年9月18日
 * @desc 
 * 
 */
public interface AjaxService {
	/**
	 * @param usernameJsonkey
	 * @return
	 */
	String checkUser(String usernameJsonkey);

	/**
	 * @param sectionId
	 * @return
	 */
	ResponseObject findDoctorBySectionID(String sectionId);

	/**
	 * @param id
	 * @return
	 */
	ResponseObject findUserById(String id);
	

}
