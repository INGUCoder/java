package com.example.demo.repertories.mapper;

import com.example.demo.domain.ActionMovie;
import com.example.demo.domain.WarMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface WarMovieMapper {
    @Select("select * from warmovie where id = #{id}")
    WarMovie selectById(@Param("id") int id);

}
