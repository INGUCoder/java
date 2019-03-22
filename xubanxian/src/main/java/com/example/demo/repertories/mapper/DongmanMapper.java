package com.example.demo.repertories.mapper;

import com.example.demo.domain.Dongman;
import com.example.demo.domain.ScaryMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface DongmanMapper {
    @Select("select * from dongman where id = #{id}")
    Dongman selectById(@Param("id") int id);

}
