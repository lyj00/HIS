package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Drug;

/**
 * @author Liyajun
 * @date 2019年9月9日
 * @desc 
 * 
 */
public interface DrugMapper {

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
	int deletetDrugById(int id);

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
	 * @param ids
	 * @return
	 */
	int deleteList(Integer[] ids);

	/**
	 * @param drug
	 * @return
	 */
	int insertDrug(Drug drug);

}
