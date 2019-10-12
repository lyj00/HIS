package com.zhiyou100.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.HospitalInfoMapper;
import com.zhiyou100.model.HospitalInfor;
import com.zhiyou100.service.HospitalInforService;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
@Service
public class HospitalInfoServiceImpl implements HospitalInforService{
	@Autowired
	private HospitalInfoMapper mapper;

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
	public List<HospitalInfor> findAllHospitalInfor(Map<Object, Object> map) {
		
		return mapper.findAllHospitalInfor(map);
	}

	/* 
	 * 
	 */
	@Override
	public int insertHospitalInfor(HospitalInfor hospitalInfor) {
		// TODO Auto-generated method stub
		return mapper.insertHospitalInfor(hospitalInfor);
	}

	/* 
	 * 
	 */
	@Override
	public int deletetHospitalInforById(int id) {
		// TODO Auto-generated method stub
		return mapper.deletetHospitalInforById(id);
	}

	/* 
	 * 
	 */
	@Override
	public HospitalInfor findHospitalInforById(int id) {
		// TODO Auto-generated method stub
		return mapper.findHospitalInforById(id);
	}

	/* 
	 * 
	 */
	@Override
	public int updateHospitalInfor(HospitalInfor hospitalInfor) {
		// TODO Auto-generated method stub
		return mapper.updateHospitalInfor(hospitalInfor);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteList(Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.deleteList(ids);
	}

	
}
