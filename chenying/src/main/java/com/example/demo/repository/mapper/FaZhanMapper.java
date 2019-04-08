package com.example.demo.repository.mapper;

import com.example.demo.domain.Fazhan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface FaZhanMapper {
    //增
    @Insert("insert into fazhan (bianhao,name,sex,status,biaoxian,chuqing,workstatus,sixiang,idcard) values (#{bianhao},#{name},#{sex},#{status},#{biaoxian},#{chuqing},#{workstatus},#{sixiang},#{idcard})")
    void add(@Param("bianhao") String bianhao,@Param("name") String name,@Param("sex") String sex,@Param("status") String status,@Param("biaoxian") String biaoxian,
             @Param("chuqing") String chuqing,@Param("workstatus") String workstatus,@Param("sixiang") String sixiang,@Param("idcard") String idcard);
    //删
    @Delete("delete from fazhan where bianhao=#{bianhao}")
    void  delete(@Param("bianhao") String bianhao);
    //改
    @Update("update  fazhan set name=#{name},sex=#{sex},status=#{status},biaoxian=#{biaoxian},chuqing=#{chuqing},workstatus=#{workstatus},sixiang=#{sixiang},idcard=#{idcard} where bianhao=#{bianhao}")
    void update(@Param("name") String name,@Param("sex") String sex,@Param("status") String status,@Param("biaoxian") String biaoxian,
                @Param("chuqing") String chuqing,@Param("workstatus") String workstatus,@Param("sixiang") String sixiang,@Param("idcard") String idcard,@Param("bianhao") String bianhao);
//查找单个
    @Select("select * from fazhan where bianhao =#{bianhao}")
    Fazhan selectByBianHao(@Param("bianhao") String bianhao);
    //查找所有
    @Select("select * from fazhan")
    List<Fazhan> selectAll();
}
