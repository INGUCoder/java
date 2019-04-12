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
  //查询所有党员信息

    @Select("select * from users")
    List<Users> selectAll();

    //查询党员信息
    @Select("select * from users where bianhao = #{bianhao}")
    Users userifo(@Param("bianhao") String bianhao);

    //按支部信息查询党员
    @Select("select * from users where zhibu = #{zhibu}")
    List<Users> selectByzhibu(@Param("zhibu") String zhibu);
    //按性别查询
    @Select("select * from users where sex = #{sex}")
    List<Users> selectBySex(@Param("sex") String sex);
    //按入党时间查询
    @Select("select * from users where rudangtime = #{rudangtime}")
    List<Users> selectByRudangtime(@Param("rudangtime") String rudangtime);
    //按文化程度查询
    @Select("select * from users where education = #{education}")
    List<Users> selectByEducation(@Param("education") String education);

    //根据手机号码搜索用户
    @Select("select * from users where phone = #{phone}")
    Users selectByPhone(@Param("phone") String phone);

}
