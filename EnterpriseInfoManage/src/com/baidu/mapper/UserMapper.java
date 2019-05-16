package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.bean.User;

public interface UserMapper {
	User loginValidate(@Param("userName")String userName,@Param("userpwd")String userpwd);
	
	List<User> getAllUser(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	
	Integer getLen();
	
	User selectByPrimaryKey(Integer id);
	
	Integer delUser(Integer id);

    int insert(User record);

    int updateByPrimaryKey(User record);
    
    Integer getByUserName(String username);
}
