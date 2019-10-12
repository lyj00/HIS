package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.ChargeManager;

/**
 * @author Liyajun
 * @date 2019年9月11日
 * @desc 
 * 
 */
public interface ChargeMapper {

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
	 * @param charge
	 * @return
	 */
	int insertChargeManager(ChargeManager charge);

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
	 * @param id
	 * @return
	 */
	int deleteChargeManagerById(int id);

	/**
	 * @param charge
	 * @return
	 */
	int insertReg(ChargeManager charge);

	/**
	 * @param charge
	 * @return
	 */
	int updateReg(ChargeManager charge);

	/**
	 * @param ids
	 * @return
	 */
	int deleteList(Integer[] ids);

}
