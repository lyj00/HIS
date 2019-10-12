package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.ChargeManager;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface ChargeManagerService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<ChargeManager> findAllChargeManager(Map<Object, Object> map);

	/**
	 * @param medical_record
	 * @return
	 */
	ChargeManager findChargeManagerById(String medical_record);

	/**
	 * @param charge
	 * @return
	 */
	int updateChargeManager(ChargeManager charge);

	/**
	 * @param charge
	 * @return
	 */
	int insertChargeManager(ChargeManager charge);

	/**
	 * @param id
	 * @return
	 */
	int deleteChargeManagerById(int id);

	/**
	 * @param charge
	 */
	int insertReg(ChargeManager charge);

	/**
	 * @param charge
	 * @return 
	 */
	int updateReg(ChargeManager charge);

	/**
	 * @param integer
	 * @return
	 */
	int deleteChargeById(Integer[] ids);

}
