package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalClear;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface HospitalClearService {

	/**
	 * @param map
	 * @return
	 */
	List<HospitalClear> findAllHospitalClear(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	HospitalClear findHospitalClearById(int id);

	/**
	 * @param clear
	 * @return
	 */
	int updateHospitalClear(HospitalClear clear);

	/**
	 * @param clear
	 * @return
	 */
	int insertHospitalClear(HospitalClear clear);

	/**
	 * @param id
	 * @return
	 */
	int deletetHospitalClearById(int id);

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

}
