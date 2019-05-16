package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.bean.User;
import com.baidu.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper mapper;
	
	public User loginValidate(String userName,String userpwd){
		return  this.mapper.loginValidate(userName,userpwd);
	}
	
	public List<User> getAllUser(Integer pageNum,Integer pageSize){
		return this.mapper.getAllUser(pageNum,pageSize);
	}
	
	public Integer getLen(){
		return this.mapper.getLen();
	}
	
	public Integer delUser(Integer id){
		return this.mapper.delUser(id);
	}
	
	public User getUserById(Integer id){
		return this.mapper.selectByPrimaryKey(id);
	}
	
	public Integer addUser(User user){
		return this.mapper.insert(user);
	}
	
	public Integer updUser(User user){
		return this.mapper.updateByPrimaryKey(user);
	}
	
	public Integer getByUserName(String username){
		return this.mapper.getByUserName(username);
	}
}
