package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.admin.service.AdminUsersService;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("AdminController")
public class AdminComtroller {

    @Autowired
    private AdminUsersService adminUsersService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/admin/pages/list")
    public String adminList(HttpSession session, HttpServletRequest request){

        String name = (String) session.getAttribute("name");
        //如果用户名为为空  或者 redis 中没有该数据  则拒绝登陆   跳转到404页面
        if(name==""||redisService.get("userId:"+name)==null){
            return "404";
        }

        return "admin-list";


    }



}
