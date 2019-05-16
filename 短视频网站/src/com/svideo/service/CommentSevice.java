package com.svideo.service;

import com.svideo.domain.TbVideo;

import java.util.List;

public interface CommentSevice {
    int addVideo(Long id, Long userId);

    List<TbVideo> getLikeList(TbVideo video, Long id);

    Integer delLike(Long id);
}
