package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.linkpower.service.IUserService;
import cn.linkpower.vo.Users;

@RestController
public class TestController {

	//引入service
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping("/test1")
	public String test1(){
		System.out.println("test1");
		Users user = new Users();
		user.setUsername("香蕉测试");
		user.setPassword("20191012");
		userServiceImpl.insertUser(user);
		return "6666";
	}
	
	@RequestMapping("/test2")
	public String test2(){
		Users user = new Users();
		user.setUsername("香蕉测试");
		user.setPassword("20191013");
		userServiceImpl.insertUser2(user);
		return "7777";
	}
	
	@RequestMapping("/")
	public String test(){
		return "hello spring boot jta";
	}
}
