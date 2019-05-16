package com.example.demo.repository.mapper;

import com.example.demo.domain.zhibuinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface ZhibuInfoMapper {
    //查看所有支部信息
    @Select("select  * from zhibuinfo ")
    List<zhibuinfo> selectAll();

    //添加支部信息
    @Insert("insert into zhibuinfo (name,bianhao,people,phone,address) values (#{name},#{bianhao},#{people},#{phone},#{address})")
    void inserInfo(@Param("name") String name, @Param("bianhao") String bianhao, @Param("people") String people, @Param("phone") String phone,
                   @Param("address") String address);

    //删除支部信息
    @Delete("delete from zhibuinfo where bianhao=#{bianhao}")
    void deleteInfo(@Param("bianhao") String bianhao);

    //修改支部信息
    @Update("update zhibuinfo set name = #{name},people = #{people},phone = #{phone},address = #{address} where bianhao = #{bianhao}")
    void updateInfo(@Param("name") String name, @Param("people") String people, @Param("phone") String phone,
                    @Param("address") String address, @Param("bianhao") String bianhao);

    //查看支部信息
    @Select("select * from zhibuinfo where bianhao=#{bianhao}")
    zhibuinfo selectBybianhao(@Param("bianhao") String bianhao);
}
