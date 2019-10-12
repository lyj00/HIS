package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Role;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface RoleService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Role> findAllRole(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Role findRoleById(int id);

	/**
	 * @param role
	 * @return
	 */
	int updateRole(Role role);

	/**
	 * @param role
	 * @return
	 */
	int insertRole(Role role);

	/**
	 * @param id
	 * @return
	 */
	int deletetRoleById(int id);

}
