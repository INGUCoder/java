package com.example.demo.repertories.mapper;

import com.example.demo.domain.ComedyMovie;
import com.example.demo.domain.LoveMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ComedyMovieMapper {
    @Select("select * from comedymovie where id = #{id}")
    ComedyMovie selectById(@Param("id") int id);

}
