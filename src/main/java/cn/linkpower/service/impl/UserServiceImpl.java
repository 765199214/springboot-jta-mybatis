package cn.linkpower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.linkpower.dao.mapper1.IUserMapper1;
import cn.linkpower.dao.mapper2.IUserMapper2;
import cn.linkpower.service.IUserService;
import cn.linkpower.vo.Users;

@Service
public class UserServiceImpl implements IUserService {
	//引入mapper
	@Autowired
	private IUserMapper1 userMapper1;
	@Autowired
	private IUserMapper2 userMapper2;
	
	@Override
	@Transactional(value="transactionManager",propagation=Propagation.REQUIRED)
	public int insertUser(Users user) {
		userMapper1.insertUser1(user);
		//测试1
		//int a = 10/0;
		userMapper2.insertUser1(user);
		//测试2
		int a = 10/0;
		return 1;
	}
	@Override
	@Transactional(value="transactionManager",propagation=Propagation.REQUIRED)
	public int insertUser2(Users user) {
		userMapper2.insertUser1(user);
		return 1;
	}
}
