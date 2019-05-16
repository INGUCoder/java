package com.example.demo.repertories.mapper;

import com.example.demo.domain.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface MovieMapper {

    @Select("select * from movie where moviename = #{moviename}")
    Movie selectByname(@Param("moviename") String moviename);


}
