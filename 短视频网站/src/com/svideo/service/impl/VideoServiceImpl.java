package com.svideo.service.impl;

import com.svideo.domain.*;
import com.svideo.mapper.TbVideoMapper;
import com.svideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private TbVideoMapper tbVideoMapper;

    @Override
    public PageBean<TbVideo> getTbVideoList(Integer currPage, Integer pageSize) {
        if (currPage == null) currPage = 1;

        if (pageSize == null) pageSize = 5;


        PageBean<TbVideo> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currPage);
        pageBean.setPageSize(pageSize);
        //丛数据库中查询总记录数
        TbVideoExample example = new TbVideoExample();
        TbVideoExample.Criteria criteria = example.createCriteria();
        /*criteria.andVideoNameLike(keyWord);*/
        int totalCount = (int) tbVideoMapper.countByExample(example);

        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(pageBean.getTotalPage());
        int index = (currPage - 1) * pageSize;
        /*criteria.andIdBetween((String)index,(String)end);*/
        /*List<TbVideo> tbVideos = tbVideoMapper.selectByExample(example);*/
        List<TbVideo> tbVideos = tbVideoMapper.selectPage(index, pageSize, null);

        pageBean.setList(tbVideos);

        //分装
        return pageBean;

    }

    @Override
    public int saveVideo(TbVideo tbVideo) {
        return tbVideoMapper.insertSelective(tbVideo);
    }

    @Override
    public boolean delTbVideo(Integer id) {
        try {
            tbVideoMapper.deleteByPrimaryKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TbVideo> getMovieByCategory(Long i) {
        /*TbVideoExample example = new TbVideoExample();
        TbVideoExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(i);*/
        /*List<TbVideo> tbVideos = this.tbVideoMapper.selectByExample(example);*/
        List<TbVideo> tbVideos = this.tbVideoMapper.selectByOrderAseId(i);
        return tbVideos;
    }

    @Override
    public TbVideo getMoviesByID(Integer videoId) {
        TbVideo tbVideo = this.tbVideoMapper.selectByPrimaryKey(videoId);
        return tbVideo;
    }

    @Override
    public void updateByCondiction(TbVideo videos) {
        this.tbVideoMapper.updateByPrimaryKeySelective(videos);
    }

    @Override
    public List<TbVideo> getMoviesByUserID(TbVideo video) {
        TbVideoExample example = new TbVideoExample();
        TbVideoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(video.getUserId());
        int count = (int) this.tbVideoMapper.countByExample(example);
        video.setTotalRecords(count);
        return tbVideoMapper.selectPage(video.getStartLimitPos(), video.getPageSize(), video.getUserId());

    }

    /**
     * 根据名字收索
     *
     * @param queryVO
     * @return
     */
    @Override
    public List<TbVideo> searchVideo(QueryVO queryVO) {
        List<TbVideo> videos = tbVideoMapper.searchVideo(queryVO);
        if (videos.size() > 0) {
            return videos;
        } else {
            return null;
        }

    }


}
