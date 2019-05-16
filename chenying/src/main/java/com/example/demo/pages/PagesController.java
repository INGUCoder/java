/**
 * 页面跳转控制类
 *
 * @author chengying
 */
package com.example.demo.pages;

import com.example.demo.domain.Dangshi;
import com.example.demo.domain.zhibuinfo;
import com.example.demo.repository.mapper.DangshiMapper;
import com.example.demo.repository.mapper.ZhibuInfoMapper;
import com.example.demo.repository.mapper.ZhishuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/pages")
public class PagesController {
    @Autowired
    ZhibuInfoMapper zhibuInfoMapper;
    @Autowired
    DangshiMapper dangshiMapper;

    //登录页面
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //管理员添加党员
    @RequestMapping("/member-add")
    public String adminindex() {
        return "member-add";

    }

    //管理员删除党员
    @RequestMapping("/member-del")
    public String member_del() {
        return "member-del";
    }

    //管理员查看 并管理所有党员页面
    @RequestMapping("/member-list")
    public String member_list() {
        return "member-list";
    }

    //管理员登录页面
    @RequestMapping("/admin")
    public String admin() {

        return "login";
    }

    //党员登录成功页面
    @RequestMapping("/success")
    public String success(ModelMap map) {
        Dangshi dangshi1 = dangshiMapper.selectAllById(1);
        Dangshi dangshi2 = dangshiMapper.selectAllById(2);
        Dangshi dangshi3 = dangshiMapper.selectAllById(3);
        Dangshi dangshi4 = dangshiMapper.selectAllById(4);
        Dangshi dangshi5 = dangshiMapper.selectAllById(5);
        System.out.println(dangshi1.getInfo());
        map.addAttribute("info1", dangshi1.getInfo());
        map.addAttribute("url1", dangshi1.getUrl());
        return "usersindex";
    }

    //党员登录错误处理页面
    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    //用户（党员）登录首页
    @RequestMapping("/usersindex")
    public String usersindex() {
        return "usersindex";
    }

    //注册
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    //修改党员信息
    @RequestMapping("/alternumber")
    public String alternumber() {
        return "member-alter1";
    }


    //查看党员信息
    @RequestMapping("/userinfo")
    public String userinfo() {

        return "member-search";
    }

    //党支部页面
    @RequestMapping("/zhibu")
    public String zhibu(Model model) {
        List<zhibuinfo> list = zhibuInfoMapper.selectAll();
        model.addAttribute("length", list.size());
        model.addAttribute("zhibuinfo", list);
        return "zhibu-list";
    }
}
