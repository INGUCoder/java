package com.svideo.service;

import com.svideo.domain.Page;
import com.svideo.domain.PageBean;
import com.svideo.domain.QueryVO;
import com.svideo.domain.TbVideo;

import java.util.List;

public interface VideoService {
    /**
     * 后台获取视屏分页
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    PageBean<TbVideo> getTbVideoList(Integer currPage, Integer pageSize);

    /**
     * 保存视屏
     *
     * @param tbVideo
     * @return
     */
    int saveVideo(TbVideo tbVideo);

    /**
     * 删除视屏
     *
     * @param id
     * @return
     */
    boolean delTbVideo(Integer id);

    /**
     * 通过分类获取视屏信息
     *
     * @param i
     * @return
     */
    List<TbVideo> getMovieByCategory(Long i);

    /**
     * 通过id获取视屏
     *
     * @param videoId
     * @return
     */
    TbVideo getMoviesByID(Integer videoId);

    /**
     * 更新视屏
     *
     * @param videos
     */
    void updateByCondiction(TbVideo videos);

    /**
     * 通过用户id 获取视屏列表
     *
     * @param video
     * @return
     */
    List<TbVideo> getMoviesByUserID(TbVideo video);

    /**
     * 根据条件查询
     *
     * @param queryVO
     * @return
     */
    List<TbVideo> searchVideo(QueryVO queryVO);


}
