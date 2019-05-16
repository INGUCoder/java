package com.svideo.controller;

import com.svideo.domain.TbAdmin;
import com.svideo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 后台登录  localhost:8080/login.jsp 登录后台 默认登录为前端页面
     *
     * @param tbAdmin
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/Login")
    public String adminLogin(TbAdmin tbAdmin, HttpSession session, HttpServletRequest request) {
        TbAdmin adminResult = null;
        try {
            adminResult = this.adminService.adminLogin(tbAdmin);
            if (null != adminResult) {
                session.setAttribute("admin", adminResult);
                return "index";
            } else {
                request.setAttribute("error", "Login error,Please again");
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Login error,Please again");
            return "error";
        }
    }

    /**
     * 后台退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/LoginOut")
    public String adminLogout(HttpSession session) {
        session.getAttribute("admin");
        session.removeAttribute("admin");
        return "redirect:login.jsp";
    }

}
