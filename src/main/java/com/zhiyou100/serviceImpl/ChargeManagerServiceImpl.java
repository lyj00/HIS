package com.zhiyou100.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.ChargeMapper;
import com.zhiyou100.model.ChargeManager;
import com.zhiyou100.service.ChargeManagerService;

/**
 * @author Liyajun
 * @date 2019年9月11日
 * @desc 
 * 
 */
@Service
public class ChargeManagerServiceImpl implements ChargeManagerService{

	@Autowired
	private ChargeMapper mapper;

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
	public List<ChargeManager> findAllChargeManager(Map<Object, Object> map) {
		
		return mapper.findAllChargeManager(map);
	}

	/* 
	 * 
	 */
	@Override
	public int insertChargeManager(ChargeManager charge) {
		// TODO Auto-generated method stub
		return mapper.insertChargeManager(charge);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteChargeManagerById(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteChargeManagerById(id);
	}

	/* 
	 * 
	 */
	@Override
	public ChargeManager findChargeManagerById(String medical_record) {
		// TODO Auto-generated method stub
		return mapper.findChargeManagerById(medical_record);
	}

	/* 
	 * 
	 */
	@Override
	public int updateChargeManager(ChargeManager charge) {
		// TODO Auto-generated method stub
		return mapper.updateChargeManager(charge);
	}

	/* 
	 * 
	 */
	@Override
	public int insertReg(ChargeManager charge) {
		
		return mapper.insertReg(charge);

		
	}

	/* 
	 * 
	 */
	@Override
	public int updateReg(ChargeManager charge) {
		// TODO Auto-generated method stub
		return mapper.updateReg(charge);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteChargeById(Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.deleteList(ids);
	}


}
