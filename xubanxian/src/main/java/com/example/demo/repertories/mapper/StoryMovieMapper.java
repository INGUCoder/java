package com.example.demo.repertories.mapper;

import com.example.demo.domain.ActionMovie;
import com.example.demo.domain.StoryMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface StoryMovieMapper {
    @Select("select * from storymovie where id = #{id}")
    StoryMovie selectById(@Param("id") int id);

}
