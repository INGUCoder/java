/**
 *
 * 从数据库中读取党史信息
 * @author chen ying
 */
package com.example.demo.repository.mapper;


import com.example.demo.domain.Tongzhi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface TongzhiMapper {
    //查询 显示在首页
    @Select("select * from tongzhi")
    List<Tongzhi> selectAll();
    //添加事务
    @Insert("insert into tongzhi (info,url) values (#{info},#{url})")
    void Add(@Param("info") String info,@Param("url") String url);
    //删除事务
    @Delete("delete from tongzhi where id = #{id}")
    void delete(@Param("id") Integer id);
}
