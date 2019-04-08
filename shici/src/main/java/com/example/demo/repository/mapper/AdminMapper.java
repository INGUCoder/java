
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

}
