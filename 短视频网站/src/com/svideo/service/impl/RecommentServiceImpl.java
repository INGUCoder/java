package com.svideo.service.impl;

import com.svideo.domain.TbRecomment;
import com.svideo.domain.TbVideo;
import com.svideo.mapper.TbRecommentMapper;
import com.svideo.service.RecommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 评论业务
 */
@Service
@Transactional
public class RecommentServiceImpl implements RecommentService {
    @Autowired
    private TbRecommentMapper recommentMapper;

    /**
     * 获取评论
     *
     * @param video
     * @return
     */

    @Override
    public List<TbRecomment> RecommentList(TbVideo video) {
        List<TbRecomment> recomments = recommentMapper.selectAll(video.getId());
        if (recomments.size() < 0) {
            return null;
        }
        return recomments;
    }

    /* *
     * 添加评论
     * @param recomment
     */
    @Override
    public void addRecomment(TbRecomment recomment) {
        recommentMapper.insert(recomment);
    }

    /**
     * 删除评论
     *
     * @param recomment
     */
    @Override
    public void deleteRecomment(TbRecomment recomment) {
        recommentMapper.deleteByPrimaryKey(recomment.getrId());
    }

    /**
     * 赞
     *
     * @param rId
     */
    public void addPraseRecom(Long rId) {
        TbRecomment tbRecomment = recommentMapper.selectByPrimaryKey(rId);
        if (null != tbRecomment) {
            if (null == tbRecomment.getPraseCount()) {
                tbRecomment.setPraseCount(0);
            }
            tbRecomment.setPraseCount(tbRecomment.getPraseCount() + 1);
            tbRecomment.setUser(tbRecomment.getUser());
            recommentMapper.updateByPrimaryKey(tbRecomment);
        }
    }
}
