package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.Section;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface SectionService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<Section> findAllSection(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	Section findSectionById(int id);

	/**
	 * @param section
	 * @return
	 */
	int updateSection(Section section);

	/**
	 * @param section
	 * @return
	 */
	int insertSection(Section section);

	/**
	 * @param id
	 * @return
	 */
	int deletetSectionById(int id);

}
