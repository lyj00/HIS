package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.model.ResponseObject;
import com.zhiyou100.model.Section;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface RegService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<RegistrationInfor> findAllReg(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	RegistrationInfor findRegById(int id);

	/**
	 * @param reg
	 * @return
	 */
	int updateReg(RegistrationInfor reg);

	/**
	 * @param reg
	 * @return
	 */
	int insertReg(RegistrationInfor reg);

	/**
	 * @param id
	 * @return
	 */
	int deletetRegById(int id);

	/**
	 * @return
	 */
	List<Section> findSection();

	/**
	 * @param sectionId
	 * @return
	 */
	ResponseObject findDoctorBySectionID(String sectionId);

}
