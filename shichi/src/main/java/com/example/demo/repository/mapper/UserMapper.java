
package com.example.demo.repository.mapper;

import com.example.demo.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
@Service
@Mapper
public interface UserMapper {
    //插入新用户数据
    @Insert("insert into userinfo (email,nicheng,password) values (#{email},#{nicheng},#{password})")
    void insertUser(@Param("email") String email,@Param("nicheng") String nicheng,@Param("password") String password);
    //登录页面
    @Select("select * from userinfo where email = #{email}")
    Users selectByEmail(@Param("email") String email);
    //管理员查询所有用户信息
    @Select("select * from userinfo ")
    Users selectAll();
    //修改个人信息
    @Update("update userinfo set nicheng = #{nicheng},password =#{password} where email =#{email} ")
    void update(@Param("nicheng")String nicheng,@Param("password") String password,@Param("email")String email);




}
