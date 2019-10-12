package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface DoctorService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Doctor> findAllDoctor(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Doctor findDoctorById(int id);

	/**
	 * @param doctor
	 * @return
	 */
	int updateDoctor(Doctor doctor);

	/**
	 * @param doctor
	 * @return
	 */
	int insertDoctor(Doctor doctor);

	/**
	 * @param id
	 * @return
	 */
	int deleteDoctorById(int id);

	/**
	 * @param integer
	 * @return
	 */

	/**
	 * @param ids
	 * @return
	 */
	int deleteDoctorByIds(Integer[] ids);

}
