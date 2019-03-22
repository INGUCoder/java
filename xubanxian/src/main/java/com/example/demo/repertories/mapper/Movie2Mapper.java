package com.example.demo.repertories.mapper;

import com.example.demo.domain.Movie2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface Movie2Mapper {
    @Select("select * from movie2 where id = #{id}")
    Movie2 selectById(@Param("id") int id);

}
