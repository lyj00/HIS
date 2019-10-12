package com.zhiyou100.service;

import com.zhiyou100.model.User;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
public interface LoginService {

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	User findUserByLogin(String username, String password);

}
