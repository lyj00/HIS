package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Doctor;

/**
 * @author Liyajun
 * @date 2019年9月10日
 * @desc 
 * 
 */
public interface DoctorMapper {

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
	 * @param ids 
	 * @return
	 */
	int deleteList(Integer[] ids);

}
