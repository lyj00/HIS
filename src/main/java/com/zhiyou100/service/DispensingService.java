package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Dispensing;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface DispensingService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Dispensing> findAllDispensing(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Dispensing findDispensingById(int id);

	/**
	 * @param dispensing
	 * @return
	 */
	int updateDispensing(Dispensing dispensing);

	/**
	 * @param dispensing
	 * @return
	 */
	int insertDispensing(Dispensing dispensing);

	/**
	 * @param id
	 * @return
	 */
	int deletetDispensingById(int id);

}
