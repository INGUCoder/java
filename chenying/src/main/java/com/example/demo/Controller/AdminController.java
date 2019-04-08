package com.example.demo.Controller;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Tongzhi;
import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.AdminMapper;
import com.example.demo.repository.mapper.TongzhiMapper;
import com.example.demo.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TongzhiMapper tongzhiMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    AdminMapper adminMapper;
    //管理员登陆 登陆成功就显示所有党员信息
    @RequestMapping("/login")
    public String login(HttpServletRequest request,Model model){


        String adminname = request.getParameter("adminname");
        String adminpassword = request.getParameter("password");
        Admin admin = adminMapper.getAdminname(adminname);
        System.out.println(adminname+"    "+adminpassword);
        List<Users> list = userMapper.selectAll();
        Integer length = list.size();
        if(admin.getAdminname().equals(adminname)&&admin.getAdminpassword().equals(adminpassword)){
            model.addAttribute("users",list);
            model.addAttribute("length",length);
            return "member-list";
        }
        else {

            return "adminfail";
        }

    }

    //管理员添加党员信息处理模块
    @RequestMapping("/member-add")
    public String memebeAdd(HttpServletRequest request,Model  model){

        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String minzu = request.getParameter("minzu");
        String jiguan = request.getParameter("jiguan");
        String phone = request.getParameter("phone");
        String idcard = request.getParameter("idcard");
        String birthday = request.getParameter("birthday");
        String work = request.getParameter("work");
        String education = request.getParameter("education");
        String address = request.getParameter("address");
        String rudangtime = request.getParameter("rudangtime");
        String people = request.getParameter("people");
        String zhibu = request.getParameter("zhibu");
        String status = request.getParameter("status");
        String bianhao = request.getParameter("bianhao");
        String zhibubianhao = request.getParameter("zhibubianhao");
        System.out.println("------TEST-------");
        adminMapper.numbersAdd(username,sex,minzu,jiguan,phone,idcard,birthday,work,education,address,rudangtime,people,zhibu,status,bianhao,zhibubianhao);
        List list = userMapper.selectAll();
        Integer length = list.size();
        model.addAttribute("users",list);
        model.addAttribute("length",length);
        return "member-list";
    }
    //管理员删除党员
    @RequestMapping("/number-delete")
    public String  mbemberDel(HttpServletRequest request,Model model){
        String bianhao = request.getParameter("bianhao");
        System.out.println("----TEST----");
        adminMapper.numberDelete(bianhao);
        return "membeDel-Success";
    }
//统一页面跳转显示页面
@RequestMapping("/showlist")
    public String showList(Model model){
    List list = userMapper.selectAll();
    Integer length = list.size();
    model.addAttribute("users",list);
    model.addAttribute("length",length);
    return "member-list";

}
//修改党员信息
@RequestMapping("/member-alter")
public String memberAlter(Model model,HttpServletRequest request){
        String  username = request.getParameter("username");
    String age1 = request.getParameter("age");
    Integer age =Integer.parseInt(age1);
    String sex = request.getParameter("sex");
    String zhibu = request.getParameter("zhibu");
    String time = request.getParameter("time");
    String education = request.getParameter("education");
    String address = request.getParameter("address");
    Integer dangfeiyear = Integer.parseInt(request.getParameter("dangfeiyear"));
    Integer dangfeiyears = Integer.parseInt(request.getParameter("dangfeiyears"));
    Integer yijingdangfei = Integer.parseInt(request.getParameter("yijingdangfei"));
    Integer xuyaodangfei = Integer.parseInt(request.getParameter("xuyaodangfei"));


    return "membeAlter-Success";

}
//发布事务页面
    @RequestMapping("/writePage")
    public String writePage(){
        return "shiwu-add";
    }
    //发布事务
    @RequestMapping("/write")
    public String write(HttpServletRequest request){
        String info = request.getParameter("info");
        String url = request.getParameter("url");
        System.out.println(info);
        tongzhiMapper.Add(info,url);
        return "shiwu-add-success";

    }
    //查看已发布的事务
    @RequestMapping("/shiwu")
    public String shiwu(Model model){
        List<Tongzhi> tongzhiList = tongzhiMapper.selectAll();
        model.addAttribute("length",tongzhiList.size());
        model.addAttribute("tongzhiList",tongzhiList);
        return "shiwu-list";

    }
    //删除事务page
    @RequestMapping("/deletePage")
    public String deletePage(){
        return "shiwu-delete";
    }
    //删除事务
    @RequestMapping("/deleteShiwu")
    public String deleteShiwu(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        tongzhiMapper.delete(id);
        return "shiwuDel-Success";
    }



}
