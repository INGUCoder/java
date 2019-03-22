
package com.example.demo.Controller;

import com.example.demo.domain.Admin;
import com.example.demo.repository.mapper.AdminMapper;
import com.example.demo.repository.mapper.ShichiMappper;
import com.example.demo.repository.mapper.UserMapper;
import com.example.demo.repository.mapper.WordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserMapper  userMapper;
    @Autowired
    WordsMapper wordsMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ShichiMappper shichiMappper;
    //管理员登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String name = request.getParameter("name") ;
        String password = request.getParameter("password");
        Admin admin = adminMapper.select(name);

        if(name.equals(admin.getName())&&password.equals(admin.getPassword())){
            return "adminsuccess";

        }  else {
            return "AdminFail";
        }

    }
    //查询所有用户信息
    @RequestMapping("/select")
    public  String select(HttpServletRequest request){
        return "null";

    }
    //删除垃圾评论
    @RequestMapping("/deletewords")
    public String deletewords(HttpServletRequest request){
        wordsMapper.delete(request.getParameter("userswords"));
        return "adminsuccess";
    }
    //插入诗词信息
    @RequestMapping("/insert")
    public String update(HttpServletRequest request){
        String  zuopingming = request.getParameter("zuopingming");
        String  zuopinginfo=request.getParameter("zuopinginfo");
        String  zuozhe = request.getParameter("zuozhe");
        String  zuozheinfo = request.getParameter("zuozheinfo");
        shichiMappper.insertShichi(zuopingming,zuopinginfo,zuozhe,zuozheinfo);
        return "adminsuccess";

    }
    //删除诗词信息
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request){

       shichiMappper.delete(request.getParameter("shichiping"));
        return "adminsuccess";
    }

}
