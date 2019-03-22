package com.example.demo.repository.mapper;

import com.example.demo.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

//管理员登陆后台系统
@Service
@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    public Users getByUsername(@Param("username") String username);
    //查询所有党员信息
    @Select("select * from users")
    public List<Users> allUsers();

}
