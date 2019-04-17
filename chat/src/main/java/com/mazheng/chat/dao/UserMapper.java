package com.mazheng.chat.dao;

import com.mazheng.chat.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;





@Mapper

/**
 * 自动注册到spring容器上
 */
@Service
/**
 * 把mapper这个DAO交给Spring管理
 */
/**
 * dao接口
 * @author mazheng
 * @date 2019/4/16
 */
public interface UserMapper {
    /**
     * 根据email查询用户
     * @param email
     * Return User
     */
    @Select("select * from users where email=#{email}")
    Users selectByEmail(@Param("email") String email);
}
