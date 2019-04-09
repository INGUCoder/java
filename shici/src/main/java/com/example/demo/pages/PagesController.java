/**
 * 页面跳转控制类
 */
package com.example.demo.pages;
import com.example.demo.domain.Shichi;
import com.example.demo.repository.mapper.ShichiMappper;
import com.example.demo.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/pages")
public class PagesController {
    @Autowired
    ShichiMappper shichiMappper;

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
        return "adminLogin";
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
    //显示所有诗词信息
    @RequestMapping("/showall")
    public String showAll(Model model){
        List<Shichi> list = shichiMappper.selectAll();
        System.out.println(list.size());
        System.out.println("--------------------");
        model.addAttribute("allshichi",list);

        return "ccc";
    }

    //测试
    @RequestMapping("/test")
    public String test(){
        return "pinglun";
    }
    //发布诗词页面
    @RequestMapping("/userInsertShichi")
    public String userInsertShichi(){
        return "userInsertShichi";
    }


    //显示管理页面  所有用户后台
    @RequestMapping("/allusers")
    public String allUsers(){
        return "member-list";
    }


    //添加用户页面
    @RequestMapping("/adduser")
    public String addUser(){
        return "member-add";
    }
    //添加诗词
    @RequestMapping("/addshichi")
    public String addshichi(){
        return "shichi-add";
    }
    //删除用户
    @RequestMapping("/admindel")
    public String admindel(){
        return "member-del";
    }
    //发布诗词页面
    @RequestMapping("/shichi-add")
    public String shichiAdd(){
        return "shichi-add";
    }
}
