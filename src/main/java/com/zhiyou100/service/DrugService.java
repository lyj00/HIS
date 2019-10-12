package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Drug;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface DrugService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Drug> findAllDrug(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Drug findDrugById(int id);

	/**
	 * @param drug
	 * @return
	 */
	int updateDrug(Drug drug);

	/**
	 * @param id
	 * @return
	 */
	int deletetDrugById(int id);
	
	int deleteList(Integer[] ids);

	/**
	 * @param drug
	 * @return
	 */
	int insertDrug(Drug drug);


}
