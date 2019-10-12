package com.zhiyou100.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DrugMapper;
import com.zhiyou100.model.Drug;
import com.zhiyou100.service.DrugService;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
@Service
public class DrugServiceImpl implements DrugService{
	@Autowired
	private DrugMapper mapper;

	/* 
	 * 
	 */
	@Override
	public int count(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		return mapper.count(map);
	}

	/* 
	 * 
	 */
	@Override
	public List<Drug> findAllDrug(Map<Object, Object> map) {
		
		return mapper.findAllDrug(map);
	}

	/* 
	 * 
	 */
	@Override
	public int deletetDrugById(int id) {
		// TODO Auto-generated method stub
		return mapper.deletetDrugById(id);
	}

	/* 
	 * 
	 */
	@Override
	public Drug findDrugById(int id) {
		// TODO Auto-generated method stub
		return mapper.findDrugById(id);
	}

	/* 
	 * 
	 */
	@Override
	public int updateDrug(Drug drug) {
		// TODO Auto-generated method stub
		return mapper.updateDrug(drug);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteList(Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.deleteList(ids);
	}

	/* 
	 * 
	 */
	@Override
	public int insertDrug(Drug drug) {
		// TODO Auto-generated method stub
		return mapper.insertDrug(drug);
	}

}
