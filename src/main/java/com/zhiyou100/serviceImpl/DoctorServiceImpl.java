package com.zhiyou100.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.DoctorMapper;
import com.zhiyou100.model.Doctor;
import com.zhiyou100.service.DoctorService;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorMapper mapper;

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
	public List<Doctor> findAllDoctor(Map<Object, Object> map) {
		
		return mapper.findAllDoctor(map);
	}

	/* 
	 * 
	 */
	@Override
	public int insertDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return mapper.insertDoctor(doctor);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteDoctorById(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteDoctorById(id);
	}

	/* 
	 * 
	 */
	@Override
	public Doctor findDoctorById(int id) {
		// TODO Auto-generated method stub
		return mapper.findDoctorById(id);
	}

	/* 
	 * 
	 */
	@Override
	public int updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return mapper.updateDoctor(doctor);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteDoctorByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.deleteList(ids);
	}


}
