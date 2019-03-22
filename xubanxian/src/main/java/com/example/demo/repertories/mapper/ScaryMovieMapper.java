package com.example.demo.repertories.mapper;

import com.example.demo.domain.ActionMovie;
import com.example.demo.domain.ScaryMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ScaryMovieMapper {
    @Select("select * from scarymovie where id = #{id}")
    ScaryMovie selectById(@Param("id") int id);

}
