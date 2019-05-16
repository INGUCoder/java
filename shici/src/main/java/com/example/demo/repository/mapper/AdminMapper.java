
package com.example.demo.repository.mapper;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Shichi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface AdminMapper {

    @Select("select * from admin where name = #{name}")
    Admin select(@Param("name") String name);
    @Select("select * from shichi ")
    List<Shichi> selectAllShichi();
    @Delete("delete from userinfo where email=#{email}")
    void deleteUser(@Param("email") String email);
    @Delete("delete from shichi where zuopingming=#{zuopingming}")
    void  deleteShichi(@Param("zuopingming") String zuopingming);

    @Delete("delete from userinfo where id=#{id}")
    void deleteUserId(@Param("id") Integer id);


    @Delete("delete from shichi where id=#{id}")
    void deleteShiciId(@Param("id") Integer id);


    /**
     *    用户修改个人信息
     *
     */

    @Update("update userinfo set username = #{username},password =#{password},sex=#{sex}," +
            "age=#{age},birthdaty=#{birthdaty},phone=#{phone},address=#{address} where email =#{email} ")
    void updateUser(@Param("username")String username,@Param("password") String password,@Param("sex") String sex,
                    @Param("age") Integer age,@Param("birthdaty") String birthdaty,@Param("phone")String phone,
                    @Param("address") String address,@Param("email") String email);

}
