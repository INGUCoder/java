package com.example.demo.Controller;

import com.example.demo.domain.Admin;
import com.example.demo.repository.mapper.AdminMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    AdminMapper adminMapper;
    @RequestMapping("/login")
    public String login(HttpServletRequest request){


        String adminname = request.getParameter("adminname");
        String adminpassword = request.getParameter("password");
        Admin admin = adminMapper.getAdminname(adminname);

        if(admin.getAdminname().equals(adminname)&&admin.getAdminpassword().equals(adminpassword)){

            return "adminsuccess";
        }
        else {

            return "adminfail";
        }

    }
    //显示所有党员信息
    @RequestMapping("/showTable")
    public Map<String,Object> getTable(@RequestParam(value = "limit") Integer limit,@RequestParam(value = "offset") Integer offset){
        return userService.PageShow(limit,offset);
    }

}
