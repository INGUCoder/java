package com.example.demo.repertories.mapper;

import com.example.demo.domain.Movie2;
import com.example.demo.domain.Movie3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface Movie3Mapper {
    @Select("select * from movie3 where id = #{id}")
    Movie3 selectById(@Param("id") int id);

}
