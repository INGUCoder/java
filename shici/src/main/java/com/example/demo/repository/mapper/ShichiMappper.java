package com.example.demo.repository.mapper;
import com.example.demo.domain.Shichi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface ShichiMappper {

    //管理员上传诗词信息


    @Delete("delete from shichi where zuopingming = #{zuopingming}")
    void  delete(@Param("zuopingming") String zuopingming);

    //查询所有诗词信息
    @Select("select * from shichi")
    List<Shichi> selectAll();


    //查询诗词
    @Select("select * from shichi where zuopingming=#{zuopingming}")
    Shichi searchShichi(@Param("zuopingming") String zuopingming);
    //测试
    @Select("select * from shichi where id = #{id}")
    Shichi test(@Param("id") Integer id);

    //首页 点击查询诗词
    @Select("select * from shichi where shichitype =#{shichitype}")
    List<Shichi> searchShichiType(@Param("shichitype") String shichitype);


    //点赞处理
    @Update("update shichi set dianzhan = #{dianzhan} where zuopingming =#{zuopingming}")
    void dianZhan(@Param("dianzhan") Integer dianzhan,@Param("zuopingming") String zuopingming);


    //根据作者查询诗词

    @Select("select * from shichi where zuozhe = #{zuozhe} ")
    List<Shichi> selectByZuozhe(@Param("zuozhe") String zuozhe);

}
