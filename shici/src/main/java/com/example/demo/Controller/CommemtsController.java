package com.example.demo.Controller;

import com.example.demo.domain.Comments;
import com.example.demo.domain.Shichi;
import com.example.demo.repository.mapper.CommentsMapper;
import com.example.demo.repository.mapper.ShichiMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommemtsController {
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    ShichiMappper shichiMappper;
    //插入评论
    ///comments/add
    @RequestMapping("/add")
    public String add(HttpServletRequest request,Model model){
        String username = request.getParameter("youkename");
        String commnets = request.getParameter("pinglun");
        String zuopingming = request.getParameter("shichi.zuopingming");
        commentsMapper.insertComments(zuopingming,username,commnets);
        HttpSession session = request.getSession();
        session.setAttribute("zuopingming",zuopingming);
        System.out.println("-----Test-------");
        System.out.println(zuopingming+username+commnets);
        System.out.println(zuopingming+"Test");
        System.out.println(zuopingming);
        System.out.println("-----Test-------");
        List<Shichi> list = shichiMappper.selectAll();
        List<Comments> list1 = commentsMapper.selectAllComments(zuopingming);
        Integer nums = list1.size();
        model.addAttribute("allshichi",list);
        model.addAttribute("nums",nums);
        model.addAttribute("commentslist",list1);
        return "ccc";

    }

}
