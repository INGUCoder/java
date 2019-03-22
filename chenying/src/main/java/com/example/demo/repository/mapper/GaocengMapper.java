/**
 *
 * 从数据库中读取党史信息
 * @author chen ying
 */
package com.example.demo.repository.mapper;

import com.example.demo.domain.Dangshi;
import com.example.demo.domain.Gaoceng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface GaocengMapper {
    //查询党史 显示在首页
    @Select("select * from gaoceng where id = #{id}")
    public Gaoceng selectAllById(@Param("id") int id);

}
