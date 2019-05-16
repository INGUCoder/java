package com.example.demo.Controller;

import com.example.demo.domain.Users;
import com.example.demo.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/tongji")
public class TongjiController {
    @Autowired
    UserMapper userMapper;

    //统计页面
    @RequestMapping("/tongjiPage")
    public String tongjiPage() {
        return "tongji-search1";
    }

    //
    @RequestMapping("/numberTongji")
    public String tongJi(HttpServletRequest request, Model model) {

        String temp = request.getParameter("temp");
        List<Users> list1 = userMapper.selectByzhibu(temp);
        List<Users> list2 = userMapper.selectBySex(temp);
        List<Users> list3 = userMapper.selectByRudangtime(temp);
        List<Users> list4 = userMapper.selectByEducation(temp);
        if (list1.size() > 0) {
            List<Users> list = list1;
            model.addAttribute("length", list.size());
            model.addAttribute("users", list);
            return "tongji-list";
        } else if (list2.size() > 0) {
            List<Users> list = list2;
            model.addAttribute("length", list.size());
            model.addAttribute("users", list);
            return "tongji-list";
        } else if (list3.size() > 0) {
            List<Users> list = list3;
            model.addAttribute("length", list.size());
            model.addAttribute("users", list);
            return "tongji-list";
        } else if (list4.size() > 0) {
            List<Users> list = list4;
            model.addAttribute("length", list.size());
            model.addAttribute("users", list);
            return "tongji-list";
        }
        return "查询失败,请按正确的关键字查询";

    }
}
