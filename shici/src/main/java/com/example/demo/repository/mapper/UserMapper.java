
package com.example.demo.repository.mapper;

import com.example.demo.domain.Shichi;
import com.example.demo.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper {
    //插入新用户数据 用户注册
    @Insert("insert into userinfo (email,password,username,sex,age,birthdaty,phone,address) values (#{email},#{password},#{username},#{sex},#{age},#{birthdaty},#{phone},#{address})")
    void insertUser(@Param("email") String email,@Param("password") String password,@Param("username") String username,
                    @Param("sex") String sex,@Param("age") Integer age,@Param("birthdaty") String birthdaty,@Param("phone") String phone,@Param("address") String address);
    //登录页面
    //根据邮箱查到用户信息
    @Select("select * from userinfo where email = #{email}")
    Users selectByEmail(@Param("email") String email);
    //管理员查询所有用户信息
    @Select("select * from userinfo ")
    List<Users> selectAll();


    //用户修改个人信息
    @Update("update userinfo set username = #{username},password =#{password},sex=#{sex}," +
            "age=#{age},birthdaty=#{birthdaty},phone=#{phone},address=#{address} where email =#{email} ")
    void updateUser(@Param("username")String username,@Param("password") String password,@Param("sex") String sex,
                    @Param("age") Integer age,@Param("birthdaty") String birthdaty,@Param("phone")String phone,
                    @Param("address") String address,@Param("email") String email);

//根据诗词名查询诗词信息
    @Select("select * from shichi where zuopingming = #{zuopingming}")
    List<Shichi> searchByname(@Param("zuopingming") String zuopingming);

    //用户发布诗词
    @Insert("insert into shichi (zuopingming,zuozhe,zuopinginfo,shichitype,zuozheinfo,zhushi) values(#{zuopingming},#{zuozhe},#{zuopinginfo},#{shichitype},#{zuozheinfo},#{zhushi})")
    void  usersInsertShichi(@Param("zuopingming") String zuopingming,@Param("zuozhe") String zuozhe,@Param("zuopinginfo") String zuopinginfo,


                            @Param("shichitype") String  shichitype,@Param("zuozheinfo") String zuozheinfo,@Param("zhushi") String zhushi);


    //用户查询自己发布的诗词
    @Select("select * from shichi where zuozhe = #{zuozhe}")
    List<Shichi> userSearchShichi(@Param("zuozhe") String zuozhe);


    //修改诗词
    @Update("update shichi set zuozhe=#{zuozhe}, zuopinginfo=#{zuopinginfo},shichitype=#{shichitype},zuozheinfo= #{zuozheinfo},zhushi=#{zhushi} where zuopingming=#{zuopingming}  ")
    void  updateShichi(@Param("zuozhe") String zuozhe,@Param("zuopinginfo") String zuopinginfo,


                       @Param("shichitype") String  shichitype,@Param("zuozheinfo") String zuozheinfo,@Param("zhushi") String zhushi,@Param("zuopingming") String zuopingming);

}
//zuozhe,zuopinginfo,shichitype,zuozheinfo,zhushi,zuopingming