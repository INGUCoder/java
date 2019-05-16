package com.svideo.mapper;

import com.svideo.domain.TbComment;
import com.svideo.domain.TbVideo;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.util.List;

public interface TbCommentMapper {
    int deleteByPrimaryKey(Long cid);

    int insert(TbComment record);

    TbComment selectByPrimaryKey(Long cid);

    List<TbComment> selectAll();

    int updateByPrimaryKey(TbComment record);

    List<TbVideo> selectAllByUserId(@Param("startLimitPos") Integer startLimitPos, @Param("size") Integer size, @Param("userId") Long userId);

    Integer selectCountByUserId(@Param("userId") Long userId);

    int deleteByUserId(@Param("videoId") Long videoId);
}