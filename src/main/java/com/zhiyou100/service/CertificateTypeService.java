package com.zhiyou100.service;

import java.util.List;
import java.util.Map;

import com.zhiyou100.model.CertificateType;

/**
 * @author Liyajun
 * @date 2019年9月7日
 * @desc 
 * 
 */
public interface CertificateTypeService {

	/**
	 * @param map
	 * @return
	 */
	int count(Map<Object, Object> map);

	/**
	 * @param map
	 * @return
	 */
	List<CertificateType> findAllCertificateType(Map<Object, Object> map);

	/**
	 * @param id
	 * @return
	 */
	CertificateType findCertificateTypeById(int id);

	/**
	 * @param cert
	 * @return
	 */
	int updateCertificateType(CertificateType cert);

	/**
	 * @param cert
	 * @return
	 */
	int insertCertificateType(CertificateType cert);

	/**
	 * @param id
	 * @return
	 */
	int deletetCertificateTypeById(int id);

}
