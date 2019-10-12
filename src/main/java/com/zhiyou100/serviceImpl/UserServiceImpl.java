package com.zhiyou100.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;

/**
 * @author Liyajun
 * @date 2019年9月6日
 * @desc 
 * 
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;

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
	public List<User> findAllUser(Map<Object, Object> map) {
		
		return mapper.findAllUser(map);
	}

	/* 
	 * 
	 */
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return mapper.insertUser(user);
	}

	/* 
	 * 
	 */
	@Override
	public int deletetUserById(int id) {
		// TODO Auto-generated method stub
		return mapper.deletetUserById(id);
	}

	/* 
	 * 
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return mapper.findUserById(id);
	}

	/* 
	 * 
	 */
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return mapper.updateUser(user);
	}

	/* 
	 * 
	 */
	@Override
	public int deleteUserById(Integer[] ids) {
		// TODO Auto-generated method stub
		return mapper.deleteList(ids);
	}

}
