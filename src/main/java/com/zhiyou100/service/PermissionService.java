package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Permission;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface PermissionService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Permission> findAllPermission(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Permission findPermissionById(int id);

	/**
	 * @param permission
	 * @return
	 */
	int updatePermission(Permission permission);

	/**
	 * @param permission
	 * @return
	 */
	int insertPermission(Permission permission);

	/**
	 * @param id
	 * @return
	 */
	int deletetPermissionById(int id);

}
