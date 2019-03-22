
package com.example.demo.repository.mapper;

import com.example.demo.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface AdminMapper {

    @Select("select * from admin where name = #{name}")
    Admin select(@Param("name") String name);
}
