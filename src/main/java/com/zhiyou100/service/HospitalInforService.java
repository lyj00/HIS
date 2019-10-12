package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalInfor;


/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface HospitalInforService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<HospitalInfor> findAllHospitalInfor(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	HospitalInfor findHospitalInforById(int id);

	/**
	 * @param hospital
	 * @return
	 */
	int updateHospitalInfor(HospitalInfor hospital);

	/**
	 * @param hospital
	 * @return
	 */
	int insertHospitalInfor(HospitalInfor hospital);

	/**
	 * @param id
	 * @return
	 */
	int deletetHospitalInforById(int id);

	/**
	 * @param integer
	 * @return
	 */
	int deleteList(Integer[] ids);

}
