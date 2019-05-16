package com.svideo.mapper;

import com.svideo.domain.TbRecomment;

import java.util.List;

public interface TbRecommentMapper {
    int deleteByPrimaryKey(Long rId);

    int insert(TbRecomment record);

    TbRecomment selectByPrimaryKey(Long rId);

    List<TbRecomment> selectAll(int vid);

    int updateByPrimaryKey(TbRecomment record);
}