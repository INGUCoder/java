package com.example.demo.repository.mapper;
import com.example.demo.domain.Shichi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
@Service
@Mapper
public interface ShichiMappper {
    //根据诗词名查询诗词信息
    @Select("select * from shichi where zuopingming = #{zuopingming}")
    Shichi selectByZuopingming(@Param("zuopingming") String zuopingming);

    //管理员上传诗词信息
    @Insert("insert into shichi (zuopingming,zuopinginfo,zuozhe,zuozheinfo) values" +
            "(#{zuopingming},#{zuopinginfo},#{zuozhe},#{zuozheinfo})")
    void insertShichi(@Param("zuopingming") String zuopingming,@Param("zuopinginfo") String zuopinginfo,
    @Param("zuozhe") String zuozhe,@Param("zuozheinfo") String zuozheinfo );

    //管理员删除诗词信息
    @Delete("delete from shichi where zuopingming = #{zuopingming}")
    void  delete(@Param("zuopingming") String zuopingming);



}
