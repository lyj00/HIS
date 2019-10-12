package com.zhiyou100.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.model.Section;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface RegMapper {

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
	int deleteRegById(int id);

	/**
	 * @return
	 */
	List<Section> findSection();

}
