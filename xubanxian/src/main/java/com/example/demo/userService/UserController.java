/**
 *
 * 用户页面处理类
 */
package com.example.demo.userService;

import com.example.demo.domain.Movie1;
import com.example.demo.domain.User;
import com.example.demo.repertories.mapper.Movie1Mapper;
import com.example.demo.repertories.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserMapper userMapper;
    //movie1 广告轮播
    @Autowired
    Movie1Mapper movie1Mapper;
    //登陆
    @RequestMapping("/login")
    public String login(HttpServletRequest request,ModelMap map){
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        System.out.println(username);
        System.out.println(password);
        User user = userMapper.userLogin(username,password);
        System.out.println("-----------------------------");
        //System.out.println(user.getEmail());

        //显示广告内容（movie1）内容在页面上
        Movie1 movie11 = movie1Mapper.selectById(1);
        Movie1 movie12 = movie1Mapper.selectById(2);
        Movie1 movie13 = movie1Mapper.selectById(3);
        Movie1 movie14 = movie1Mapper.selectById(4);
        Movie1 movie15 = movie1Mapper.selectById(5);

        map.addAttribute("movie1pictureaddress1",movie11.getPictureaddress());
        map.addAttribute("movie1name1",movie11.getName());
        map.addAttribute("movie1info1",movie11.getInfo());


        map.addAttribute("");



        return "loginSuccess";


    }
    //用户注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        String email = (String) request.getAttribute("email");
        Long phone = (Long) request.getAttribute("phone");
        System.out.println(email);
        userMapper.addUser(username,password,email,phone);
        return "registerSuccess";

    }

}


















