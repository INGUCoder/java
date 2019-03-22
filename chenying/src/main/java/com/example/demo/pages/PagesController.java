/**
 * 页面跳转控制类
 * @author chengying
 *
 */
package com.example.demo.pages;
import com.example.demo.domain.Dangshi;
import com.example.demo.repository.mapper.DangshiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pages")
public class PagesController {
    @Autowired
    DangshiMapper dangshiMapper;
    //登录页面
    @RequestMapping("/login")
    public String  login(){
        return "login";
    }
    //管理员登陆后管理信息  模板
    @RequestMapping("/adminindex")
    public String  adminindex(){
        return "adminindex";
    }
    //管理员登录页面
    @RequestMapping("/admin")
    public String admin(){

        return "login";
    }
    //党员登录成功页面
    @RequestMapping("/success")
    public String success(ModelMap  map){
        Dangshi dangshi1=dangshiMapper.selectAllById(1);
        Dangshi dangshi2=dangshiMapper.selectAllById(2);
        Dangshi dangshi3=dangshiMapper.selectAllById(3);
        Dangshi dangshi4=dangshiMapper.selectAllById(4);
        Dangshi dangshi5=dangshiMapper.selectAllById(5);
        System.out.println(dangshi1.getInfo());
        map.addAttribute("info1",dangshi1.getInfo());
        map.addAttribute("url1",dangshi1.getUrl());
        return "usersindex";
    }

    //党员登录错误处理页面
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
    //用户（党员）登录首页
    @RequestMapping("/usersindex")
    public  String usersindex(){
        return "usersindex";
    }

    //注册
    @RequestMapping("/register")
    public  String register(){
        return "register";
    }
}
