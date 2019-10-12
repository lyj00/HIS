package com.zhiyou100.mapper;

import java.util.Map;

import com.zhiyou100.model.User;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
public interface LoginMapper {

	/**
	 * @param map
	 * @return
	 */
	User findUserByLogin(Map<String, String> map);

	
}
