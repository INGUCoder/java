package com.svideo.service;

import com.svideo.domain.TbRecomment;
import com.svideo.domain.TbVideo;

import java.util.List;

public interface RecommentService {

    /**
     * 获取评论的列表
     *
     * @param video
     * @return
     */

    List<TbRecomment> RecommentList(TbVideo video);

    /**
     * 添加评论
     *
     * @param recomment
     */

    void addRecomment(TbRecomment recomment);

    /**
     * 删除评论
     *
     * @param recomment
     */

    void deleteRecomment(TbRecomment recomment);

    /**
     * 赞
     *
     * @param rId
     */
    void addPraseRecom(Long rId);
}
