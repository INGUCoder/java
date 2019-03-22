package com.example.demo.repertories.mapper;

import com.example.demo.domain.ActionMovie;
import com.example.demo.domain.LoveMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface LoveMovieMapper {
    @Select("select * from lovemovie where id = #{id}")
    LoveMovie selectById(@Param("id") int id);

}
