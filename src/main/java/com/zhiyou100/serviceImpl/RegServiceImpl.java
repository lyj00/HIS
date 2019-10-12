package com.zhiyou100.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.RegMapper;
import com.zhiyou100.model.RegistrationInfor;
import com.zhiyou100.model.ResponseObject;
import com.zhiyou100.model.Section;
import com.zhiyou100.service.RegService;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
@Service
public class RegServiceImpl implements RegService{
	
	@Autowired
	private RegMapper mapper;

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
	public List<RegistrationInfor> findAllReg(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		return mapper.findAllReg(map);
	}

	/* 
	 * 
	 */
	@Override
	public RegistrationInfor findRegById(int id) {
		// TODO Auto-generated method stub
		return mapper.findRegById(id);
	}

	/* 
	 * 
	 */
	@Override
	public int updateReg(RegistrationInfor reg) {
		// TODO Auto-generated method stub
		return mapper.updateReg(reg);
	}

	/* 
	 * 
	 */
	@Override
	public int insertReg(RegistrationInfor reg) {
		// TODO Auto-generated method stub
		return mapper.insertReg(reg);
	}

	/* 
	 * 
	 */
	@Override
	public int deletetRegById(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteRegById(id);
	}

	/* 
	 * 
	 */
	@Override
	public List<Section> findSection() {
		// TODO Auto-generated method stub
		return mapper.findSection();
	}

	/* 
	 * 
	 */
	@Override
	public ResponseObject findDoctorBySectionID(String sectionId) {
		return null;
//		ArrayList<Doctor> doctors = new ArrayList<>();
//		if(sectionId != null && sectionId != "") {
//			mapper.findDoctorBySectionID(sectionId);
//		}else {
//			System.out.println("id 不正确");
//		}
	
//		return new ResponseObject("200","成功",doctors);
	}

}
