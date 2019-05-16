package com.svideo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svideo.domain.*;
import com.svideo.service.CommentSevice;
import com.svideo.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.File;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentSevice commentSevice;

    /**
     * 后台获取用户列表
     *
     * @param session
     * @param currPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/userList")
    public String list(HttpSession session, Integer currPage, Integer pageSize) {
        PageBean<TbUser> list = userService.getUserList(currPage, pageSize);
        if (list != null) {
            session.setAttribute("Result", list);
        }
        return "account";
    }

    /**
     * 后台删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("userDelete")
    @ResponseBody
    public Map<String, Object> delete(Long id) {
        Map<String, Object> resultmap = new HashMap<>();
        if (id != null) {
            if (userService.delTbUser(id)) {
                resultmap.put("result", "删除分类成功");
            } else {
                resultmap.put("result", "删除分类失败");
            }
        }
        return resultmap;
    }

    /**
     * 返回注册页
     *
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegis() {
        return "register";
    }

    /**
     * 前端用户登录
     *
     * @param user
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "userLogin")
    public String userLogin(TbUser user, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        TbUser userResult = null;
        System.out.println(user.getUserPassword());
        try {
            userResult = this.userService.userLogin(user);
            if (null != userResult) {
                System.out.println(userResult.getUserPassword());
                if (userResult.getUserPassword().equals(user.getUserPassword())) {
                    session.setAttribute("user", userResult);
                    return "redirect:index.jsp";
                } else {
                    request.setAttribute("error", "Passworld Error ,Please login again!");
                    return "error";
                }
            } else {
                request.setCharacterEncoding("utf-8");
                request.setAttribute("error", "UserName Erroe ,Please input again");
                return "error";
            }
        } catch (Exception e) {

            e.printStackTrace();
            request.setAttribute("error", "UserName or password error");
            return "error";
        }

    }

    /**
     * adjx 异步验证用户名
     *
     * @param user
     * @return
     */
    @RequestMapping("/ajaxChcekUserName")
    public @ResponseBody
    Map<String, Object> ajaxChcekUserName(TbUser user) {

        boolean ret = this.userService.findUserByUserName(user.getUserName());

        Map<String, Object> userMap = new HashMap<String, Object>();
        if (ret) {
            userMap.put("reg", "true");
        } else {
            userMap.put("reg", "false");
        }
        return userMap;
    }

    /**
     * ajax 验证密码
     *
     * @param user
     * @return
     */
    @RequestMapping("/ajaxChcekPass")
    public @ResponseBody
    Map<String, Object> ajaxChcekPass(TbUser user) {

        TbUser userResult = null;
        Map<String, Object> passMap = new HashMap<String, Object>();
        try {
            userResult = this.userService.userLogin(user);

            if (null != userResult) {
                passMap.put("reg", "true");
            } else {
                passMap.put("reg", "false");
            }
        } catch (Exception e) {
            e.printStackTrace();
            passMap.put("reg", "false");
        }


        return passMap;
    }

    /**
     * 验证登录用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/ajaxChcekUserPassByUserName")
    public @ResponseBody
    Map<String, Object> ajaxChcekUserPassByUserName(TbUser user) {
        Map<String, Object> userMap = new HashMap<String, Object>();
        TbUser ret = null;
        try {
            ret = this.userService.userLogin(user);
            if (null != ret) {

                userMap.put("reg", "true");

            } else {
                userMap.put("reg", "false");
            }
        } catch (Exception e) {
            e.printStackTrace();
            userMap.put("reg", "false");
        }
        return userMap;
    }

    /**
     * 用户修改信息
     *
     * @param user
     * @param id
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/editUser")
    public String editUserInfo(
            TbUser user, Integer id, HttpSession session, HttpServletRequest request) {
        String newPass = request.getParameter("newUserPassword");
        if (null != newPass && !"".equals(newPass)) {
            user.setUserPassword(newPass);
        } else {
            user.setUserPassword(null);
        }
        TbUser userResult = this.userService.updateUser(user);
        if (null != userResult) {
            session.removeAttribute("user");
        }
        return "redirect:index.jsp";
    }

    /**
     * 用户注册
     *
     * @param user
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userRegister(@RequestParam(value = "fileName", required = false) MultipartFile fileName, TbUser user, HttpSession session,
                               HttpServletRequest request) throws IOException {

        Date date = new Date();
        user.setRegisterDate(date);
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
                user.setUserPrice(newUrl);
                user.setUserNickname(user.getUserName());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        int flag = this.userService.userRegister(user);
        if (flag > 0) {
            session.setAttribute("message", "Register Success");
            return "right";
        }
        return "redirect:/toRegister";
    }

    /**
     * 用户退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/userLogout")
    public String userLogout(HttpSession session) {
        session.getAttribute("user");
        session.removeAttribute("user");
        return "redirect:loginIndex.jsp";
    }


    /**
     * 根据id添加收藏记录
     *
     * @param id
     */
    @RequestMapping("/add_Like")
    public String addLike(Long id, HttpSession session, HttpServletRequest request) {
        TbUser user = (TbUser) session.getAttribute("user");
        if (null == user) {
            request.setAttribute("error", "Please login!");
            return "error";
        }

        Long userId = user.getId();
        int result = commentSevice.addVideo(id, userId);

        if (result > 0) {
            return "redirect:single.jsp";
        } else {
            request.setAttribute("error", "Add error ,Please add again");
            return "error";
        }

    }


    /**
     * 获取我的收藏
     *
     * @param request
     * @param session
     * @param video
     * @return
     */
    @RequestMapping("/likeList")
    public String likeList(HttpServletRequest request, HttpSession session, TbVideo video) {
        if (video.getCurrentPage() == 0) {
            video.setCurrentPage(1);
        }
        TbUser user = (TbUser) session.getAttribute("user");
        Integer index2 = (video.getCurrentPage() - 1) * video.getPageSize();
        video.setStartLimitPos(index2);
        List<TbVideo> resultList = commentSevice.getLikeList(video, user.getId());
        System.out.println(resultList);
        request.setAttribute("videoList", resultList);
        request.setAttribute("page", video);
        return "userLike";
    }

    @RequestMapping("/delLikeVideo")
    public String delLike(@RequestParam(value = "id") Long id, HttpServletRequest request) {
        Integer result = commentSevice.delLike(id);
        if (result > 0) {
            return "redirect:likeList";
        }
        return "error";
    }

}
