package com.svideo.service.impl;

import com.svideo.domain.TbComment;
import com.svideo.domain.TbVideo;
import com.svideo.mapper.TbCommentMapper;
import com.svideo.service.CommentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentSeviceImpl implements CommentSevice {

    @Autowired
    private TbCommentMapper tbCommentMapper;

    @Override
    public int addVideo(Long id, Long userId) {
        TbComment tbComment = new TbComment();
        Date date = new Date();
        tbComment.setCommentDate(date);
        tbComment.setVedioId(id);
        tbComment.setContent("nihoa");
        tbComment.setCreator(userId);
        int result = tbCommentMapper.insert(tbComment);

        return result;
    }

    @Override
    public List<TbVideo> getLikeList(TbVideo video, Long id) {
        Integer count = tbCommentMapper.selectCountByUserId(id);
        video.setTotalRecords(count);
        List<TbVideo> tbVideos = tbCommentMapper.selectAllByUserId(video.getStartLimitPos(), video.getPageSize(), id);
        return tbVideos;

    }

    @Override
    public Integer delLike(Long videoId) {
        int i = tbCommentMapper.deleteByUserId(videoId);
        return i;
    }
}
