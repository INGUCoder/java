package com.example.demo.repository.mapper;

import com.example.demo.domain.DangFei;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface DangFeiMapper {

    //缴费
    @Insert("insert into dangfei (bianhao,name,idcard,zhibu,totalmoney,time) values(#{bianhao},#{name},#{idcard},#{zhibu},#{totalmoney},#{time})")
    void addDangfei(@Param("bianhao") String bianhao, @Param("name") String name, @Param("idcard") String idcard
            , @Param("zhibu") String zhibu, @Param("totalmoney") Integer totalmoney, @Param("time") String time);

    @Select("select * from dangfei")
    List<DangFei> selectAll();

    @Select("select * from dangfei where bianhao = #{bianhao}")
    List<DangFei> selectDangFeis(@Param("bianhao") String bianhao);
}
