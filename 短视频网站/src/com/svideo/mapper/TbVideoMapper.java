package com.svideo.mapper;

import com.svideo.domain.QueryVO;
import com.svideo.domain.TbVideo;
import com.svideo.domain.TbVideoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbVideoMapper {
    long countByExample(TbVideoExample example);

    int deleteByExample(TbVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbVideo record);

    int insertSelective(TbVideo record);

    List<TbVideo> selectByExample(TbVideoExample example);

    TbVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbVideo record, @Param("example") TbVideoExample example);

    int updateByExample(@Param("record") TbVideo record, @Param("example") TbVideoExample example);

    int updateByPrimaryKeySelective(TbVideo record);

    int updateByPrimaryKey(TbVideo record);

    List<TbVideo> selectPage(@Param("currentPage") Integer currentPage, @Param("size") Integer size, @Param("userId") Long userId);

    List<TbVideo> selectByOrderAseId(Long categoryId);

    List<TbVideo> searchVideo(QueryVO queryVO);


}