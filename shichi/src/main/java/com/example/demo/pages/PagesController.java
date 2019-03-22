/**
 * 页面跳转控制类
 */
package com.example.demo.pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pages")
public class PagesController {
   //注册页面
    @RequestMapping("/register")
    public String register(){
        return "register" ;
    }
    //登录页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //首页
    @RequestMapping("/index")
    public String index(){

       return "ccc";
    }
    @RequestMapping("/ccc")
    public String ccc(){
        return "ccc";
    }
    //显示所有留言
    @RequestMapping("/allwords")
    public String allwords(){
        return "allwords";
    }
    //管理员登录
    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "adminlogin";
    }
    //修改个人信息
    @RequestMapping("/updateusers")
    public String updateusers(){
        return "updateUsers";
    }

    //main页面   主页
    @RequestMapping("/main")
    public String main(){
        return "main";

    }

}
