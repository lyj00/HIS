package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.User;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
public interface UserService {
	

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map 
	 * @return
	 */
	List<User> findAllUser(Map<Object, Object> map);

	/**
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * @param id
	 * @return
	 */
	int deletetUserById(int id);

	/**
	 * @param id
	 * @return
	 */
	User findUserById(int id);

	/**
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 * @param integer
	 * @return
	 */
	int deleteUserById(Integer[] ids);

}
