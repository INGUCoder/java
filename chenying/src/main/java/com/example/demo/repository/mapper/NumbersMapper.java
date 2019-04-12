package com.example.demo.repository.mapper;

import com.example.demo.domain.Numbers;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface NumbersMapper {
//登录查询
    @Select("select * from numbers where phone = #{phone}")
    Numbers selectByPhone(@Param("phone") String phone);

    //注册插入
    @Insert("insert into numbers (phone,password) values (#{phone},#{password})")
    void  insertNumber(@Param("phone") String phone,@Param("password") String password);
//修改用户手机号
    @Update("update numbers set phone=#{phone} where phone = #{phone}")
    void  update(@Param("phone") String phone,@Param("phone") String phone1);
}
