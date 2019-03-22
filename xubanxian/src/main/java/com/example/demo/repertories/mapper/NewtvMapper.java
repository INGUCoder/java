package com.example.demo.repertories.mapper;

import com.example.demo.domain.Dongman;
import com.example.demo.domain.Newtv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface NewtvMapper {
    @Select("select * from newtv where id = #{id}")
    Newtv selectById(@Param("id") int id);

}
