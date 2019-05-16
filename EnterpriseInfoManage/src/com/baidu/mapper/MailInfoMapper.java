package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.bean.MailInfo;

public interface MailInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MailInfo record);

    int insertSelective(MailInfo record);

    MailInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailInfo record);

    int updateByPrimaryKey(MailInfo record);
    
    List<MailInfo> getMail(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
    
    List<MailInfo> mailStatistics();
    
    Integer getLen();
}