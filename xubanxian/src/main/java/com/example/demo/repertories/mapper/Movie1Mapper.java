package com.example.demo.repertories.mapper;

import com.example.demo.domain.Movie1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface Movie1Mapper {
    @Select("select * from movie1 where id = #{id}")
    Movie1 selectById(@Param("id") int id);


}
