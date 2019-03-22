package com.example.demo.repertories.mapper;

import com.example.demo.domain.ActionMovie;
import com.example.demo.domain.Movie3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ActionMovieMapper {
    @Select("select * from actionmovie where id = #{id}")
    ActionMovie selectById(@Param("id") int id);

}
