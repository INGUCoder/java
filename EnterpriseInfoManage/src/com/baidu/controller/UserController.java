package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.bean.User;
import com.baidu.service.UserService;

@Controller
@RequestMapping("userController")
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("getAllUser")
	@ResponseBody
	public List<User> getAllUser(Integer pageNum,Integer pageSize){
		return this.service.getAllUser(pageNum,pageSize);
	}
	
	@RequestMapping("getUserById")
	@ResponseBody
	public User getUserById(Integer id){
		System.out.println(id);
		System.out.println(this.service.getUserById(id));
		return this.service.getUserById(id);
	}
	
	@RequestMapping("getLen")
	@ResponseBody
	public Integer getLen(){
		return this.service.getLen();
	}
	
	@RequestMapping("del")
	@ResponseBody
	public Integer delUser(Integer id){
		return this.service.delUser(id);
	}
	
	
	@RequestMapping("add")
	@ResponseBody
	public Integer addUser(User user){
		return this.service.addUser(user);
	}
	
	@RequestMapping("updUser")
	@ResponseBody
	public Integer updUser(User user){
		return this.service.updUser(user);
	}
	
	@RequestMapping("getByUserName")
	@ResponseBody
	public Integer getByUserName(String username){
		System.out.println(username);
		return this.service.getByUserName(username);
	}
}
