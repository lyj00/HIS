package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.HospitalInfor;

/**
 * @author Liyajun
 * @date 2019年9月11日
 * @desc 
 * 
 */
public interface HospitalInfoMapper {

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
	 * @param drug
	 * @return
	 */
	int insertHospitalInfor(HospitalInfor drug);

	/**
	 * @param id
	 * @return
	 */
	int deletetHospitalInforById(int id);

	/**
	 * @param id
	 * @return
	 */
	HospitalInfor findHospitalInforById(int id);

	/**
	 * @param hospitalInfor
	 * @return
	 */
	int updateHospitalInfor(HospitalInfor hospitalInfor);

	/**
	 * @param ids
	 * @return
	 */
	int deleteList(Integer[] ids);

}
