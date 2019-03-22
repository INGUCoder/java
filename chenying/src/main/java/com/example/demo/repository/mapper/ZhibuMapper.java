/**
 *
 * 从数据库中读取党史信息
 * @author chen ying
 */
package com.example.demo.repository.mapper;

import com.example.demo.domain.Dangshi;
import com.example.demo.domain.Zhibu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ZhibuMapper {
    //支部信息 显示在首页
    @Select("select * from zhibu where id = #{id}")
    public Zhibu selectAllById(@Param("id") int id);

}
