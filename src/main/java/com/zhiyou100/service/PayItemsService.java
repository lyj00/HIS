package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.PayItems;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface PayItemsService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<PayItems> findAllPayItems(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	PayItems findPayItemsById(int id);

	/**
	 * @param pay
	 * @return
	 */
	int updatePayItems(PayItems pay);

	/**
	 * @param pay
	 * @return
	 */
	int insertPayItems(PayItems pay);

	/**
	 * @param id
	 * @return
	 */
	int deletetPayItemsById(int id);

}
