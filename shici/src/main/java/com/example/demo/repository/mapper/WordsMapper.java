/**
 * 留言板
 */
package com.example.demo.repository.mapper;

import com.example.demo.domain.Words;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface WordsMapper {
    @Insert("insert into userswords (nicheng,words) values (#{nicheng},#{words})")
    void insertWords(@Param("nicheng")String nicheng,@Param("words")String words);
    @Select("select count(5) from userswords")
    Words selectById(Integer id);
    //查询所有评论 测试
    @Select("select from userswords where nicheng = #{nicheng}")
    Words SelectAll(@Param("nicheng") String nicheng);
    //管理员删除垃圾评论
    @Delete("delete from userswords where words=#{userswords}")
    void  delete(@Param("userswords") String userswords);
}
