package com.svideo.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.svideo.domain.*;
import com.svideo.service.CategoryService;
import com.svideo.service.RecommentService;
import com.svideo.service.VideoService;
import com.svideo.until.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class VideoController {

    //上传的是视屏路径
    String videlUrl = null;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RecommentService recommentService;


    /**
     * 后台获取视屏列表
     *
     * @param session
     * @param currPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/videoPageList")
    public String list(HttpSession session, Integer currPage, Integer pageSize) {
        PageBean<TbVideo> list = videoService.getTbVideoList(currPage, pageSize);
        if (list != null) {
            session.setAttribute("Result", list);
        }
        return "main";
    }

    /**
     * 视屏上传
     *
     * @param plupload
     * @param request
     * @param response
     * @param session
     */
    @RequestMapping("/uploadVideo")
    @ResponseBody
    public void uploadVide(Plupload plupload, HttpServletRequest request,
                           HttpServletResponse response, HttpSession session) {

        plupload.setRequest(request);//手动传入Plupload对象HttpServletRequest属性

        /*User user = (User)request.getSession().getAttribute("user");*/
        String url = request.getSession().getServletContext().getRealPath("/video");

        //文件存储绝对路径,会是一个文件夹，项目相应Servlet容器下的"pluploadDir"文件夹，还会以用户唯一id作划分
        File dir = new File(url + "/" + "admin");
        if (!dir.exists()) {
            dir.mkdirs();//可创建多级目录，而mkdir()只能创建一级目录
        }
        UUID uuid = UUID.randomUUID();
        String[] fileNames = plupload.getName().split("\\.");
        String fileName = uuid.toString() + "." + fileNames[1];//在服务器内生成唯一文件名
        System.out.println(fileNames[0]);
        //开始上传文件
        videlUrl = fileName;
        PluploadService.upload(plupload, dir, fileName);


    }


    /**
     * 后台上传视屏信息
     *
     * @param fileName
     * @param video
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/add_Video")
    public String add(@RequestParam(value = "fileName") MultipartFile fileName, TbVideo video,
                      HttpServletRequest request, HttpSession session) {

        try {
            String name = UUID.randomUUID().toString().replace("-", "");
            String ext = FilenameUtils.getExtension(fileName.getOriginalFilename());
            String url = request.getSession().getServletContext().getRealPath("/uploadImage");
            TbAdmin admin = (TbAdmin) session.getAttribute("admin");
            admin.getAdminName();
            File file = new File(url);
            if (!file.exists()) {
                file.mkdir();
            }
            String newUrl = name + "." + ext;
            fileName.transferTo(new File(url + "\\" + newUrl));
            //文件上传
            /*File dicFile = new File(url + "/" + name + "." + ext);*/
               /*
                fileName.transferTo(new File(newUrl));*/

            video.setAdminId(1);
            video.setUserName(admin.getAdminName());
            video.setImgType(newUrl);
            video.setPlays(0L);
            video.setIsplay(0);
            video.setShowTime(new Date());
            video.setMovieYear(2019);
            video.setMvType(videlUrl);

            videlUrl = null;

            video.setShowTime(new Date());
            videoService.saveVideo(video);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("error", "Upload error");
        }
        return "main";
    }


    /**
     * 前端上传
     *
     * @param fileName
     * @param video
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/updateLoadVideo")
    public String updateMovie(@RequestParam(value = "fileName", required = false) MultipartFile fileName, TbVideo video, HttpSession session, HttpServletRequest request) {

        TbUser user = (TbUser) session.getAttribute("user");
        user.getUserName();
        video.setMvType(videlUrl);
        videlUrl = null;
        video.setUserId(user.getId());
        video.setUserName(user.getUserName());
        video.setShowTime(new Date());
        video.setMovieYear(2019);
        if (!fileName.isEmpty()) {
            try {
                String name = UUID.randomUUID().toString().replace("-", "");
                String ext = FilenameUtils.getExtension(fileName.getOriginalFilename());
                String url = request.getSession().getServletContext().getRealPath("/uploadImage");
                File file = new File(url);
                if (!file.exists()) {
                    file.mkdir();
                }
                //文件上传
                /*File dicFile = new File(url + "/" + name + "." + ext);*/
                String newUrl = name + "." + ext;
                fileName.transferTo(new File(url + "\\" + newUrl));

                video.setImgType(newUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        int result = this.videoService.saveVideo(video);
        if (result > 0) {
            return "redirect:toUpload";
        } else {
            request.setAttribute("error", "Upload error");
            return "error";
        }
    }


    /**
     * 前端个人删除视频
     *
     * @param id
     * @return
     */
    @RequestMapping("videoDelete")
    @ResponseBody
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultmap = new HashMap<>();
        if (id != null) {
            if (videoService.delTbVideo(id)) {
                resultmap.put("success", true);
                resultmap.put("result", "删除成功");
            } else {
                resultmap.put("success", false);
                resultmap.put("result", "删除失败");
            }
        }
        return resultmap;
    }

    /**
     * 首页分类显示
     *
     * @param session
     * @return
     */
    @RequestMapping("/showIndex")
    public String showIndex(HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:loginIndex.jsp";
        }
        List<TbCategory> tbCateGorys = this.categoryService.getTbCateGorys();


        List<TbVideo> videos1 = this.videoService.getMovieByCategory(1L);
        List<TbVideo> videos2 = this.videoService.getMovieByCategory(2L);
        ;
        List<TbVideo> videos3 = this.videoService.getMovieByCategory(3L);
        ;
        List<TbVideo> videos4 = this.videoService.getMovieByCategory(4L);
        ;
        List<TbVideo> videos5 = this.videoService.getMovieByCategory(5L);
        ;
        List<TbVideo> videos6 = this.videoService.getMovieByCategory(6L);
        ;
        /* List<TbVideo> rankings = this.videoService.selectByRankings(3);*/


        session.setAttribute("tbCateGorys", tbCateGorys);
        session.setAttribute("videos1", videos1);
        session.setAttribute("videos2", videos2);
        session.setAttribute("videos3", videos3);
        session.setAttribute("videos4", videos4);
        session.setAttribute("videos5", videos5);
        session.setAttribute("videos6", videos6);

        return "redirect:indexs.jsp";
    }

    /**
     * 分类列表
     *
     * @param cateGoryId
     * @param video
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/showCategory")
    public String showCategory(@RequestParam(value = "categoryId") Long cateGoryId, TbVideo video, HttpServletRequest request, HttpSession session) {

        List<TbCategory> tbCateGorys2 = this.categoryService.getTbCateGorys();
        video.setCategoryId(cateGoryId);
        List<TbVideo> list = this.videoService.getMovieByCategory(cateGoryId);

        String showName = null;
        for (TbCategory tbCategory : tbCateGorys2) {
            if (tbCategory.getId() == cateGoryId) {
                showName = tbCategory.getCategoryName();
            }
        }
        session.setAttribute("tbCateGorys2", tbCateGorys2);
        session.setAttribute("showName", showName);
        session.setAttribute("movies", list);
        return "redirect:gallery.jsp";
    }

    /**
     * 视频播放
     *
     * @param session
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "player", produces = "text/plain;charset=utf-8")
    public String playMovie(HttpSession session, HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id) {
        /*String[] ids = video.split("\\.");*/
        /*Integer videoId = (Integer) ids[0];*/
        TbVideo videoResult = this.videoService.getMoviesByID(id);
        TbVideo videos = new TbVideo();
        videos.setId(videoResult.getId());
        videos.setPlays(videoResult.getPlays() + 1);
        this.videoService.updateByCondiction(videos);
        if (null != videoResult.getAdminId()) {
            String admin = "admin";
            session.setAttribute("userName", admin);
        } else {
            TbUser user = (TbUser) session.getAttribute("user");
            session.setAttribute("userName", user.getUserName());
        }
        TbVideo tbVideo = new TbVideo();
        tbVideo.setId(id);
        List<TbRecomment> recomments = recommentService.RecommentList(tbVideo);
        for (TbRecomment recomment : recomments) {
            recomment.setTime(getTime(new Date(), recomment.getCreatetime()));
        }
        session.setAttribute("videoResult", videoResult);
        session.setAttribute("recomments", recomments);

        return "redirect:single.jsp";
    }

    /**
     * 用户个人视频记录列表
     *
     * @param index
     * @param video
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/getMoviesByUserID")
    public String getMoviesByUserID(TbVideo video, HttpSession session, HttpServletRequest request) {

        if (video.getCurrentPage() == 0) {
            video.setCurrentPage(1);
        }

        TbUser user = (TbUser) session.getAttribute("user");
        video.setUserId(user.getId());
        Integer index2 = (video.getCurrentPage() - 1) * video.getPageSize();
        video.setStartLimitPos(index2);
        List<TbVideo> videoList = this.videoService.getMoviesByUserID(video);
        request.setAttribute("videoList", videoList);
        request.setAttribute("page", video);
        return "filmManage";
    }

    /**
     * 用户上传视屏 分类回显
     *
     * @param session
     * @return
     */
    @RequestMapping("toUpload")
    public String toUpload(HttpSession session) {
        List<TbCategory> categories = this.categoryService.getTbCateGorys();
        if (null != categories) {
            session.setAttribute("categories", categories);
        }
        return "redirect:upload.jsp";
    }

    /**
     * 根据用户id与影片id来删除影片
     *
     * @param videoId
     * @param session
     * @return
     */
    @RequestMapping("/delMovie")
    public String delMovie(HttpSession session, HttpServletRequest request, Integer videoId) {
        Boolean result = this.videoService.delTbVideo(videoId);
        if (result) {
            request.setAttribute("error", "Delete success,Please again");
            return "redirect:getMoviesByUserID";
        } else {
            request.setAttribute("error", "Delete error,Please again");
            return "error";
        }

    }

    /**
     * 根据影片id编辑影片
     */
    @RequestMapping("/editMovie")
    public String getMovieById(TbVideo video, HttpServletRequest request, Integer id) {
        TbUser user = (TbUser) request.getSession().getAttribute("user");
        video.setId(id);
        TbVideo vd = this.videoService.getMoviesByID(video.getId());
        request.setAttribute("mv", vd);
        video.setUserId(user.getId());
        video.setVideoName(vd.getVideoName());
        video.setOptions(vd.getOptions());
        video.setUserName(vd.getUserName());
        video.setMessage(vd.getMessage());
        video.setGrade(vd.getGrade());
        video.setImgType(vd.getImgType());
        request.setAttribute("video", video);
        return "editMovie";
    }

    /**
     * 更新视屏
     *
     * @param video
     * @param request
     * @return
     */
    @RequestMapping(value = "/SaveEditMovie")
    public String saveEditMovie(TbVideo video, HttpServletRequest request) {
        int rember = video.getCurrentPage();
        this.videoService.updateByCondiction(video);
        video.setCurrentPage(rember);
        request.setAttribute("video", video);
        return "editMessage";
    }

    @RequestMapping("/searchVideo")
    public String searchVideo(QueryVO queryVO, HttpServletRequest request) {
        List<TbVideo> videos = videoService.searchVideo(queryVO);
        if (videos.size() > 0) {
            request.setAttribute("videoResult", videos.get(0));
            return "redirect:single.jsp";
        } else {
            request.setAttribute("error", "Not Find Anything！");
            return "error";
        }

    }

    public static String getTime(Date currentTime, Date firstTime) {
        long diff = currentTime.getTime() - firstTime.getTime();
        Calendar currentTimes = dataToCalendar(currentTime);
        Calendar firstTimes = dataToCalendar(firstTime);
        int year = currentTimes.get(Calendar.YEAR) - firstTimes.get(Calendar.YEAR);
        int month = currentTimes.get(Calendar.MONTH) - firstTimes.get(Calendar.MONTH);
        int day = currentTimes.get(Calendar.DAY_OF_MONTH) - firstTimes.get(Calendar.DAY_OF_MONTH);
        if (day < 0) {
            month -= 1;
            currentTimes.add(Calendar.MONTH, -1);
            day = day + currentTimes.getActualMaximum(Calendar.DAY_OF_MONTH);//获取日
        }
        if (month < 0) {
            month = (month + 12) % 12;//获取月
            year--;
        }
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        long s = (diff / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60);
        if (day < 1) {
            if (hours < 1) {
                return minutes + " minute";
            }
            return hours + " day" + minutes + " minute";

        }
        return day + " day" + minutes + " minutews";
    }

    private static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
