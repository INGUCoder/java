package com.example.demo.Controller;

import com.example.demo.domain.Fazhan;
import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.FaZhanMapper;
import com.example.demo.repository.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/fazhan")
public class FazhanController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    FaZhanMapper faZhanMapper;

    //显示所有党员发展信息
    @RequestMapping("/showList")
    public String showList(Model model){
        List<Fazhan> list = faZhanMapper.selectAll();
        model.addAttribute("length",list.size());
        model.addAttribute("list",list);
        return "fazhan-list";
    }
    //删除页面
    @RequestMapping("/deletePage")
    public String deletePage(){
        return "fazhan-del";
    }
    //删除
    @RequestMapping("/delete")
    public  String delete(HttpServletRequest request){
        String bianhao = request.getParameter("bianhao");
        faZhanMapper.selectByBianHao(bianhao);
        return "fazhan-del";
    }
    //修改页面
    @RequestMapping("/updatePage")
    public String updatePage(){
        return "fazhan-alter";
    }
//修改
    @RequestMapping("/update")
    public String update(HttpServletRequest request,Model model){
        String bianhao = request.getParameter("bianhao");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String status = request.getParameter("status");
        String biaoxian = request.getParameter("biaoxian");
        String chuqing = request.getParameter("chuqing");
        String workstatus = request.getParameter("workstatus");
        String sixiang = request.getParameter("sixiang");
        String idcard = request.getParameter("idcard");
        faZhanMapper.update(name,sex,status,biaoxian,chuqing,workstatus,sixiang,idcard,bianhao);
        return "fahzhanupdate-Success";

    }
    //查找页面
@RequestMapping("/findPage")
    public String findPage(){
        return "fazhan-search";
}
    @RequestMapping("/find")
    public String find(HttpServletRequest request,Model model){
        String bianhao = request.getParameter("bianhao");
        Fazhan fazhan = faZhanMapper.selectByBianHao(bianhao);
        model.addAttribute("fazhan",fazhan);
        return "fazhaninfo";

    }

    //添加信息页面
    @RequestMapping("/addPage")
    public String addPage(){
        return "fazhan-add";
    }

    //添加
    @RequestMapping("/add")
    public String add(HttpServletRequest request,Model model){
        String bianhao = request.getParameter("bianhao");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String status = request.getParameter("status");
        String biaoxian = request.getParameter("biaoxian");
        String chuqing = request.getParameter("chuqing");
        String workstatus = request.getParameter("workstatus");
        String sixiang = request.getParameter("sixiang");
        String idcard = request.getParameter("idcard");
        faZhanMapper.add(bianhao,name,sex,status,biaoxian,chuqing,workstatus,sixiang,idcard);
        return "fazhanadd-Success";
    }

    //查看个人工作发展情况
    @RequestMapping("/userindex")
    public String userindex(HttpServletRequest request,Model model){

        HttpSession session = request.getSession(false);
        String phone = (String) session.getAttribute("phone");
        Users users = userMapper.selectByPhone(phone);
        Fazhan fazhan  =faZhanMapper.selectByBianHao(users.getBianhao());

        model.addAttribute("fazhan",fazhan);
        return "userinfoFazhan";
    }

}
