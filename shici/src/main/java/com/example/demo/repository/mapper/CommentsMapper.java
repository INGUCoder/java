package com.example.demo.repository.mapper;

import com.example.demo.domain.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

//评论查询
@Mapper
@Service
public interface CommentsMapper {
    //查询所有评论
    @Select("select * from comments where zuopingming=#{zuopingming}")
    List<Comments>  selectAllComments(@Param("zuopingming") String zuopingming);
    //插入评论
    @Insert("insert into comments (zuopingming,username,commnets) values(#{zuopingming},#{username},#{commnets})")
    void insertComments(@Param("zuopingming") String zuopingming,@Param("username") String username,@Param("commnets") String commnets);
    //查询所有评论
    @Select("select * from comments")
    List<Comments>  selectComments();
}
