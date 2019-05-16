package com.example.demo.repertories.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface UserMapper {

    //注册用户信息
    @Insert("insert into users (username,password,email,phone) values (#{username},#{password},#{email},#{phone})")
    void addUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("phone") Long phone);

    //用户登录
    @Select("select * from users where username = #{username} and password = #{password}")
    User userLogin(@Param("username") String username, @Param("password") String password);


}
