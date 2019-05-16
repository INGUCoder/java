/**
 * 从数据库中读取党史信息
 *
 * @author chen ying
 */
package com.example.demo.repository.mapper;

import com.example.demo.domain.Dangshi;
import com.example.demo.domain.Zhishu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface ZhishuMapper {
    //查询直属信息 显示在首页
    @Select("select * from zhishu")
    List<Zhishu> selectAll();

}
