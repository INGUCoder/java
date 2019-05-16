/**
 * 管理员登录跳转页面
 *
 * @author chen ying
 */
package com.example.demo.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminPages")
public class AdminPagesController {
    //管理员登录失败
    @RequestMapping("/fail")
    public String fail() {
        return "adminfail";
    }

    //管理员登录成功
    @RequestMapping("/success")
    public String success() {


        return "adminsuccess";
    }
}
