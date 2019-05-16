package com.svideo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svideo.domain.AjaxResult;
import com.svideo.domain.TbRecomment;
import com.svideo.domain.TbUser;
import com.svideo.domain.TbVideo;
import com.svideo.service.RecommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class RecommentController {
    @Autowired
    private RecommentService recommentService;

    /**
     * 获取评论列表
     *
     * @param video
     * @return
     */
    @RequestMapping("/RecommentList")
    @ResponseBody
    public List<TbRecomment> RecommentList(TbVideo video, HttpSession session) {
        List<TbRecomment> recomments = recommentService.RecommentList(video);
        session.setAttribute("recomments", recomments);
        return recomments;
    }

    /**
     * 添加评论
     *
     * @param recomment
     * @return
     */

    @RequestMapping("addRecomment")
    public void addRecomment(TbRecomment recomment, HttpSession session, HttpServletResponse response) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            TbUser user = (TbUser) session.getAttribute("user");
            if (user != null) {
                recomment.setUser(user);
            }
            recomment.setCreatetime(new Date());
            recommentService.addRecomment(recomment);
            ajaxResult.setSuccess(true);
            ajaxResult.setMsg("评论成功");
            String string = new ObjectMapper().writeValueAsString(ajaxResult);
            response.setContentType("utf-8");
            response.getWriter().print(string);

        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("评论失败");
            String string = null;
            try {
                string = new ObjectMapper().writeValueAsString(ajaxResult);
                response.setContentType("utf-8");
                response.getWriter().print(string);
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    /**
     * 删除评论
     */
    @RequestMapping("deleteRecomment")
    @ResponseBody
    public AjaxResult deleteRecomment(TbRecomment recomment) {
        AjaxResult ajaxResult = new AjaxResult();
        try {

            recommentService.deleteRecomment(recomment);
            ajaxResult.setSuccess(true);
            ajaxResult.setMsg("删除成功");

        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMsg("删除失败");
        }
        return ajaxResult;
    }

    /**
     * 赞
     *
     * @param rId
     * @return
     */
    @RequestMapping("addPraseRecom")
    @ResponseBody
    public AjaxResult addPraseRecom(Long rId) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            recommentService.addPraseRecom(rId);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

}
